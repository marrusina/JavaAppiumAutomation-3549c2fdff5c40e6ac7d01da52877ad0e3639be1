package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

    protected static String
        //MY_LISTS_LINK = "//android.widget.ImageButton[@content-desc='Navigate up']";
    MY_LISTS_LINK;
    //MY_NAV_TAB_LAYOUT = "id:org.wikipedia:id/fragment_main_nav_tab_layout";


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
//        this.waitForElementPresent(
//                MY_NAV_TAB_LAYOUT,
//                "Cannot load tab with my lists",
//                60
//        );
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find my lists link",
                50
        );

    }

}
