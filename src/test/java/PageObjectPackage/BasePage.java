package PageObjectPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	protected void clickButton(WebElement name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(name));
		
		name.click();
	}
	
	protected void clickButton(By locatorName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locatorName));
		
		driver.findElement(locatorName).click();
	}
	
	protected void enterText(String text , WebElement name)
	{
		wait.until(ExpectedConditions.elementToBeClickable(name));
		
		name.sendKeys(text);
	}
	
	protected void enterText(String text , By locatorName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locatorName));
		driver.findElement(locatorName).sendKeys(text);
	}
	
	protected String getTextOfWebelemnt(WebElement name)
	{
		wait.until(ExpectedConditions.visibilityOf(name));
		
		return name.getText();
	}
	
	protected String getTextOfWebelemnt(By name)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(name));
		
		return driver.findElement(name).getText();
	}
	
	protected boolean getLogo(WebElement name)
	{
		wait.until(ExpectedConditions.visibilityOf(name));
		
		return name.isDisplayed();
	}
	
	protected boolean getLogo(By name)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(name));
		
		return driver.findElement(name).isDisplayed();
	}
}
