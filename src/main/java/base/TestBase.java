package base;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import libs.Config;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestBase {
	protected WebDriver driver;

	public TestBase() {
	}


	/**
	 * Set the web driver
	 * @return
	 */
	public WebDriver setDriver() {
		String browser = Config.getConfig("browser");
		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty(Config.getConfig("CHROME.KEY"), Config.getConfig("CHROME.PATH"));		
			
			HashMap<String, Object> setPath = new HashMap<String, Object>();    		
			setPath.put("download.default_directory", Config.getConfig("D:/")); // To set download path
			setPath.put("safebrowsing.enabled", "false"); // To disable security check. Eg. Keep or cancel button
			setPath.put("directory_upgrade", "true");
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", setPath);
			chromeOptions.addArguments("--disable-extensions"); // To disable browser extension Pop Up

			this.driver = new ChromeDriver(chromeOptions);
			
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty(Config.getConfig("FIREFOX.KEY"), Config.getConfig("FIREFOX.PATH"));
			
//			HashMap<String, Object> setPath = new HashMap<String, Object>();    
//			setPath.put("download.default_directory", Config.getConfig("DOWNLOAD_LOCATION_ROOT")); // To set download path 
//			setPath.put("safebrowsing.enabled", "false"); // To disable security check. Eg. Keep or cancel button						
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("browser.download.folderList", 2);
			firefoxOptions.addPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxOptions.addPreference("browser.download.dir", Config.getConfig("DOWNLOAD_LOCATION_ROOT")); 
			firefoxOptions.addPreference("browser.download.defaultFolder",Config.getConfig("DOWNLOAD_LOCATION_ROOT")); 
			firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk","multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			firefoxOptions.addArguments("--disable-extensions"); // To disable browser extension Pop Up
			
			this.driver = new FirefoxDriver(firefoxOptions);
		} else {
			// Not implemented
		}
		this.driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver setDriverByParam(String browser) {
		
		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty(Config.getConfig("CHROME.KEY"), Config.getConfig("CHROME.PATH"));		
					
			HashMap<String, Object> setPath = new HashMap<String, Object>();    
//			setPath.put("download.default_directory", Config.getConfig("DOWNLOAD_LOCATION_ROOT")); // To set download path 
//			setPath.put("download.default_directory","D:\\temp\\"); // To set download path, path should contain \\ by the end
			setPath.put("download.default_directory", System.getProperty("user.home") + "\\Downloads\\");  // Use relative path with user.home to ensure the write permission is allowed
			setPath.put("safebrowsing.enabled", "false"); // To disable security check. Eg. Keep or cancel button
			setPath.put("directory_upgrade", "true");
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", setPath);
			chromeOptions.addArguments("--disable-extensions"); // To disable browser extension Pop Up
			chromeOptions.addArguments("--test-type");
			chromeOptions.addArguments("start-maximized", "disable-popup-blocking");

			this.driver = new ChromeDriver(chromeOptions);
			
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty(Config.getConfig("FIREFOX.KEY"), Config.getConfig("FIREFOX.PATH"));		
			 FirefoxProfile profile = new FirefoxProfile();
			 FirefoxOptions options = new FirefoxOptions();
			 profile.setPreference("browser.download.dir",  System.getProperty("user.home") + "\\Downloads\\");
			 profile.setPreference("browser.download.folderList", 2);
			 profile.setPreference("browser.download.manager.showWhenStarting", false);
			 profile.setPreference("browser.helperApps.neverAsk.openFile",
			      "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			 profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					 "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			 profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			 profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			 profile.setPreference("browser.download.manager.focusWhenStarting", false);
			 profile.setPreference("browser.download.manager.useWindow", false);
			 profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			 profile.setPreference("browser.download.manager.closeWhenDone", false);
			 options.setProfile(profile);			 
			this.driver = new FirefoxDriver(options);
			
		} else {
			// Not implemented
		}
		this.driver.manage().window().maximize();
		return driver;
	}
	
	
	void takeScreenshot(ITestResult result) {
		System.out.print("take screenshot after test");
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);				
				File DestFile = new File(Config.getConfig("SCREENSHOT_LOCATION") + "\\" 
				+ result.getMethod().getMethodName()
				+ "_"
				+ new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date())
						+".jpg");
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}


	/**
	 * Run before test with param from TestNG xml file.
	 */
	@BeforeTest
	@Parameters({"browser"})	
	public void beforeTest(String browser) {		
		setDriverByParam(browser);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {		
		takeScreenshot(result);	
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest() {		
		this.driver.quit();
	}
	
	
}
