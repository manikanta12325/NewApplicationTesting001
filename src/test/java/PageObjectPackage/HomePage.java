package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//Constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy ( xpath ="//input[@name='username']") private WebElement user_name;
	
	@FindBy ( xpath ="//input[@name='password']") private WebElement password;
	
	@FindBy ( xpath ="//button[@type='submit']") private WebElement login;
	
	@FindBy (xpath = "//div[@class='orangehrm-login-branding']/img[@alt='company-branding']") private WebElement logo;
	
	//Actions
	
	public void enterUserName(String name)
	{
		enterText(name, user_name);
	}
	
	public void enterPassword(String pass)
	{
		enterText(pass,password);
	}
	
	public void clickLogin()
	{
		clickButton(login);
	}

	public boolean logoDisplayed()
	{
		return getLogo(logo);
	}
}
