package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
	
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
	
	@FindBy (xpath ="//span[@class='oxd-topbar-header-breadcrumb']//h6") private WebElement title;
	
	@FindBy (xpath ="//span[text()='PIM']") private WebElement text;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[1]") private WebElement txt_first_name;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[2]") private WebElement txt_middle_name;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[3]") private WebElement txt_last_name;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[6]") private WebElement txt_user_name;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[9]") private WebElement txt_password;
	
	@FindBy (xpath = "//label[text()='Employee Full Name']//following::input[10]") private WebElement txt_confirm_password;
	
	@FindBy (xpath = "//div[@class='oxd-form-actions']//button[2]") private WebElement btn_submit;		
			
	private By btn_add_employee = By.xpath("//li[contains(.,'Add Employee')]");	
	
	private By checkbox_toggle = By.xpath("//div/label/span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
	
	
	//Actions
	public String dashboardPageTitle()
	{
		return getTextOfWebelemnt(title);
	}
	
	public void clickPIM()
	{
		clickButton(text);
	}
	
	public void clickAddEmployee()
	{
		clickButton(btn_add_employee);
	}
	

	public void clickToggle()
	{
		WebElement toggleElement = driver.findElement(checkbox_toggle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", toggleElement);
		
		js.executeScript("arguments[0].click();",toggleElement);
	}
	
	public void enterFirstName(String name)
	{
		enterText(name,txt_first_name);
	}
	
	public void enterMiddleName(String name)
	{
		enterText(name,txt_middle_name);
	}
	
	public void enterLastName(String name)
	{
		enterText(name,txt_last_name);
	}
	
	public void enterUserName(String name)
	{
		enterText(name,txt_user_name);
	}
	
	public void enterPassword(String pass)
	{
		enterText(pass,txt_password);
	}
	
	public void enterConfirmPassword(String pass)
	{
		enterText(pass,txt_confirm_password);
	}
	
	public void clickSubmit()
	{
		clickButton(btn_submit);
	}

}
