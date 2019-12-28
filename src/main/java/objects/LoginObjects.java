package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginObjects {
	
	// User Id textbox
	@FindBy (name = "uid")
	public WebElement txtUserId; 
		
	// Password textbox
	@FindBy (name = "password")
	public WebElement txtPassword; 

	// Login button
	@FindBy (name = "btnLogin")
	public WebElement btnLogin; 

}
