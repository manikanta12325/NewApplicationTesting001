package UtilityPackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHandlingClass {
	
	public static String captureScreenshot(String testName,WebDriver driver)
	{
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		String folderName = System.getProperty("user.dir")+"/Reports/Screenshots/";
		
		File fl = new File(folderName);
		
		if(!fl.exists())
		{
			fl.mkdirs();
		}
		
		String fileName = testName+"_"+timeStamp+".png";
		
		String filePath = folderName+fileName;
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(filePath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.println("Fails to copy the destiny "+e.getMessage());
		}
		
		return destFile.getAbsolutePath();
		
	}

}
