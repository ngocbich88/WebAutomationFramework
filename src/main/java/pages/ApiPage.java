package pages;

import libs.Common;
import objects.ApiObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ApiPage {

	private Common common = new Common();
	private ApiObjects apiObjects;

	/**
	 * Login
	 * @param driver
	 */
	public ApiPage(WebDriver driver) {
		apiObjects = new ApiObjects();
		PageFactory.initElements(driver, apiObjects);
		//PageFactory.initElements(driver, _SignUpStepTwoObjects);
	}

	public void setAPIKey(WebDriver driver, String key) {
		common.setText(driver, apiObjects.txtAPIKey, key);
//		return this.getClass();
	}


	public void clickGenerateButton(WebDriver driver) {
		common.clickObject(driver, apiObjects.btnGenerate);
//		return this.getClass();
	}

	public void createAPIKey(WebDriver driver,String key) {
		setAPIKey(driver, key);
		clickGenerateButton(driver);
	}

	public void verifyAPIExisted(WebDriver driver, String name) {
        common.checkCellValueExistInDOMByPattern(driver, apiObjects.tblApi, name);
		System.out.println(common.checkCellValueExistInDOMByPattern(driver, apiObjects.tblApi, name));
	    Assert.assertEquals(common.checkCellValueExistInDOMByPattern(driver, apiObjects.tblApi, name), true);
    }

}
