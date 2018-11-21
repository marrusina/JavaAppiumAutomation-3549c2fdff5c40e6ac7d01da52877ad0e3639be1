package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject
{
    static {

        ARTICLE_BY_TITLE_TEMPLATE = "xpath://XCUIElementTypeLink[contains(@name,'Java (programming language)')]";
    }

    public IOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
