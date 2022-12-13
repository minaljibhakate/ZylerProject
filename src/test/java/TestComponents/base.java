package TestComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	public WebDriver driver;
	public Properties prop ;
	//directory path
	public String dataExcelPath = System.getProperty("user.dir");
	public String SourcingPersonName;
	//@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Zyler ERP Automation\\ZylerERP\\src\\main\\java\\GreenJeeva\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//System.out.println(prop.getProperty("url"));
		SourcingPersonName = prop.getProperty("SourcingPerson");
		
		//browser initiation according to browser
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Zyler ERP Automation\\ZylerERP\\Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "D:\\Zyler ERP Automation\\ZylerERP\\Driver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	public void launchApp() throws AWTException
	{
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getEmailAddress().sendKeys(prop.getProperty("EmailAddress"));
		lp.getPassword().sendKeys(prop.getProperty("Password"));
		lp.getLoginButton().click();	
		
		 Robot robot=new Robot();
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_MINUS);
	        robot.keyRelease(KeyEvent.VK_MINUS);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public String getScreenshot(String testCaseName , WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png" );
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	public void logoutFromApplication()
	{
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//span[@class='material-icons align-middle']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
	}
	
}
