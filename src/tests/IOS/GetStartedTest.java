
package tests.IOS;

import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;
import java.time.Duration;

public class GetStartedTest extends iOSTestCase {

    @Test

    public void testPassThroughWelcome()
    {

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);
        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPrefferedLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStarted();

    }
}
