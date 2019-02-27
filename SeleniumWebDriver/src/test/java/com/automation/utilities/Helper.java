package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
   public static String captureScreenshot (WebDriver driver)
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/ScreenShot/Search/"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File (screenshotPath));
			System.out.println("Screen shot captured");
		} 
		
		catch (IOException e) {
			
			System.out.println("Unable to capture screenshot >> "+e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime ()
	{
		
		DateFormat customformat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customformat.format(currentdate);
		
	}
	
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try 
		{
		Thread.sleep(500);
		} 
		catch (InterruptedException e) {
	
		System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}

}
