package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test(dataProvider = "userData",dataProviderClass = CustomDataProvider.class)
	public void loginWithValidCredentials(String uname,String pass)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(uname,pass);
		
		Assert.assertTrue(login.isUserLoggedIn(),"Login failed");
	}
	
}
