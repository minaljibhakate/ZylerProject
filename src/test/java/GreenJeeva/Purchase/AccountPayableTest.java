package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import TestComponents.base;
import pageObjects.AccountPayablePage;
import utils.ExcelUtils;

public class AccountPayableTest extends base {

	WebDriver driver;
	String PO_invoice_number;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test 
	public void PO_push_to_inventory() throws InterruptedException, IOException 
	{
//		PurchaseOrderTest pot = new PurchaseOrderTest();
//		pot.add_Purchase_Order();
//		pot.add_COA_Document_to_PO();
		
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	
		
		System.out.println("------Started Executing Purchase Order to Push to Inventory------");
		AccountPayablePage app = new AccountPayablePage(driver);
		
		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		
		PO_invoice_number = (String) InboundTrackingTest.invoice_number;     // "JOINVPO-0922000220";
		driver.findElement(By.xpath("//a[@title='"+PO_invoice_number+" ']")).click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(2000,0)");
	       
		Thread.sleep(2000);
		app.getPushToInventoryTickMarkClick().click();
		
		driver.switchTo().activeElement();
		app.getQuantity().sendKeys(excel.getCellDataNumber(1, 0));
		
		app.getLocation().sendKeys(excel.getCellDataString(1, 1));		
		
		Select loc_type_dropdown = new Select(app.getLocTypeDropdown());
		loc_type_dropdown.selectByVisibleText(excel.getCellDataString(1, 2));
		
		app.getAddButton().click();
		
		app.getSaveButton().click();
		
		app.getQuantity().sendKeys("1000");

		//String success_message = app.getSuccessMessage().getText();
		
		app.getQuantity().sendKeys("1000");

		app.getActivityLog().click();
		String expected_success_message ="Product Push Inventory";
		String activity_log = app.getMessagetext().getText();
		Assert.assertTrue(activity_log.contains(expected_success_message));
		System.out.println("Product is Successfully Pushed to Inventory");
	}
	
	
	
	@AfterTest
	public void driverClose() throws InterruptedException 	
	{
		Thread.sleep(3000);
		driver.close();
	}
}
