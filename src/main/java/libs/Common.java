package libs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NgocNguyen
 *
 */

public class Common {
	
	
	public Common() {

	}		
	
	
	/** Launch a browser
	 * @param driver
	 * @throws Exception 
	 */
	public void NavigateURL(WebDriver driver, String sURL) throws Exception
	{				
		driver.get(sURL);				
		driver.manage().window().maximize();
		
	}
	
	
	/**
	 * Close the driver
	 * @param driver
	 * @return
	 */
	public boolean closeDriver(WebDriver driver) {
		try {
			driver.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Quit the browser
	 * @param driver
	 * @return
	 */	
	public boolean quitDriver(WebDriver driver) {
		try {
			driver.quit();
			return true;
		} catch (Exception e) {
			return false;
		}
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

	public static WebElement waitForElementVisible(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));
		WebElement Element = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(locator)));
		if(Element.isDisplayed()){
			return Element;
		}
		return null;
	}
	
	/**	 
	 * @param driver
	 * @param e: Element want to click
	 */
	public static void clickObject (WebDriver driver, WebElement e){
		if (waitForElementVisible(driver, e)) {
			e.click();
		} else {
			try {
				((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
				e.click();
			}
			catch (Exception exeption) {
				// add to log
			}
		}
			
	}
	
	
	/**
	 * Set text 	 
	 * @param driver
	 * @param e
	 * @param sText 
	 */
	public static void setText (WebDriver driver, WebElement e, String sText) {
		if (waitForElementVisible(driver, e)){
			e.sendKeys(sText);			
		} else {		
			// log.error("Could not set text to the object");
		}
	
	}

	/**
	 * Send a key to element
	 * @param driver
	 * @param e
	 * @param keys
	 */
	public static void sendKeys (WebDriver driver, WebElement e, Keys keys) {
		if (waitForElementVisible(driver, e)){
			e.sendKeys(keys);
		} else {
			// log.error("Could not set text to the object");
		}

	}

	/**
	 * Get text from element
	 * @param driver
	 * @param e
	 * @return
	 */
	public static String getText(WebDriver driver, WebElement e) {
		
		if (waitForElementVisible(driver, e)){
			return e.getText();			
		} else {		
			// log.error("Could not get text of the element");
		}
		return null;
	}

	/**
	 * Check element existed
	 * @param driver
	 * @param e
	 * @return
	 */
	public static boolean checkExists(WebDriver driver, WebElement e) {
		return e.isDisplayed();
	}

	/**
	 * Check element existed
	 * @param driver
	 * @param e
	 * @return
	 */
	public static boolean checkExists(WebDriver driver, By e) {

		List<WebElement> elements = driver.findElements(e);
		if (elements.size() > 0 ) {
			if ( elements.get(0).isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Check if a cell value existed in a table
	 * @param driver
	 * @param tableXpath
	 * @param cellValue
	 * @return
	 */
	public boolean checkCellValueExist(WebDriver driver, String tableXpath, String cellValue) {
		List<WebElement> elements = driver.findElements(By.xpath(tableXpath + "/tr/td"));
		for (int i = 0; i< elements.size(); i++) {
			if (elements.get(i).getText().equals(cellValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if a cell value existed in a table by checking the DOM value
	 * @param driver
	 * @param table
	 * @param cellValue
	 * @return
	 */
	public boolean checkCellValueExistInDOM(WebDriver driver, WebElement table, String cellValue) {
		String tableHTML = table.getAttribute("innerHTML");
		return tableHTML.contains("<td>" + cellValue + "</td>");
	}

	/**
	 * Check if a cell value existed in a table by regular expression
	 * @param driver
	 * @param table
	 * @param cellValue
	 * @return
	 */
	public boolean checkCellValueExistInDOMByPattern(WebDriver driver, WebElement table, String cellValue) {
		String tableHTML = table.getAttribute("innerHTML");
		String pattern = "<td>+" + cellValue + "+<\\/td>";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(tableHTML);
		return m.find();
	}

	/**
	 * Select radio button
	 * @param driver
	 * @param radioButton
	 * @return
	 */
	public void selectRadioButton(WebDriver driver, WebElement radioButton) {
		if (!radioButton.isSelected()) {  // if return false, need to check whether xpath is point to correct checkbox (not a label)
			clickObject(driver, radioButton);
		}
	}

	/**
	 * select checkbox
	 * @param driver
	 * @param checkbox
	 * @return
	 */
	public void selectCheckbox(WebDriver driver, WebElement checkbox) {
		if (!checkbox.isSelected()) {  // if return false, need to check whether xpath is point to correct checkbox (not a label)
			clickObject(driver, checkbox);
		}
	}

	/**
	 * Select dropdown list by value, tag <Select/>
	 * @param driver
	 * @param dropdown
	 * @param value
	 * @return
	 */
	public boolean selectDropdownlistByValue(WebDriver driver, WebElement dropdown, String value) {
		if (waitForElementVisible(driver, dropdown)){
			Select select = new Select(dropdown);
			select.selectByValue(value);
			return dropdown.getText().equals((value));
		}
		return false;
	}

	/**
	 * Select dropdown list by index, tag <Select/>
	 * @param driver
	 * @param dropdown
	 * @param index
	 * @return
	 */
	public void selectDropdownlistByIndex(WebDriver driver, WebElement dropdown, int index) {
		if (waitForElementVisible(driver, dropdown)) {
			Select select = new Select(dropdown);
			select.selectByIndex(index);
		}
	}

	// NOT YET COMPLETED
	public void selectDropdownlistWithTyping(WebDriver driver, WebElement dropdown, String value) {
		if (waitForElementVisible(driver, dropdown)) {
			clickObject(driver, dropdown);
			setText(driver, dropdown, value);
			sendKeys(driver, dropdown, Keys.ENTER);
		}
	}

	/**
	 * Select grouped/catergorized dropdown list by value, tag <select><optgroup/><option/>
	 * @param driver
	 * @param dropdown
	 * @param value
	 */
	public void selectGroupedDropdownListByValue(WebDriver driver, WebElement dropdown, String value) {
		if (waitForElementVisible(driver, dropdown)) {
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
		}
	}

	/**
	 * Select grouped/catergorized dropdown list by value, tag <select><optgroup/><option/>
	 * @param driver
	 * @param dropdownXpath
	 * @param value
	 */
	public void selectGroupedDropdownDynamicListByValue(WebDriver driver, String dropdownXpath, String value) {
		List<WebElement> elements = driver.findElements(By.xpath(dropdownXpath + "optgroup/option"));
		for (WebElement e: elements) {
			if (e.getText().equalsIgnoreCase(value)) {
				clickObject(driver, e);
				return;
			}

		}
	}
	/**
	 * Select multiple items from a list, tag is <select multiple='multiple'/>
	 * @param driver
	 * @param multipleSelect
	 * @param values
	 * @param delimeter
	 * @return
	 */
	public boolean selectMultipleItemByValues(WebDriver driver, WebElement multipleSelect, String values, String delimeter) {
		if (waitForElementVisible(driver, multipleSelect)) {
			Select select = new Select(multipleSelect);
			String []listValues = values.split(delimeter);
			select.deselectAll();
			for ( int i = 0; i < listValues.length; i++) {
				sendKeys(driver, multipleSelect, Keys.CONTROL);
				select.selectByValue(listValues[i]);
			}
			return select.getAllSelectedOptions().size()==listValues.length;
		}
		return false;
	}

	/**
	 * Store table data with PAGINATION to 2 dimension array with headers.
	 * NOT apply for dynamic table with different number of colum for each row 
	 * with 
	 * @param driver
	 * @param table
	 * @param colSize
	 * @return
	 */
	public String[][] tableToArrayWithPagination(WebDriver driver, WebElement table, int... colSize) {
		if (waitForElementVisible(driver, table)) {
			int i = 0, j = 0, k = 0, rowNum = 0;
			String [][]arrResult;
			int colNum = 0;

			// Process number of rows
			rowNum = table.findElements(By.tagName("tr")).size();

			// Process number of columns
			if (colSize.length > 0) {
				colNum = colSize[0];
			} else {
				colNum = table.findElements(By.tagName("th")).size();
				if (colNum == 0) {  //th not exist, likely the header includes <td>
					colNum = table.findElements(By.tagName("td")).size()/rowNum;
				}
			}

			// Store all table data except HEADER to array
			arrResult = new String[rowNum][colNum];

			String data = table.getAttribute("innerHTML");
			data = data.replace("<th", "<td").replace("</th>", "</td>");
            String pattern = "\\<td\\>+.+\\<\\/td\\>";
            Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(data);

			while (i < rowNum) {
				while (j < colNum && m.find()) {
					arrResult[i][j] =  m.group().replace("<td>", "").replace("</td>", "");
					k += 1;
					j += 1;
				}
				j = 0;
				i += 1;
			}
			return arrResult;
		}
		return null;
	}

	/**
	 * Store table data NO PAGINATION to 2 dimension array with headers
	 * @param driver
	 * @param table
	 * @return
	 */
	public String[][] tableToArrayWithoutPagination(WebDriver driver, WebElement table, int... colSize) {
		if (waitForElementVisible(driver, table)) {
			int i = 0, j = 0, k = 0, rowNum = 0;
            String [][]arrResult;
            int colNum = 0;

            // Process number of rows
			rowNum = table.findElements(By.tagName("tr")).size();

            // Process number of columns
            if (colSize.length > 0) {
                colNum = colSize[0];
            } else {
                colNum = table.findElements(By.tagName("th")).size();
                if (colNum == 0) {  //th not exist, likely the header includes <td>
                    colNum = table.findElements(By.tagName("td")).size()/rowNum;
                }
            }

            // Store all table data except HEADER to array
			List<WebElement> cells = table.findElements(By.tagName("td"));
			arrResult = new String[rowNum][colNum];
			while (i < rowNum) {
				while (j < colNum && k < cells.size()) {
					arrResult[i][j] = cells.get(k).getText();
					k += 1;
					j += 1;
				}
				j = 0;
				i += 1;
			}
			return arrResult;
		}
		return null;
	}

    /**
     * Compare 2 arrays
     * @param firstArray
     * @param secondArray
     * @return
     */
	public boolean compareTwoArray2D (String [][] firstArray, String [][] secondArray) {
	    return Arrays.equals(firstArray, secondArray);
    }

	
	/**
	 * Accept the javascript alert
	 * @param driver
	 * @return
	 */
	public boolean acceptAlert(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));		 
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			// add to log
			return false;
		}		
		
	}


	/**
	 * Click on Cancel button of the alert
	 * @param driver
	 * @return
	 */
	public boolean alertDismiss(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));		 
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
			return true;
		} catch (Exception e) {
			// add to log
			return false;
		}		
		
	}
	
	
	/**
	 * Get the text/label displayed on the alert, not the text of user input
	 * @param driver
	 * @return
	 */
	public String alertGetText(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));		 
			wait.until(ExpectedConditions.alertIsPresent());
			return driver.switchTo().alert().getText();			
		} catch (Exception e) {
			// add to log
			return null;
		}				
	}
	
	
	/**
	 * Set text to alert. Works fine for firefox but for Chrome, the sent text is not visible, just need to accept the alert
	 * the text will be sent normally
	 * Refer: https://bugs.chromium.org/p/chromedriver/issues/detail?id=1120
	 * @param driver
	 * @param text
	 * @return
	 */
	public boolean alertSetText(WebDriver driver, String text) {
		try {			
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Config.getConfig("ELEMENT_VISIBLE_TIMEOUT")));		 
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());			
			alert.sendKeys(text);			
			return true;
		} catch (Exception e) {
			// add to log
			return false;
		}				
	}
	
	
	public boolean windowHandlerSwitch(WebDriver driver, boolean switchBack) {
		try {
			String currentWindow = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {				
				driver.switchTo().window(winHandle);				
			}
			
			if (switchBack) {
				driver.switchTo().window(currentWindow);
			}
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getCurrentWindowHandler(WebDriver driver) {
		try {
			return  driver.getWindowHandle();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean switchToWindowHandler(WebDriver driver, String handlerID) {
		try {
			driver.switchTo().window(handlerID);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	// Verify table data by an array
	// Verify table data by input csv/excel file
	// Sort and search table - verify result
	// Links: the most important links to check are broken and redirection links.
	// Static Content: checking title, policy terms, logo and other types which rarely change.\
	// Multiples Pages: using form fields, such as, submit/cancel buttons, or next/back steps, 
	// involves multiple pages/tabs and the data consistence in between them should be checked.
	// Data Integrity: DAO - database / SQL vs NonSQL
	//  create a method that will click on something and wait 
	//  for another thing and call this method every time you need this.
	// upload/download:
	//		Upload: 
	//			- just find the element "input" next to the "browse" button
	//			- sendkeys to the element -> done
	//		Download:
	//			- set default download path
	//			- set pop up window to false/0
	//			- add to desire capabilities
			
	//			String downloadPath="C:\\Users\\ntbngoc\\download";
	//			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();			
	//			chromePrefs.put("profile.default_content_settings.popups", 0);
	//			chromePrefs.put("download.default_directory", downloadPath);
	//			ChromeOptions chromeoptions = new ChromeOptions();
	////			chromeoptions...

	// or
	
	//String downloadFilepath = "K:\\";
	//HashMap<String, Object> setPath = new HashMap<String, Object>();    
	//setPath.put("download.default_directory", downloadFilepath); //to set path 
	//setPath.put("safebrowsing.enabled", "false"); // to disable security check eg. Keep or cancel button
	//
	//HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	//options.setExperimentalOption("prefs", setPath);
	//options.addArguments("--disable-extensions"); //to disable browser extension popup
	//
	//
	//cap = DesiredCapabilities.chrome();
	//cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	//cap.setCapability(ChromeOptions.CAPABILITY, options);
	// pop up window
	

}
