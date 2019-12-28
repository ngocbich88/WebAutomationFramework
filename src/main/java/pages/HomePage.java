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
	//private Logger log = Logger.getLogger(this.getClass());
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, _homeObjects);
	}
	
	
	/**
	 * Verify Manner Id label by text displayed
	 * @param driver
	 */
	public void verifyMannerIdLabel(WebDriver driver) {
		String expected = "Manger Id" + " " + Config.getConfig("username");
		Assert.assertEquals(_common.getText(driver, _homeObjects.lblMangerId), expected);
	}
}
