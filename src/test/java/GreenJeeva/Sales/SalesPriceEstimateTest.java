package GreenJeeva.Sales;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.SalesPriceEstimatePage;
import utils.ExcelUtils;

public class SalesPriceEstimateTest extends base {

	WebDriver driver;
	Robot robot;
	ExcelUtils excel ;
	SalesPriceEstimatePage spep ;
	Random random;
	String value;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	
	@Test(priority = 1)
	public void add_sales_price_estimate() throws InterruptedException, AWTException
	{
		System.out.println("------Started Executing Add New Sales Price Estimate------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesPriceEstimate");
		robot = new Robot();
		
		spep = new SalesPriceEstimatePage(driver);
		spep.getSale().click();
		spep.getHamburgerMenuClick().click();
		spep.getSalesPriceEstimateMenuClick().click();
		
		//Add Product Click
		spep.getAddProductClick().click();
		
		//Product Name & SKU
		spep.getProductName().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(10000);

		//Current Market Price
		spep.getCurrentMarketPrice().sendKeys(excel.getCellDataNumber(1, 1));
		
		//Date
		spep.getDate().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		spep.getDateSelect().click();
				
		for(int i=0 ; i<50 ; i++)
		{
			Thread.sleep(1000);
			value = driver.findElement(By.xpath("//input[@id='sku']")).getAttribute("value");
			System.out.println("Outside if SKU: "+ value);
			if( !value.equals("") )
			{
				System.out.println("Inside if SKU: "+ value);
				//Save button
				spep.getSave().click();
				break;
			}

		}
		
		Thread.sleep(9000);

		spep.getSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(8000);
			
		System.out.println("Item: "+driver.findElement(By.xpath("(//td[1])[1]")).getText());	
		
		Assert.assertTrue(driver.findElement(By.xpath("(//td[1])[1]")).getText().contains(excel.getCellDataString(1, 0)));
	}
	
	@Test(priority = 2)
	public void edit_sales_price_estimate() throws InterruptedException, AWTException
	{
		System.out.println("------Started Executing Edit Sales Price Estimate------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesPriceEstimate");
		robot = new Robot();
		random = new Random();  
		int random_int = random.nextInt(10);// Generate random integers in range 0 to 10
		
		String market_price = String.valueOf(random_int);
		spep = new SalesPriceEstimatePage(driver);

		Thread.sleep(8000);
		
		spep.getEdit().click();
		
		System.out.println("market_price :"+market_price);
		driver.findElement(By.xpath("(//td[3])[1]//input")).clear();			
		driver.findElement(By.xpath("(//td[3])[1]//input")).sendKeys(market_price);
		driver.findElement(By.xpath("//td[5]//button")).click();       
		
		Thread.sleep(9000);
		driver.switchTo().defaultContent();
		spep.getSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(8000);
			
		System.out.println("Price: "+driver.findElement(By.xpath("(//td[3])[1]")).getText());	
		
		Assert.assertTrue(driver.findElement(By.xpath("(//td[3])[1]")).getText().contains(market_price));
		
	}
	
	@Test(priority = 3)
	public void delete_sales_price_estimate() throws InterruptedException, AWTException
	{
		System.out.println("------Started Executing Delete Sales Price Estimate------");
		spep = new SalesPriceEstimatePage(driver);
		
		spep.getDelete().click();	
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().activeElement();
		spep.getOkButton().click();
	}
	
	
	@AfterTest
	public void driverClose() 	
	{
		
		driver.close();
	}
 
}
