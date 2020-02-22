package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ApiObjects {

	@FindBy (id = "api_key_form_name")
	public WebElement txtAPIKey;

	@FindBy (name = "commit")
	public WebElement btnGenerate;

	@FindBy (xpath = "//table[@class='table api-keys']/tbody")
	public WebElement tblApi;


}
