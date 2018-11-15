package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723/wd/hub";
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");
        //capabilities.setCapability("app", "/Users/rusina/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        capabilities.setCapability("app", "/Users/marinarusina/Documents/GitHub/JavaAppiumAutomation/apks/Wikipedia.app");
        driver = new IOSDriver(new URL(AppiumUrl), capabilities);
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


}