package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginObjects {


	@FindBy (id = "user_email")
	public WebElement txtEmail;


	@FindBy (id = "user_password")
	public WebElement txtPassword;


	@FindBy (name = "commit")
	public WebElement btnSubmit;


}
