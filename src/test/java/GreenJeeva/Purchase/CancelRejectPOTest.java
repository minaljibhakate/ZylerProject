package GreenJeeva.Purchase;

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
import pageObjects.CancelRejectPOPage;
import pageObjects.PurchaseOrderPage;
import utils.ExcelUtils;

public class CancelRejectPOTest extends base{

	WebDriver driver;
	String PONumber ;
	CancelRejectPOPage crpp;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	
	@Test(priority=1)
	public void cancel_Purchase_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Cancelled Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "PurchaseOrder");		
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		//pop.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		pop.getCreateNewPurchaseOrder_btn().click(); //Clicking on Create New puchase order button
		Thread.sleep(2000);
		
		//Selecting the desired Vendor name from dropdown
		pop.getVendorDropdown().click();
		pop.getVendorDropdownSearch().sendKeys(excel.getCellDataString(2, 0));
		Thread.sleep(3000);
		List<WebElement> vendorList = pop.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(2, 0)) ) {
				vendorList.get(i).click();
				break;
			}
		}
		
		//selecting cuurency
		pop.getCurrecy().click();
		pop.getCurrencySearch().sendKeys(excel.getCellDataString(2, 5));
		Thread.sleep(2000);
		List<WebElement> currencyList = pop.getCurrencyList();
				//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<currencyList.size(); i++) {
			if(currencyList.get(i).getText().contains(excel.getCellDataString(2, 5)) ) {
				currencyList.get(i).click();
				break;
			}
		}
		
		//Add Item Code
		pop.getAddItemDropdown().click();
		pop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(2, 1));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(pop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(2, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		//selecting warehouse
		pop.getWarehouse().click();		
		List<WebElement> warehouseList = pop.getWarehouseList();
//				//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(2, 4)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		
		//Add Pack Size code
		pop.getPackSize().clear();
		pop.getPackSize().sendKeys(excel.getCellDataNumber(2, 3));
		
		//Add Quantity code
		pop.getQty().clear();
		pop.getQty().sendKeys(excel.getCellDataNumber(2, 2));
		
		//Add Lot number
		pop.getLotNumber().sendKeys(excel.getCellDataNumber(2, 6));
		
		//Rate
		pop.getRate().clear();
		pop.getRate().sendKeys(excel.getCellDataNumber(2, 7));
		
		//click on Add line Item
		Thread.sleep(2000);
		pop.getAddLineItemClick().click();
					
		//click on Save button
		pop.getSaveButton().click();
		
		System.out.println("------Purchase Order created Successfylly, now cancelling the Purchase Order -----");
	
		//Printing the Purchase order Generated
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		PONumber = pop.getPurchaseOrderId().getText();
		System.out.println("Purchase Order ID Generated:"+ PONumber);
				
		crpp = new CancelRejectPOPage(driver);
		
		crpp.getMoreButton().click();
		crpp.getMarkAsCancel().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
				
		Thread.sleep(1000);
		crpp.getHamburgerMenuClick().click();
		crpp.getCancelRejectPOMenu().click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='"+PONumber+"']")).isDisplayed()); 
		System.out.println(PONumber + " is successfully moved to Cancel/Reject PO page.");
		
		crpp.getPlusIconButton().click();
		//String status = crpp.getCancelStatus().getText();
		
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		crpp.getPreviewCloseButton().click();
		
		String status = crpp.getCancelStatus().getText();
		System.out.println("The Status of Purchase Order Number: "+ PONumber+ " in Cancel/Reject PO listing page is "+status);
		
		Assert.assertTrue(status.equals("Cancelled"));
	}
	
	
	
	@Test(priority=2)
	public void reject_Purchase_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Reject Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "PurchaseOrder");		
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		//pop.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		pop.getCreateNewPurchaseOrder_btn().click(); //Clicking on Create New puchase order button
		Thread.sleep(2000);
		
		//Selecting the desired Vendor name from dropdown
		pop.getVendorDropdown().click();
		pop.getVendorDropdownSearch().sendKeys(excel.getCellDataString(3, 0));
		Thread.sleep(3000);
		List<WebElement> vendorList = pop.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(3, 0)) ) {
				vendorList.get(i).click();
				break;
			}
		}
		
		//selecting warehouse
		pop.getCurrecy().click();
		pop.getCurrencySearch().sendKeys(excel.getCellDataString(3, 5));
		Thread.sleep(2000);
		List<WebElement> currencyList = pop.getCurrencyList();
				//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<currencyList.size(); i++) {
			if(currencyList.get(i).getText().contains(excel.getCellDataString(3, 5)) ) {
				currencyList.get(i).click();
				break;
			}
		}
		
		//Add Item Code
		pop.getAddItemDropdown().click();
		pop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(3, 1));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(pop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(3, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		//selecting warehouse
		pop.getWarehouse().click();		
		List<WebElement> warehouseList = pop.getWarehouseList();
//				//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(3, 4)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		
		//Add Pack Size code
		pop.getPackSize().clear();
		pop.getPackSize().sendKeys(excel.getCellDataNumber(3, 3));
		
		//Add Quantity code
		pop.getQty().clear();
		pop.getQty().sendKeys(excel.getCellDataNumber(3, 2));
		
		//Add Lot number
		pop.getLotNumber().sendKeys(excel.getCellDataNumber(3, 6));
		
		//Rate
		pop.getRate().clear();
		pop.getRate().sendKeys(excel.getCellDataNumber(3, 7));
		
		//click on Add line Item
		Thread.sleep(2000);
		pop.getAddLineItemClick().click();
					
		//click on Save button
		pop.getSaveButton().click();
		
		System.out.println("------Purchase Order created Successfylly, now Rejecting the Purchase Order -----");
	
		//Printing the Purchase order Generated
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		PONumber = pop.getPurchaseOrderId().getText();
		System.out.println("Purchase Order ID Generated:"+ PONumber);
				
		crpp = new CancelRejectPOPage(driver);
		
		crpp.getMoreButton().click();
		crpp.getMarkAsReject().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
				
		Thread.sleep(1000);
		crpp.getHamburgerMenuClick().click();
		crpp.getCancelRejectPOMenu().click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='"+PONumber+"']")).isDisplayed()); 
		System.out.println(PONumber + " is successfully moved to Cancel/Reject PO page.");
		
				//	driver.navigate().refresh();
		crpp.getPlusIconButton().click();
		String status = crpp.getRejectStatus().getText();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		crpp.getPreviewCloseButton().click();

		System.out.println("The Status of Purchase Order Number: "+ PONumber+ " in Cancel/Reject PO listing page is "+status);
		
		Assert.assertTrue(status.equals("Rejected"));

	}
	
	
	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
