package UtilityPackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BasePackage.BaseClass;

public class TestListenter implements ITestListener {
	
	private ExtentReports extent;
	
	private ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
	   
	    String reportName = context.getName(); 
	    
	    extent = ExtentManager.createReport(reportName, context);
	    
	    System.out.println("Report initialized for: " + reportName);
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		try
		{
			extent.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.println("Fails to create a report"+e.getMessage());
		}
		finally
		{
			tlTest.remove();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		
		tlTest.set(test);
		
		System.out.println("===Test Started==="+result.getMethod().getMethodName());
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		tlTest.get().log(Status.PASS, result.getMethod().getMethodName());
		
		System.out.println("======Test Passed===");
		
		tlTest.remove();
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		tlTest.get().log(Status.FAIL, "Test Failed: "+ result.getMethod().getMethodName());
		
		tlTest.get().log(Status.FAIL, result.getThrowable());
		
		System.out.println("===Test Failed====");
		
		WebDriver driver = BaseClass.getDriver();
		
		try
		{
			String file = ScreenshotHandlingClass.captureScreenshot(result.getMethod().getMethodName(), driver);
			
			tlTest.get().addScreenCaptureFromPath(file);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			tlTest.remove();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		tlTest.get().log(Status.SKIP, "Test Skipped");
		
		tlTest.get().log(Status.WARNING, result.getThrowable().getMessage());
		
		System.out.println("Tests are skipped "+result.getMethod().getMethodName());
		
		tlTest.remove();
	}

}
