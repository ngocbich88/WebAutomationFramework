package TestApi;

import base.TestBase;
import libs.Config;
import pages.HomePage;
import pages.LoginPage;

public class TestAPIBase extends TestBase {
    public void SetupApi() {
        // Delete cookies?
        driver.manage().deleteAllCookies();

        // Access the homepage
        driver.get(Config.getConfig("BASEURL"));

        // Login to the page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, Config.getConfig("DEFAULT_USERNAME"), Config.getConfig("DEFAULT_PASSWORD"));

        // Access the API page
        driver.get(Config.getConfig("APIKEYURL"));
    }
}
