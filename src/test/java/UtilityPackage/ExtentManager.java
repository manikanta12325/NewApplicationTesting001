package UtilityPackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createReport(String testName , ITestContext context)
	{
		if(extent!=null)
		{
			return extent;
		}
		else
		{
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			
			String folderName = System.getProperty("user.dir")+"/Reports/";
			
			File fl = new File(folderName);
			
			if(!fl.exists())
			{
				fl.mkdirs();
			}
			
			String fileName = testName+"_"+timeStamp+".html";
			
			String filePath = folderName + fileName;
			
			ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
			
			spark.config().setTheme(Theme.DARK);
			
			spark.config().setReportName("Functional Test Results");
			
			spark.config().setDocumentTitle("Orange HRM");
			
			extent = new ExtentReports();
			
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Application", "Orange HRM");
			
			extent.setSystemInfo("Module", "Admin");
			
			extent.setSystemInfo("Sub Module", "Customer");
			
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			
			extent.setSystemInfo("Environment" , "QA");
			
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			
			extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
			
			return extent;
		}
		
	}

}
