package com.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.automation.utilities.Helper;

public class ThuisbezorgdHomePage {
	
	WebDriver driver;
	
	
	public ThuisbezorgdHomePage (WebDriver ldriver) {
		
		this.driver = ldriver;
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"imysearchstring\"]") WebElement Searchbox;
	@FindBy(xpath = "//*[@id=\"submit_deliveryarea\"]") WebElement Searchbutton;
	
	@FindBy(xpath = "/html/body/header/div[1]/div[5]/div/div[1]/h1/span[1]") WebElement spanOrderfoodtheeasyway;
	@FindBy(xpath = "/html/body/header/div[1]/div[1]") WebElement logoThuisbezorgd;	
	
	@FindBy(xpath = "//*[@id=\"locale\"]") WebElement changeLanguage;		
	@FindBy(xpath = "/html/body/header/div[1]/div[3]/div[2]/section[2]/div[2]/ul/li[2]/a") WebElement engLanguage;	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[5]/div[1]/div[1]/h1[1]/span[1]") WebElement homepageheading_1;
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[5]/div[1]/div[1]/div[1]/span[1]") WebElement homepageheading_2;
	
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[6]/div[1]/div[1]/h1[1]/dt[1]/span[1]") WebElement searchheading_1;
	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[6]/div[1]/div[1]/h1[1]/span[1]/span[1]/span[1]") WebElement searchheading_2;


	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]") WebElement searchback;
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]") WebElement searchtotalrestaurantsno;
	
	
	//Negative Search Element
	
	@FindBy(xpath = "//*[@id=\"notificationclose\"]") WebElement invalidPostCodeMessage;
	
	// Mouse Hover Element
	
	@FindBy(xpath = "//*[@id=\"iautoCompleteDropDownContent\"]/a[1]") WebElement validAddressDropValue;
	
	
	
	
	
	
	
	
	public void ThuisbezorgdSearch (String searchCode, String noOfRestaurant) {
		
		try {
			Helper.highLightElement(driver, Searchbox);
			Searchbox.click();
			Searchbox.clear();
			Searchbox.sendKeys(searchCode);
			Searchbox.sendKeys(Keys.TAB);
			spanOrderfoodtheeasyway.click();
			Helper.highLightElement(driver, Searchbutton);
			Searchbutton.click();
			Helper.highLightElement(driver, searchheading_1);
			
			BaseClass.logger.info("Verify that Page heading (Order takeaway in) is displayed in the Search Page");
			
			if (searchheading_1.getText().contentEquals("Order takeaway in"))
			{
				BaseClass.logger.pass("Test step passed. Page heading - (Order takeaway in) is displayed");
			}
			else 
			{
				BaseClass.logger.fail("Test step failed. Page heading - (Order takeaway in) is not displayed");
			}
					
			if (searchheading_2.getText().contains((searchCode.replaceAll(" ",""))))
			{
				BaseClass.logger.pass("Test step passed. Page heading - "+searchCode+" is displayed");
			}
			else 
			{
				BaseClass.logger.fail("Test step failed. Page heading - "+searchCode+" is not displayed");
			}
			
			Helper.highLightElement(driver, searchtotalrestaurantsno);
				
			if (searchtotalrestaurantsno.getText().contains(noOfRestaurant))
			{
				
				BaseClass.logger.pass("Test step passed. Total "+noOfRestaurant+" Restaurants are listed");
				
			}
			else
			{
				BaseClass.logger.fail("Test step failed. Total 126 Restaurants are not listed");
			}
		} catch (Exception e) {
			
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}
	
	public void ThuisbezorgdNegativePOSTCODESearch (String searchCode) {
		
		try {
			
			Helper.highLightElement(driver, Searchbox);
			Searchbox.click();
			Searchbox.clear();
			Searchbox.sendKeys(searchCode);
			Searchbox.sendKeys(Keys.TAB);
			spanOrderfoodtheeasyway.click();
			Helper.highLightElement(driver, Searchbutton);
			Searchbutton.click();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			
			Actions act = new Actions(driver);
			act.moveToElement(invalidPostCodeMessage).perform();
			
			BaseClass.logger.info("Verify that if User enters a wrong post code then system should display a error notification. Please verify manually the error message to see the attached screenshot. The error message should be (The entered postcode is invalid. A postcode needs to consist out of at least 4 digits and an optional two letters. For example: 1017AB.) ");
			
			System.out.println("Message is displayed "+invalidPostCodeMessage.isEnabled());
			
			if (invalidPostCodeMessage.isEnabled() == true)
			{
				BaseClass.logger.pass("Test step passed. Error notification is displayed");
					
			}
			
			else 
				
			{
				BaseClass.logger.pass("Test step passed. Errorrr notification is displayed");
			}
				
			
			
		} catch (Exception e) {
			
			System.out.println("Unable to locate Element "+e.getMessage());
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}
	
	public void ThuisbezorgdNegativeAddressSearch (String searchCode) {
		
		try {
			
			Helper.highLightElement(driver, Searchbox);
			Searchbox.click();
			Searchbox.clear();
			Searchbox.sendKeys(searchCode);
			Searchbox.sendKeys(Keys.TAB);
			spanOrderfoodtheeasyway.click();
			Helper.highLightElement(driver, Searchbutton);
			Searchbutton.click();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			
			Actions act = new Actions(driver);
			act.moveToElement(invalidPostCodeMessage).perform();
			
			BaseClass.logger.info("Verify that if User enters a wrong post code then system should display a error notification. Please verify manually the error message to see the attached screenshot. The error message should be (The entered Address is invalid.) ");
			
			System.out.println("Message is displayed "+invalidPostCodeMessage.isEnabled());
			
			if (invalidPostCodeMessage.isEnabled() == true)
			{
				BaseClass.logger.pass("Test step passed. Error notification is displayed");
					
			}
			
			else 
				
			{
				BaseClass.logger.fail("Test step failed. Error notification is not displayed");
			}
				
			
			
		} catch (Exception e) {
			
			System.out.println("Unable to locate Element "+e.getMessage());
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}
	
	public void ThuisbezorgdSearchBack()
	{
		searchback.click();
	}
	
	public void ThuisbezorgdLanguage () {
		
		Helper.highLightElement(driver, changeLanguage);
		changeLanguage.click();
		Helper.highLightElement(driver, engLanguage);
		engLanguage.click();
		Helper.highLightElement(driver, homepageheading_1);	
		Helper.highLightElement(driver, homepageheading_2);	
		
		
		
		
		if (homepageheading_1.getText().contentEquals("Order food the easy way"))
		{
			
			BaseClass.logger.pass("Test step passed. Page heading - (Order food the easy way) is translated to english");
			
		}
		
		else 
		{
			BaseClass.logger.fail("Test step failed. Page heading 1 is not translated to english");
		}	
		
		if (homepageheading_2.getText().contentEquals("Find restaurants in your area"))
		{
			BaseClass.logger.pass("Test step passed. Page heading - (Find restaurants in your area) is translated to english");			
			
		}
		
		else 
		{
			BaseClass.logger.fail("Test step failed. Page heading 2 is not translated to english");
		}	
		
	}
	
	public void LogoVerify () {
		
		Helper.highLightElement(driver, logoThuisbezorgd);
		
		if (logoThuisbezorgd.isDisplayed()){
			
			BaseClass.logger.pass("Test step passed. Logo visible");
			
		}
		
		else {
			
			BaseClass.logger.fail("Test step failed. Logo is not visible. Please raise a bug");
		}
		
		
	}
	
	
	public void ThuisbezorgdSearchTypeandClick (String searchCode, String noOfRestaurant) {
		
		try {
				Helper.highLightElement(driver, Searchbox);
				Searchbox.click();
				Searchbox.clear();
				Searchbox.sendKeys(searchCode);
				Thread.sleep(5000);			
				Actions act = new Actions(driver);
				act.moveToElement(validAddressDropValue).perform();
				
				
				List<WebElement> links = driver.findElements(By.xpath(("//*[@id=\"iautoCompleteDropDownContent\"]/a")));
				int total_count = links.size();
								
			
				
				for (int i=0; i<=total_count; i++)
				{
					WebElement ele = links.get(i);
					String text = ele.getAttribute("data-name");
									
					if (text.equalsIgnoreCase("Brouwerijstraat 10, Enschede"))
					{
						ele.click();
						BaseClass.logger.pass("Test step passed. Correct Address is listed in suggested drop-down");
						break;
					}
					
					else
					{
						BaseClass.logger.fail("Test step failed. Correct Address is not listed in suggested drop-down. Please raise a bug");
					}
						
				}
				
				BaseClass.logger.info("Verify that Page heading (Order takeaway in) is displayed in the Search Page");
				
				if (searchheading_1.getText().contentEquals("Order takeaway in"))
				{
					BaseClass.logger.pass("Test step passed. Page heading - (Order takeaway in) is displayed");
				}
				else 
				{
					BaseClass.logger.fail("Test step failed. Page heading - (Order takeaway in) is not displayed");
				}
						
				if (searchheading_2.getText().equalsIgnoreCase("Brouwerijstraat 10, Enschede"))
				{
					BaseClass.logger.pass("Test step passed. Page heading - Brouwerijstraat 10, Enschede is displayed");
				}
				else 
				{
					BaseClass.logger.fail("Test step failed. Page heading - Brouwerijstraat 10, Enschede is not displayed");
				}
				
				Helper.highLightElement(driver, searchtotalrestaurantsno);
					
				if (searchtotalrestaurantsno.getText().contains(noOfRestaurant))
				{
					
					BaseClass.logger.pass("Test step passed. Total "+noOfRestaurant+" Restaurants are listed");
					
				}
				else
				{
					BaseClass.logger.fail("Test step failed. Total 126 Restaurants are not listed");
				}
			
			
		} catch (Exception e) {
			
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}	
	
	
	public void ThuisbezorgdSearchGeoLocation (String current_location) {
		
		try {
				Thread.sleep(5000);	
				BaseClass.logger.info("Verify that application collected the User geolocation and place in Search");
				spanOrderfoodtheeasyway.click();
				Searchbutton.click();	
							
				if (searchheading_2.getText().contains(current_location))
				{
						
						BaseClass.logger.pass("Test step passed. Correct Location and near by restaurants are listed");
						
				}
					
				else
				{
					
					BaseClass.logger.fail("Test step failed. Correct Location and near by restaurants are not listed");
				}
						
			}			
		
		catch (Exception e) {
			
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}	
		
}
