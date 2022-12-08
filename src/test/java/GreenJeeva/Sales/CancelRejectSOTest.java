package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.CancelRejectSOPage;
import pageObjects.SaleOrderPage;
import utils.ExcelUtils;

public class CancelRejectSOTest extends base{

	WebDriver driver;
	String SONumber ;
	CancelRejectSOPage crp;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	
	@Test(priority=1)
	public void cancel_Sales_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Cancelled Sales Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);
		
		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();
		
		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(2, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(2, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		//Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(2, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(2, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(2, 3)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		
		//Add Quantity code
		sop.getQty().clear();
		sop.getQty().sendKeys(excel.getCellDataNumber(1, 4));

		//Add Rate
		sop.getRate().sendKeys(excel.getCellDataNumber(1, 5));
		
		//Select Current status
		sop.getCurrentStatus().click();
		List<WebElement> CurrentStatusList = sop.getCurrentStatusDropdownSuggestion();
			for(int i=0 ; i<CurrentStatusList.size(); i++) {
				if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(2, 6)) ) {
					CurrentStatusList.get(i).click();
					break;
				}
			}
		
		//click on Add line Item
		sop.getAddLineItemClick().click();
				
		//click on Save button
		sop.getSaveButton().click();
		System.out.println("------Sales Order created Successfylly, now cancelling the Sales Order -----");
	
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		SONumber = sop.getSalesOrderId().getText();
		System.out.println("SalesOrder Number Generated:"+ SONumber);

		crp = new CancelRejectSOPage(driver);
		
		crp.getMoreButton().click();
		crp.getMarkAsCancel().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		String success_message = crp.getSuccessMessage().getText();
		System.out.println("success_message:"+success_message.replace("×", ""));
		
		Thread.sleep(1000);
		crp.getHamburgerMenuClick().click();
		crp.getCancelledSOMenu().click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='"+SONumber+"']")).isDisplayed()); 
		System.out.println(SONumber + " is successfully moved to Cancelled SO page.");
		
		crp.getPlusIconButton().click();
		
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		crp.getPreviewCloseButton().click();
		driver.switchTo().activeElement();
		String status = crp.getCancelStatus().getText();
		
		System.out.println("The Status of Sales Order Number: "+ SONumber+ " in Cancelled SO listing page is "+status);

		Assert.assertTrue(status.equals("Cancelled"));
	}
	
	
	@Test(priority=2)
	public void reject_Sales_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Rejecting Sales Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);
		
		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();
		
		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(3, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(3, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		//Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(3, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(3, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(3, 3)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		
		//Add Quantity code
		sop.getQty().clear();
		sop.getQty().sendKeys(excel.getCellDataNumber(1, 4));

		//Add Rate
		sop.getRate().sendKeys(excel.getCellDataNumber(1, 5));
		
		//Select Current status
		sop.getCurrentStatus().click();
		List<WebElement> CurrentStatusList = sop.getCurrentStatusDropdownSuggestion();
			for(int i=0 ; i<CurrentStatusList.size(); i++) {
				if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(3, 6)) ) {
					CurrentStatusList.get(i).click();
					break;
				}
			}
		
		//click on Add line Item
		sop.getAddLineItemClick().click();
				
		//click on Save button
		sop.getSaveButton().click();
		System.out.println("------Sales Order created Successfylly, now rejecting the Sales Order -----");
	
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		SONumber = sop.getSalesOrderId().getText();
		System.out.println("SalesOrder Number Generated:"+ SONumber);

		crp = new CancelRejectSOPage(driver);
		
		crp.getMoreButton().click();
		crp.getMarkAsReject().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();

		crp.getHamburgerMenuClick().click();
		crp.getCancelledSOMenu().click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='"+SONumber+"']")).isDisplayed()); 
		System.out.println(SONumber + " is successfully moved to Cancelled SO page.");
		
		crp.getPlusIconButton().click();
		
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		crp.getPreviewCloseButton().click();
		
		String status = crp.getRejectStatus().getText();
		System.out.println("The Status of Sales Order Number: "+ SONumber+ " in Cancelled SO listing page is "+status);
		
		Assert.assertTrue(status.equals("Rejected"));
	}
	
	
	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
