package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setupApplication()
	{
		System.out.println("LOG:INFO - Starting Application");
		
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("appURL"));
		
		System.out.println("LOG:INFO - Application Started");
	}
	
	@AfterClass
	public void tearDownApplication()
	{
		System.out.println("LOG:INFO - Closing  Application");
		
		driver.quit();
		
		System.out.println("LOG:INFO - Application Closed");
	}

}
