package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomeObjects {

	// New Customer link
	@FindBy (linkText = "Sign Up For Free")
	public WebElement lnkSignUpForFree;

	@FindBy (xpath = "//*[contains(text(), 'Sign In')]")
	public WebElement lnkSignIn;



}
