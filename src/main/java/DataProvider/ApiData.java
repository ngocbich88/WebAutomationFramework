package DataProvider;

import org.testng.annotations.DataProvider;

public class ApiData {


    @DataProvider(name = "ApiData")
    public Object[][] dataProviderCreateAPIMethod() {
        return new Object[][] {
                { "ThisIsAnAPI123" }
        };
    }


    @DataProvider(name = "EditApiData")
    public Object[][] dataProviderEditAPIMethod() {
        return new Object[][] {
                { "ThisIsAnAPI123", "ThisIsAnAPI123_new" }
        };
    }


    @DataProvider(name = "DeleteApiData")
    public Object[][] dataProviderDeleteAPIMethod() {
        return new Object[][] {
                { "ThisIsAnAPI123" }
        };
    }

}
