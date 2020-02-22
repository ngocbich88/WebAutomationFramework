package TestApi;

import DataProvider.ApiData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAPIDeleteSuccess extends TestAPIBase {

    @BeforeClass
    public void Setup() {
        super.SetupApi();
    }

    @Test(timeOut = 120000, dataProvider = "DeleteApiData", dataProviderClass = ApiData.class)
    public void CreateAPISuccessfully(String api) {

    }
}
