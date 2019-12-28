package base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import libs.Config;

public abstract class TestBase {
	protected static WebDriver driver;			
	protected Logger log = Logger.getLogger(this.getClass());
	
	
	
	/**
	 * Constructor of TestBase to: Set Driver + Render all elements on All pages
	 */
	public TestBase() {		
			
		TestBase.driver = setDriver();		
		log = Logger.getLogger(TestBase.class.getName());
	}


	/**
	 * 
	 * @param browserType
	 * @param appURL
	 */	
	public WebDriver setDriver() {
				
		String browser = Config.getConfig("browser");
		
		if (browser.equalsIgnoreCase("CHROME")) {			
			System.setProperty(Config.getConfig("chrome.key"), Config.getConfig("chrome.path"));		
			TestBase.driver = new ChromeDriver();			
		} else if (browser.equalsIgnoreCase("FIREFOX")) {			
			System.setProperty(Config.getConfig("firefox.key"), Config.getConfig("firefox.path"));
			TestBase.driver = new FirefoxDriver();				
		} else {
			
		}
		
		return driver;
	}
	
	
	@BeforeClass
	public void beforeClass(){
		log.info("Test base - before class");
		TestBase.driver.manage().window().maximize();
		TestBase.driver.navigate().to(Config.getConfig("baseUrl"));			
	}
	
	
	@AfterClass
	public void afterClass(){		
		log.info("Test base - after class");
		TestBase.driver.quit();
	}
	
	
}
