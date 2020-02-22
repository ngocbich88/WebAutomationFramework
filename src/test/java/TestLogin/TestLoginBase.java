package TestLogin;

import base.TestBase;
import libs.Config;
import pages.HomePage;

public class TestLoginBase extends TestBase {

    public void SetupSignUp() {
        // Delete cookies?
        driver.manage().deleteAllCookies();

        // Access the homepage
        driver.get(Config.getConfig("BASEURL"));

        // Click on SignUpForFree button
        HomePage _homepage = new HomePage(driver);
        _homepage.clickSignUpForFree(driver);
    }
}
