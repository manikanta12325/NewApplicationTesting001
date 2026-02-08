package TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObjectPackage.DashboardPage;
import PageObjectPackage.HomePage;

public class TC_001_Login_Functionality extends BaseClass{
	
	@Test
	public void loginFunction()
	{
		
		HomePage homepage = new HomePage(getDriver());
		
		Assert.assertTrue(homepage.logoDisplayed(),"Log is not displayed");
		
		homepage.enterUserName(getConfigFileData("username"));
		
		homepage.enterPassword(getConfigFileData("password"));
		
		homepage.clickLogin();
		
		logger.info("Successfully logged into application");
		
		DashboardPage db = new DashboardPage(getDriver());
		
		String actualTitle = db.dashboardPageTitle();
		
		logger.info("Actual Text : "+actualTitle);
		
        Assert.assertEquals(actualTitle, "Dashboard", "Login failed: User not redirected to Dashboard.");
		
		logger.info("Successfully logged into application");
		
		
		
	}

}
