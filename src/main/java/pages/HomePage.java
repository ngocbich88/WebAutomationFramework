package pages;
import objects.HomeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import libs.Common;
import libs.Config;

public class HomePage {

	private Common _common = new Common();
	private HomeObjects _homeObjects = new HomeObjects();
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, _homeObjects);
	}

	/**
	 * clickSignUpForFree
	 * @param driver
	 */
	public void clickSignUpForFree(WebDriver driver) {
		_common.clickObject(driver, _homeObjects.lnkSignUpForFree);
	}

	public void clickSignIn(WebDriver driver) {
		_common.clickObject(driver, _homeObjects.lnkSignIn);
	}



}
