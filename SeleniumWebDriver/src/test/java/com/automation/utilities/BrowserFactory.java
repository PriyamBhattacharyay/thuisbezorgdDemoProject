/**
 * 
 */
package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Priyam
 * This class contains all the Browsers like Chrome, IE, Firefox etc.
 *
 */
public class BrowserFactory {
	
	public static WebDriver startApplication (WebDriver driver, String browserName, String applicationURL) {
		
		if (browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		
		else if (browserName.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
					
			
		}
		else if (browserName.equals("Firefox")) {
			
			
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			
			FirefoxOptions options = new FirefoxOptions()
				      .addPreference("geo.enabled", true)
				      .addPreference("geo.provider.use_corelocation", true)
				      .addPreference("geo.prompt.testing", true)
				      .addPreference("geo.prompt.testing.allow", true);
				     
			driver = new FirefoxDriver(options);			
			
		}
		
		else {
			
			System.out.println("We do not support this browser testing");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		return driver;		
		
	}
	
	public static void quiteBrowser (WebDriver driver) {
		
		driver.quit();
		
	}
	
//	public static void closeBrowser (WebDriver driver) {
//		
//		driver.close();
//		
//	}

}
