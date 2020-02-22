package TestApi;

import DataProvider.ApiData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiPage;

public class TestAPICreateFailed extends TestAPIBase {

    @BeforeClass
    public void Setup() {
        super.SetupApi();
    }

    @Test(timeOut = 120000, dataProvider = "ApiData", dataProviderClass = ApiData.class)
    public void CreateAPISuccessfully(String api) {
        ApiPage apiPage = new ApiPage(driver);
        apiPage.createAPIKey(driver,api);
        apiPage.verifyAPIExisted(driver, api);
    }
}
