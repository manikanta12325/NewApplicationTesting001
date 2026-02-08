package PageObjectPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecruitementPage extends BasePage{
	
	public RecruitementPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	private By btn_recruit = By.xpath("//span[contains(.,'Recruitment')]");
	
	private By btn_vacancy = By.linkText("Vacancies");
	
	private By btn_add = By.xpath("//button[contains(.,'Add')]");
	
	private By txt_vacancy_title = By.xpath("//label[contains(.,'Vacancy Name')]/following::input[1]");
	
	private By txt_job_title = By.xpath("//div[@role='option']/span");
	
	private By txt_Hiring_manager = By.xpath("//label[contains(.,'Vacancy Name')]/following::input[2]");
	
	private By btn_drop_down = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	
	
	
	//Actions
	
	public void clickRecruitementButton()
	{
		clickButton(btn_recruit);
	}
	
	public void clickVacancy()
	{
		clickButton(btn_vacancy);
	}
	
	public void clickAddButton()
	{
		clickButton(btn_add);
	}
	
	public void clickJobTitle(String title)
	{
		List<WebElement> option = driver.findElements(txt_job_title);
		
		for(WebElement optionList : option)
		{
			if(optionList.getText().equals(title))
			{
				optionList.click();
				break;
			}


		}
	}
	
	public void enterHiringManager(String name)
	{
		enterText(name,txt_Hiring_manager);
	}
	
	public void dropDown()
	{
		clickButton(btn_drop_down);
	}
}
