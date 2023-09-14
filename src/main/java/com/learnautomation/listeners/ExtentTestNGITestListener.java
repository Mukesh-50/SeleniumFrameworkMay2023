package com.learnautomation.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;
import com.learnautomation.helper.Utility;

public class ExtentTestNGITestListener implements ITestListener 
{
	ExtentReports extent = ExtentManager.getInstance();

	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public synchronized void onTestStart(ITestResult result) 
	{
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}

	public synchronized void onTestSuccess(ITestResult result) 
	{

		System.out.println("Capture Screenshot On Success "+ConfigReader.getProperty("screenshotOnSuccess"));
		
		if (ConfigReader.getProperty("screenshotOnSuccess").contains("true")) {
			WebDriver driver = BrowserFactory.getDriver();

			String screenshot = Utility.captureScreenshotAsBase64(driver);

			parentTest.get().pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} else {
			parentTest.get().pass("Test Passed");
		}
	}

	public synchronized void onTestFailure(ITestResult result) 
	{
		System.out.println("Capture Screenshot On Failure "+ConfigReader.getProperty("screenshotOnSuccess"));
		
		if (ConfigReader.getProperty("screenshotOnFailure").contains("true")) 
		{
			WebDriver driver = BrowserFactory.getDriver();

			String screenshot = Utility.captureScreenshotAsBase64(driver);

			parentTest.get().fail("Failed Test Exception Trace " + result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} else {
			parentTest.get().fail("Failed Test Exception Trace " + result.getThrowable().getMessage());

		}
	}

	public synchronized void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped");
	}

	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
}
