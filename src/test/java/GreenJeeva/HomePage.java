package GreenJeeva;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.LoginPage;

public class HomePage extends base{
	
	WebDriver driver;
	@BeforeTest
	public void driverOpen() throws IOException
	{
		driver=initializeDriver();
		//driver.get("https://development.greenjeeva.com/authentication/admin");
		driver.get(prop.getProperty("url"));
	}
	
	//WebDriver driver;
	@Test(dataProvider="getData")
	public void basePageNavigation(String EmailAddress, String Password)
	{		
		LoginPage lp = new LoginPage(driver);
		lp.getEmailAddress().sendKeys(EmailAddress);
		lp.getPassword().sendKeys(Password);
		lp.getLoginButton().click();	
		
	//	EntityPage ep = new EntityPage(driver);
		//ep.getEntity().click();
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		
		data[0][0]="minal.jibhakate@greenjeeva.com";
		data[0][1]="Minal@123";
		return data;
	}
	
	@AfterTest
	public void driverClose()	
	{
		
		driver.close();
	}
}
