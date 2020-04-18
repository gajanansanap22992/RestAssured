package com.automationframe.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Listners extends TestListenerAdapter
{
	public static ExtentReports extent;
	public static ExtentTest test;
	public ExtentHtmlReporter htmlrep;
	public void onStart(ITestContext testContext)
	{
		htmlrep=new ExtentHtmlReporter(System.getProperty("user.dir")+"//Report//MyReport.html");
		htmlrep.config().setDocumentTitle("Automation Report ");
		htmlrep.config().setReportName("Functional Testing");
		htmlrep.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlrep);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Gajanan");		
		
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case PassId"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FailId"+result.getThrowable());
		test.log(Status.FAIL, "Test Case FailId"+result.getName());
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case SkippedId"+result.getName());
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
}
