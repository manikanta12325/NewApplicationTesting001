package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	private Properties prop;
	
	protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(this.getClass());
	
	private static final String path =System.getProperty("user.dir")+ "/src/test/resources/config.properties";
	
	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}
	private void loadConfigFile(String path)
	{
		try(FileInputStream file = new FileInputStream(path))
		{
			logger.info("Started File loading");
			
			prop = new Properties();
			
			prop.load(file);
			
			logger.info("Completed loading the config file now the data was present in prop reference ");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
			System.out.println("Fails to load Config file "+e.getMessage());
			
			throw new RuntimeException("Config file is not present "+path);
		}
				
	}
	
	public String getConfigFileData(String key)
	{
		return prop.getProperty(key);
	}
	
	private void browserSetup(String browser)
	{
		WebDriver driver = null;
		
		switch(browser.toLowerCase())
		{
		      case "chrome" : driver = new ChromeDriver(); break;
		      
		      case "edge" : driver = new EdgeDriver(); break;
		      
		      case "firefox" : driver = new FirefoxDriver(); break;
		      
		      default : System.out.println("Invalid browser name "); return;
		}
		
		tlDriver.set(driver);
		tlDriver.get().manage().window().maximize();
		
		tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	private void loginApplication()
	{
		getDriver().get(getConfigFileData("appurl"));
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setup(String browser)
	{
		loadConfigFile(path);
		
		browserSetup(browser);
		
		logger.info("Browser successfully launched");
		
		loginApplication();
		
		logger.info("Succefully opened application");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		WebDriver driver = getDriver();
		
		try
		{
			if(driver!=null)
			{
				driver.quit();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.println("Fails to close the browser"+e.getMessage());
		}
	}
	
}
