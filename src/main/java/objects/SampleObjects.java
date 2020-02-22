package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SampleObjects {

	@FindBy (xpath = "//*[@name='optradio' and @value='Male']")
	public WebElement radioBtnMale;


	// another option is: //label[text()='Option 1']//self::input
	// html code is:
	//	<label>
	//	<input type="checkbox" class="cb1-element" value="">Option 1
	//	</label>
	@FindBy (xpath = "//label[text()='Option 1']//child::input")
	public WebElement checkboxOption1;


	@FindBy(id ="select-demo")
	public WebElement select;

	@FindBy(xpath ="//*[contains(text(),'Select Country')]//following::select[1]")
	public WebElement selectjquery;

	@FindBy(xpath ="//*[contains(text(),'Select a file')]//following::select[1]")
	public WebElement selectwithcatergorized;

	@FindBy(id ="multi-select")
	public WebElement multipleSelect;

	public String groupedDropdownListXpath = "//select[@name='files']/";

	@FindBy(css = "table.table-hover")
	public WebElement tablePagnition;

//	@FindBy(xpath = "//*[contains(text(), 'Season')]//ancestor::table")
//	public WebElement tablePagnition;


	//table[@class='table table-hover']
	public String tableXpath = "//table[@class='table table-hover']";

	@FindBy(xpath="//*[text()='Java Script Confirm Box']//following::button[text()='Click me!']")	
	public WebElement btnClickme;
	
	@FindBy(xpath="//button[text()='Click for Prompt Box']")
	public WebElement btnClickforPrompt;
	
	//ngoc: this object cant be click (even move to the object because it's overlapped in small screen, need retest)
	//object located in: BASEURL=https://www.toolsqa.com/handling-alerts-using-selenium-webdriver
//	@FindBy(xpath="//button[text()='Prompt Pop up']")
//	public WebElement btnClickforPrompt1;

	@FindBy(id="prompt")
	public WebElement btnClickforPrompt1;

//	@FindBy(linkText="here")
//	public WebElement btnClickforPrompt1;
	
	@FindBy(xpath="//*[@title='Follow @seleniumeasy on Facebook']")
	public WebElement btnLikeUsOnFacebook;
	
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	
	@FindBy(xpath="//*[text()='apache-jmeter-5.2.1.zip']")		
	public WebElement lnkDownload;
	
}
