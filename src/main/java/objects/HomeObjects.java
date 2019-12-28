package objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomeObjects {
	
	// New Customer link
	@FindBy (linkText = "New Customer")
	public WebElement lnkNewCustomer; 
		
	// Manger Id label 
	@FindBy (xpath = "//*[starts-with(text(),'Manger Id')]")
	public WebElement lblMangerId; 
	
}
