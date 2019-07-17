package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
	
	public WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String GCdriverPath="\\src\\main\\resources\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe";
	
	public Browser() {
		driver = getDriver();
	}
	
	/**
	 * Function to get the driver instance. Getting Chrome as of now so hardcoded
	 * @return
	 */
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver("chrome");
		return driver;
	}

	
	private WebDriver createDriver(String BrowserName) {
        switch (BrowserName.toLowerCase()) {	    
        case "firefox" : 
	        
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
	    	break;
        case "chrome" : 
        	
        	DesiredCapabilities capabilitiesChrome = DesiredCapabilities.chrome();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("--disable-extensions");
			capabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        	System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+GCdriverPath);
        	driver = new ChromeDriver(chromeOptions);
        	driver.manage().window().maximize();
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		break;
        case "internetexplorer" : 
        	DesiredCapabilities capabilities = new DesiredCapabilities();
    		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	driver = new InternetExplorerDriver();
    		break;
    	}
		return driver;
	}	

	/**
	 * Function to close the driver instance
	 */
	public void closeDriver() {
	    
			driver.close();
			driver.quit();
		}

}
