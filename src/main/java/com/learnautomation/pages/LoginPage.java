package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By username=By.name("email1");
	
	private By password=By.name("password1");
	
	private By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	
	private By manageOption=By.xpath("//span[normalize-space()='Manage']");
	
	public void loginToApplication(String uname,String pass)
	{
		//driver.findElement(username).sendKeys(uname);
		Utility.waitForWebElement(driver, username).sendKeys(uname);
		
		Utility.waitForWebElement(driver, password).sendKeys(pass);
		
		//driver.findElement(password).sendKeys(pass);
		
		//driver.findElement(loginButton).click();
		
		Utility.waitForWebElement(driver, loginButton).click();
		
	}
	
	public boolean isUserLoggedIn()
	{
		boolean status=false;
		
		try
		{
			//driver.findElement(manageOption).isDisplayed();
			Utility.waitForWebElement(driver, manageOption).isDisplayed();
			status=true;
		}
		catch(NoSuchElementException e)
		{
			
		}
		return status;
		
	}
	
}
