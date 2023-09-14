package com.learnautomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learnautomation.dataProvider.ConfigReader;

public class BrowserFactory 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String browserName,String appURL)
	{
		
		if(browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("GC") || browserName.equalsIgnoreCase("Google Chrome"))
		{
			// read headless property from config file and if set to true then run the test in headless mode via --headless argument
			driver=new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("Mozila"))
		{
			// read headless property from config file and if set to true then run the test in headless mode via --headless argument
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Microsoft Edge") || browserName.equalsIgnoreCase("MSEdge"))
		{
			// read headless property from config file and if set to true then run the test in headless mode via --headless argument
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
			
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeOut"))));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		driver.get(appURL);
		
		return driver;
	}
	

}
