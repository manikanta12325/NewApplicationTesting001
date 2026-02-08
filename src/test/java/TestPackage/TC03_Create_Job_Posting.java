package TestPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObjectPackage.HomePage;
import PageObjectPackage.RecruitementPage;

public class TC03_Create_Job_Posting extends BaseClass{
	
	
	@BeforeClass
	 public void setupLogin() {
        HomePage homepage = new HomePage(getDriver());
        homepage.enterUserName(getConfigFileData("username"));
        homepage.enterPassword(getConfigFileData("password"));
        homepage.clickLogin();
    }

	@Test
	public void jobPosting()
	{
		RecruitementPage rp = new RecruitementPage(getDriver());
		
		rp.clickRecruitementButton();
		
		rp.clickVacancy();
		
		rp.clickAddButton();
		
		rp.dropDown();
		
		rp.clickJobTitle("Automaton Tester");
	}
}
