package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.LibBase;

/**
 * @author NgocNTB6
 *
 */

public class Common extends LibBase{	
	
	
	public Common() {

	}		
	
	
	/** Launch a browser
	 * @param driver
	 * @throws Exception 
	 */
	public void NavigateURL(WebDriver driver, String sURL) throws Exception
	{				
		driver.get(sURL);		
		
		// Maximize the window
		driver.manage().window().maximize();
		
	}
	

	/** Wait for an element visible, return TRUE if after timeout, element is displayed, FALSE if not
	 * @return TRUE/FALSE
	 */
	public static boolean waitForElementVisible(WebDriver driver, WebElement Element)
	{				
		 WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));		 
		 Element = wait.until(
					           ExpectedConditions.visibilityOf(Element));
 		 if(Element.isDisplayed()){
 			return true;
 		 }
		 return false;
	}
	
	
	/**	 
	 * @param driver
	 * @param e: Element want to click
	 */
	public void clickObject (WebDriver driver, WebElement e){
		if (waitForElementVisible(driver, e)){
			e.click();
		} else {			
			log.error("The object " + e.getTagName() + " is not clicked");
		}
			
	}
	
	
	/**
	 * Set text 	 
	 * @param driver
	 * @param e
	 * @param sText 
	 */
	public void setText (WebDriver driver, WebElement e, String sText) {
		if (waitForElementVisible(driver, e)){
			e.sendKeys(sText);			
		} else {		
			log.error("Could not set text to the object");
		}
	
	}
	
	
	public String getText(WebDriver driver, WebElement e) {
		
		if (waitForElementVisible(driver, e)){
			return e.getText();			
		} else {		
			log.error("Could not get text of the element");
		}
		return null;
	}
		  
}
