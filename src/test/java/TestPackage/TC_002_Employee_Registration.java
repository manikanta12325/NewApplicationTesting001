package TestPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObjectPackage.DashboardPage;
import PageObjectPackage.HomePage;
import UtilityPackage.DataProvidersClass;

public class TC_002_Employee_Registration  extends BaseClass {
	
	@BeforeClass(alwaysRun=true)
    public void setupLogin() {
        HomePage homepage = new HomePage(getDriver());
        homepage.enterUserName(getConfigFileData("username"));
        homepage.enterPassword(getConfigFileData("password"));
        homepage.clickLogin();
    }
	
	
	@Test(dataProvider = "login data" , dataProviderClass = DataProvidersClass.class)
	public void employeeRegistration(String firstName,String middleName,String lastName,String userName,String passowrd, String confirmPass)
	{
		DashboardPage dashboard = new DashboardPage(getDriver());
		
		dashboard.clickPIM();
		
		dashboard.clickAddEmployee();
		
		dashboard.clickToggle();
		
		dashboard.enterFirstName(firstName);
		
		logger.info("Entered First Name");
		
		dashboard.enterMiddleName(middleName);
		
		logger.info("Entered Middle Name");
		
		dashboard.enterLastName(lastName);
		
		logger.info("Entered Last Name");
		
		dashboard.enterUserName(userName);
		
		logger.info("Enter User Name");
		
		dashboard.enterPassword(passowrd);
		
		logger.info("Entered Password");
		
		dashboard.enterConfirmPassword(confirmPass);
		
		logger.info("Entered Confirm Passowrd");
		
		dashboard.clickSubmit();
		
		logger.info("Clicked Submit Button");
		
		
	}

}
