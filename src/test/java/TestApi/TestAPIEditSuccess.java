package TestApi;

import DataProvider.ApiData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAPIEditSuccess extends TestAPIBase {

    @BeforeClass
    public void Setup() {
        super.SetupApi();
    }

    @Test(timeOut = 120000, dataProvider = "EditApiData", dataProviderClass = ApiData.class)
    public void CreateAPISuccessfully(String api) {

    }
}
