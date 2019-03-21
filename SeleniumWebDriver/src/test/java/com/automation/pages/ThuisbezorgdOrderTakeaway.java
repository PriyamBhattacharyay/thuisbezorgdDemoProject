package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utilities.Helper;

public class ThuisbezorgdOrderTakeaway {
	
	WebDriver driver;
	
	
	public ThuisbezorgdOrderTakeaway (WebDriver ldriver) {
		
		this.driver = ldriver;
		
	}	
	
	public void ThuisbezorgdListofRestaurants () {
		
		try {
				
				List<WebElement> links = driver.findElements(By.xpath(("//div[@class='restaurant grid']")));
				int total_count = links.size();
				
				BaseClass.logger.info("Step 4E: Verify that all the restaurants are listed in the result page");
													
				for (int i=1; i<total_count; i++)
				{
					WebElement ele = links.get(i);
					String text = ele.getAttribute("id");
					
					WebElement tmpRestaurant = (WebElement) driver.findElement(By.xpath(Helper.createXpath("//div[@id='{0}']", text)));
					WebElement RestaurantName = (WebElement) driver.findElement(By.xpath(Helper.createXpath("//div[@id='{0}']//h2[@class='restaurantname']", text)));
					WebElement RestaurantType = (WebElement) driver.findElement(By.xpath(Helper.createXpath("//div[@id='{0}']//div[@class='kitchens']", text)));
					
					
					Helper.highLightElement(driver, tmpRestaurant);
					
					if (RestaurantName.isDisplayed())
					{
						BaseClass.logger.info("*****************************************************************");
						BaseClass.logger.pass("Restaurant Name : "+RestaurantName.getText());						
						BaseClass.logger.pass("Restaurant Type : "+RestaurantType.getText());
						BaseClass.logger.info("*****************************************************************");
					}
					else 
					{
						BaseClass.logger.fail("Test step failed. Restaurant name is not displayed.");
					}
					
					Helper.pageScroll(driver,tmpRestaurant);									

				}			

			
		} catch (Exception e) {
			
			BaseClass.logger.fail("Test Case Failed. Unable to locate Element"+e.getMessage());
		}	
		
		
	}	
	

}
