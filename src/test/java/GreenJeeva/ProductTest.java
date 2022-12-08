package GreenJeeva;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.ProductPage;

public class ProductTest extends base {

	WebDriver driver;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test
	public void clickOnProduct() throws IOException, InterruptedException
	{
				
		ProductPage pp = new ProductPage(driver);
		pp.getProduct().click();
		pp.getHamburgerMenuClick().click();
		Thread.sleep(3000);
		pp.getMasterProductClick().click();
		WebElement addProductButton_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).
				until(ExpectedConditions.elementToBeClickable(pp.getNewMasterProductClick()));
		addProductButton_wait.click();
		//ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/NewCustomer.xlsx", "Product");
	}
	@AfterTest
	public void driverClose() 	
	{
		
		driver.close();
	}
}
