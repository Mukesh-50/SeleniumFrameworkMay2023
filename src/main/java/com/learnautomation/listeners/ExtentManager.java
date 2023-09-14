package com.learnautomation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.helper.Utility;

public class ExtentManager {
	
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
		
	}

	public static ExtentReports createInstance()
	{
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport_"+Utility.getCurrentDate()+".html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		
		sparkReporter.config().setReportName("Sprint 1 Report");
		
		sparkReporter.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}
	

}
