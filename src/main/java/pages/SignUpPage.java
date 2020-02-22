package pages;
import objects.SignUpObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import libs.Common;
import libs.Config;
import org.testng.Assert;

public class SignUpPage {

	private Common _common = new Common();
	private SignUpObjects _SignUpObjects;

	/**
	 * Login
	 * @param driver
	 */
	public SignUpPage(WebDriver driver) {
		_SignUpObjects = new SignUpObjects();
		PageFactory.initElements(driver, _SignUpObjects);
		//PageFactory.initElements(driver, _SignUpStepTwoObjects);
	}

	public void setFirstName(WebDriver driver, String firstname) {
		_common.setText(driver, _SignUpObjects.txtFirstName, firstname);
	}

	public void setLastName(WebDriver driver, String lastname) {
		_common.setText(driver, _SignUpObjects.txtLastName, lastname);
	}

	public void setEmail(WebDriver driver, String email) {
		_common.setText(driver, _SignUpObjects.txtEmail, email);
	}

	public void selectMonth(WebDriver driver, String month) {
		_common.clickObject(driver, _SignUpObjects.lsMonthHolder);
		_common.setText(driver, _SignUpObjects.lsMonth, month);
		_common.sendKeys(driver, _SignUpObjects.lsMonth, Keys.ENTER);
	}

	public void selectDay(WebDriver driver, String day) {
		_common.clickObject(driver, _SignUpObjects.lsDayHolder);
		_common.setText(driver, _SignUpObjects.lsDay, day);
		_common.sendKeys(driver, _SignUpObjects.lsDay, Keys.ENTER);

	}

	public void selectYear(WebDriver driver, String year) {
		_common.clickObject(driver, _SignUpObjects.lsYearHolder);
		_common.setText(driver, _SignUpObjects.lsYear, year);
		_common.sendKeys(driver, _SignUpObjects.lsYear, Keys.ENTER);
	}

//	public void selectGender(WebDriver driver, String gender) {
//		_common.setText(driver, _SignUpObjects.lsGender, gender);
//	}

	/**
	 * select gender
	 * @param driver
	 * @param gender
	 */
	public void selectGender1(WebDriver driver, String gender) {
		if (gender.equalsIgnoreCase("female")) {
			_common.clickObject(driver, _SignUpObjects.radioFemale);
		} else if  (gender.equalsIgnoreCase("male")) {
			_common.clickObject(driver, _SignUpObjects.radioMale);
		} else {
			//log, the input gender is undefined
		}
	}

	public void selectGender(WebDriver driver, String gender) {
		_common.clickObject(driver, _SignUpObjects.lsGenderHolder);
		_common.setText(driver, _SignUpObjects.lsGender, gender);
		_common.sendKeys(driver, _SignUpObjects.lsGender, Keys.ENTER);
	}

	public void clickNextLocation(WebDriver driver) {
		_common.clickObject(driver, _SignUpObjects.btnNextLocation);
	}

	public void addLanguages(WebDriver driver, String languages) {
		String[] arLanguages = languages.split(Config.getConfig("DELIMITER"));
		for (int i = 0; i < arLanguages.length; i++) {
			_common.setText(driver, _SignUpObjects.lsLanguages, arLanguages[i] );
			_common.sendKeys(driver, _SignUpObjects.lsLanguages, Keys.ENTER);
		}
	}

	public void verifySignUpSuccess(WebDriver driver) {
//		Assert.assertEquals(true, _common.checkExists(driver, By.xpath(_SignUpObjects.lblStep2Xpath)));
        Assert.assertEquals(true, _common.checkExists(driver, By.xpath(_SignUpObjects.lblAddYourAddressXpath)));

	}

	public void verifySignUpFailed(WebDriver driver) {
		Assert.assertNotEquals(true, _common.checkExists(driver, By.xpath(_SignUpObjects.lblStep2Xpath)));
	}

	public void signup(WebDriver driver, String firstname, String lastname, String email, String month, String day, String year, String gender, String language) {
		setFirstName(driver, firstname);
		setLastName(driver, lastname);
		setEmail(driver,email);
		selectDay(driver,day);
		selectMonth(driver,month);
		selectYear(driver,year);
		selectGender(driver,gender);
		addLanguages(driver,language);
		clickNextLocation(driver);
	}
}
