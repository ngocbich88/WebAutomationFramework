package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpObjects {

	// First name textbox
	@FindBy (name = "firstName")
	public WebElement txtFirstName;

	// Last name textbox
	@FindBy (name = "lastName")
	public WebElement txtLastName;

	// Last name textbox
	@FindBy (name = "email")
	public WebElement txtEmail;

	// Month select
	@FindBy (xpath = "//*[@placeholder=\"Month\"]")
	public WebElement lsMonthHolder;

	// Month select
	@FindBy (xpath = "//*[@type='search' and @placeholder='Month']")
	public WebElement lsMonth;

	// Day select
	@FindBy (xpath = "//*[@placeholder=\"Day\"]")
	public WebElement lsDayHolder;

	// Day select
	@FindBy (xpath = "//*[@type='search' and @placeholder='Day']")
	public WebElement lsDay;

	// Year select
	@FindBy (xpath = "//*[@placeholder=\"Year\"]")
	public WebElement lsYearHolder;

	// Year select
	@FindBy (xpath = "//*[@type='search' and @placeholder='Year']")
	public WebElement lsYear;

	// Gender select
	@FindBy (xpath = "//*[@placeholder='Select a gender']")
	public WebElement lsGenderHolder;

	// Gender select
	@FindBy (xpath = "//*[@type='search' and @placeholder='Select a gender']")
	public WebElement lsGender;

	// Gender - female
	@FindBy (xpath = "//input[@type='radio' and @value='F']")
	public WebElement radioFemale;

	// Gender - male
	@FindBy (xpath = "//input[@type='radio' and @value='M']")
	public WebElement radioMale;

	// Languages select
	@FindBy (xpath = "//*[@placeholder='Add languages']")
	public WebElement lsLanguagesHolder;

	// Languages select
	@FindBy (xpath = "//*[@placeholder='Add languages']//following::input[@type='search']")
	public WebElement lsLanguages;

	// Next: Location button
	@FindBy (xpath = "//*[text()='Next: Location']")
	public WebElement btnNextLocation;

	// Step 2: Label
	public String lblStep2Xpath = "//*[contains(text(),'Step 2')]";

	// Step 2: Label
	public String lblAddYourAddressXpath = "//*[contains(text(),'Add your address')]";



}
