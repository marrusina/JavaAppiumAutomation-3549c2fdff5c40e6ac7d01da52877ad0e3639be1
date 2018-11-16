package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String DRIVER_IOS = "IOSDriver";
    private static final String DRIVER_ANDROID = "AndroidDriver";


    protected AppiumDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723/wd/hub";
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        //driver = new AndroidDriver(new URL(AppiumUrl), capabilities);

        this.rotateScreenPortrait();
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
   protected void backgroundApp(int seconds)
   {
       driver.runAppInBackground(seconds);
   }

   private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
   {
       String platform = System.getenv("PLATFORM");
       DesiredCapabilities capabilities = new DesiredCapabilities();

       if (platform.equals(PLATFORM_ANDROID))
       {
           capabilities.setCapability("platformName", "Android");
           capabilities.setCapability("deviceName", "AndroidTestDevice");
           capabilities.setCapability("platformVersion", "7.0");
           capabilities.setCapability("automationName", "Appium");
           capabilities.setCapability("appPackage", "org.wikipedia");
           capabilities.setCapability("appActivity", ".main.MainActivity");
           capabilities.setCapability("app", "/Users/marinarusina/Desktop/JavaAppiumAutomation-3549c2fdff5c40e6ac7d01da52877ad0e3639be1/apks/org.wikipedia.apk");
            driver = new AndroidDriver(new URL(AppiumUrl),capabilities);
       } else if (platform.equals(PLATFORM_IOS)) {
           capabilities.setCapability("platformName", "IOS");
           capabilities.setCapability("deviceName", "iPhone SE");
           capabilities.setCapability("platformVersion", "12.1");
           capabilities.setCapability("app", "/Users/marinarusina/Desktop/JavaAppiumAutomation-3549c2fdff5c40e6ac7d01da52877ad0e3639be1/apks/Wikipedia.app");
           driver = new IOSDriver(new URL(AppiumUrl),capabilities);

       } else {
           throw new Exception("Cannot get run platform from env variable. Platform value" + platform);
       }

       return capabilities;
   }
   

}