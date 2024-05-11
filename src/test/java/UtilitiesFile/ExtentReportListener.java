package UtilitiesFile;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.TestCase;

public class ExtentReportListener extends TestCase implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports createtest;
	ExtentTest createlog;
	
	void setup()
	{
		createReport = new ExtentSparkReporter("MyReport.html");
		createtest = new ExtentReports();
		createtest.attachReporter(createReport);
		
		createtest.setSystemInfo("OS", "Windows");
		createtest.setSystemInfo("Browser", "chrome");
		createtest.setSystemInfo("User", "Shakir");
		
		createReport.config().setDocumentTitle("My_Extent_Report");
		createReport.config().setReportName("My_Extent_Report_today");
		createReport.config().setTheme(Theme.STANDARD);
	}
	public void onStart(ITestContext Result)
	{
		setup();
		System.out.println("onStart");
	}
	public void onFinish(ITestContext Result)
	{ 
		createtest.flush();
		System.out.println("onFinish call");
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("OntestStart");
	}
	public void onTestSuccess(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("Test Case pass",ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult Result)
	{
		try 
		{
			Screenshot();
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
		String path = "C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework\\Screenshots\\Screenshot.png";
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("Test Case Failed",ExtentColor.RED));
		createlog.fail("myScreenshot" + createlog.addScreenCaptureFromPath(path));
	}
	public void onTestSkipped(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.SKIP,MarkupHelper.createLabel("Test Case Skipped",ExtentColor.YELLOW));
	}

}
