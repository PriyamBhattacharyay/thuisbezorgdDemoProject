package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public static WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public static ExtentTest logger;
	public SoftAssert softassertion;
		
	@BeforeSuite
	public void setUpSuite ()
	{
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		softassertion =  new SoftAssert();
	
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File (System.getProperty("user.dir")+"/Reports/SearchFunctionalityTest_"+Helper.getCurrentDateTime()+".html"));
		extent.config().setTheme(Theme.DARK);
		extent.config().setReportName("https://www.thuisbezorgd.nl/ API Test Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(extent);	
		
	}

	
	@BeforeMethod
	
	public void OpenApplication () {
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
				
	}
	
	
	@AfterMethod
	public void tearDownMethod (ITestResult result) throws IOException

	{
		
		System.out.println("Report Start");
		if (result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Step FAILED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			
			Helper.captureScreenshot(driver);
			logger.pass("Test Step PASSED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		else if (result.getStatus() == ITestResult.SKIP)
		{
			
			Helper.captureScreenshot(driver);
			logger.skip("Test Step SKIPPED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		reports.flush();
		
		System.out.println("Report End");
		BrowserFactory.quiteBrowser(driver);
		
		
	}
	
	
}
