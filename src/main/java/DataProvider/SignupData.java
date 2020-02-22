package DataProvider;

import org.testng.annotations.DataProvider;

public class SignupData {


    @DataProvider(name = "ValidSignUpData")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "ngoc","nguyen", "nguyenngockhmt@gmail.com", "12", "21", "1988", "Female", "Vietnamese" },
        };
    }

    @DataProvider(name = "InValidSignUpData")
    public Object[][] dataProviderMethodInvalidData() {
        return new Object[][] {
                { "ngoc","nguyen", "123", "12", "21", "1988", "Female", "Vietnamese" },
        };
    }
}
