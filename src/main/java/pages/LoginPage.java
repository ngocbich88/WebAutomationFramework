package pages;

import libs.Common;
import libs.Config;
import objects.LoginObjects;
import objects.SignUpObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	private Common _common = new Common();
	private LoginObjects loginObjects ;

	/**
	 * Login
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		loginObjects = new LoginObjects();
		PageFactory.initElements(driver, loginObjects);
	}

	public void setEmail(WebDriver driver, String firstname) {
		_common.setText(driver, loginObjects.txtEmail, firstname);
	}

	public void setPassword(WebDriver driver, String lastname) {
		_common.setText(driver, loginObjects.txtPassword, lastname);
	}

	public void clickSubmit(WebDriver driver) {
		_common.clickObject(driver, loginObjects.btnSubmit);
	}

	public void login(WebDriver driver, String username, String password) {
		setEmail(driver, username);
		setPassword(driver, password);
		clickSubmit(driver);
	}
}
