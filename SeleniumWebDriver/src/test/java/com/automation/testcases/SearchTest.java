package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.ThuisbezorgdHomePage;

public class SearchTest extends BaseClass {	
	
	@Test (priority = 1)	 
	public void SearchTestTestCase001 () {
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate the search result with a Valid Post Code");
		
		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		String postcode = excel.getStringData("SearchData", 1, 2);	
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
		
		logger.info("Step 4: Search with the postcode >> "+postcode);
		
		String noOfRestaurant = "127";
		
		homePage.ThuisbezorgdSearch(postcode, noOfRestaurant);			
	}
	
		
	@Test (priority = 2)	 
	public void SearchTestTestCase002 () {	
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate the search result with a Valid Address");
			
		String address = excel.getStringData("SearchData", 2, 3);		

		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
			
		logger.info("Step 4: Search with the valid Address >> "+address);
		String noOfRestaurant = "126";
		
		homePage.ThuisbezorgdSearch(address, noOfRestaurant);		
		
	}	
	
	@Test (priority = 3)	 
	public void SearchTestTestCase003 () {		
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate the search result with an Invalid Postcode");
		
		String postcode = excel.getStringData("SearchData", 3, 2);	
		
		System.out.println(postcode);
		
		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
			
		logger.info("Step 1: Search with the invalid postcode >> "+postcode);
		
		homePage.ThuisbezorgdNegativePOSTCODESearch(postcode);			
		
	}
	
	@Test (priority = 4)	 
	public void SearchTestTestCase004 () {		
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate the search result with API's suggested addres list");
		
		String address = excel.getStringData("SearchData", 4, 3);	
		
		System.out.println(address);
		
		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
			
		logger.info("Step 1: Search with the invalid postcode >> "+address);
		
		String noOfRestaurant = "96";
		
		homePage.ThuisbezorgdSearchTypeandClick(address, noOfRestaurant);			
		
	}
	
	@Test (priority = 5)	 
	public void SearchTestTestCase005 () {		
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate the search result with an Invalid Address");
		
		String address = excel.getStringData("SearchData", 5, 3);	
		
		System.out.println(address);
		
		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
			
		logger.info("Step 1: Search with the invalid postcode >> "+address);
		
		homePage.ThuisbezorgdNegativeAddressSearch(address);			
		
	}
	
	@Test (priority = 6)	 
	public void SearchTestTestCase006 () {		
		
		ThuisbezorgdHomePage homePage = PageFactory.initElements(driver, ThuisbezorgdHomePage.class);
		
		logger = reports.createTest("Test Description: Validate that the search box contains User's current geolocation");
		
		logger.pass("Step 1: Open https://www.thuisbezorgd.nl/ Application");
		
		logger.info("Step 2: Verify thuisbezorgd Logo is displayed ");
		
		homePage.LogoVerify();
		
		logger.info("Step 3: Change the language to English");
		
		homePage.ThuisbezorgdLanguage();
		
		String current_location = "Utrecht";
		
		homePage.ThuisbezorgdSearchGeoLocation(current_location);			
		
	}


}