package TestSignUp;

import DataProvider.SignupData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class TestSignUpSuccess extends TestSignUpBase {

    @BeforeClass
    public void Setup() {
        super.SetupSignUp();
    }

    @Test (timeOut = 120000, dataProvider = "ValidSignUpData", dataProviderClass = SignupData.class)
    public void TestSignUpSuccess(String firstname, String lastname, String email, String month, String day, String year, String gender, String language) {
        // Signup with valid values
        SignUpPage _signupPage = new SignUpPage(driver);
        _signupPage.signup(driver,  firstname,  lastname,  email,  month,  day,  year,  gender,  language );

        // Verify the result
        _signupPage.verifySignUpSuccess(driver);
    }

}
