package GreenJeeva;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.PurchaseOrderPage;
import pageObjects.SaleOrderPage;
import utils.ExcelUtils;

public class DeleteSOPO extends base {

	WebDriver driver;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void delete_Sales_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Delete Sales Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);

		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();

		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		//		List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
		//				.until(ExpectedConditions.visibilityOfAllElements(sop.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);

		//Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(1, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(1, 3)) ) {
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
			if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(1, 6)) ) {
				CurrentStatusList.get(i).click();
				break;
			}
		}

		//click on Add line Item
		sop.getAddLineItemClick().click();

		//click on Save button
		sop.getSaveButton().click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		sop.getMoreButton().click(); // findElement(By.xpath("(//button[@type='button'])[9]")).click();
		sop.getDeleteButton().click();  //driver.findElement(By.xpath("//a[normalize-space()='Delete']")).click();

		driver.switchTo().alert().accept();

		String sucess_message = sop.getSuccessMessage().getText();
		String expected_success_message = "Salesorder deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}


	@Test(priority = 2)
	public void delete_Purchase_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Delete Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "PurchaseOrder");		
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		//pop.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		pop.getCreateNewPurchaseOrder_btn().click(); //Clicking on Create New puchase order button
		Thread.sleep(2000);

		//Selecting the desired Vendor name from dropdown
		pop.getVendorDropdown().click();
		pop.getVendorDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(3000);
		List<WebElement> vendorList = pop.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				vendorList.get(i).click();
				break;
			}
		}

		//selecting warehouse
		pop.getCurrecy().click();
		pop.getCurrencySearch().sendKeys(excel.getCellDataString(1, 5));
		Thread.sleep(2000);
		List<WebElement> currencyList = pop.getCurrencyList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<currencyList.size(); i++) {
			if(currencyList.get(i).getText().contains(excel.getCellDataString(1, 5)) ) {
				currencyList.get(i).click();
				break;
			}
		}

		//Add Item Code
		pop.getAddItemDropdown().click();
		pop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(1, 1));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(pop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//selecting warehouse
		pop.getWarehouse().click();		
		List<WebElement> warehouseList = pop.getWarehouseList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(1, 4)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		//Add Pack Size code
		pop.getPackSize().clear();
		pop.getPackSize().sendKeys(excel.getCellDataNumber(1, 3));

		//Add Quantity code
		pop.getQty().clear();
		pop.getQty().sendKeys(excel.getCellDataNumber(1, 2));

		//Add Lot number
		pop.getLotNumber().sendKeys(excel.getCellDataNumber(1, 6));

		//Rate
		pop.getRate().clear();
		pop.getRate().sendKeys(excel.getCellDataNumber(1, 7));

		//click on Add line Item
		pop.getAddLineItemClick().click();

		//click on Save button
		pop.getSaveButton().click();

		Thread.sleep(5000);
		//driver.switchTo().activeElement();
		pop.getMoreButton().click();
		pop.getDeleteButton().click();

		driver.switchTo().alert().accept();

		String sucess_message = pop.getSuccessMessage().getText();
		String expected_success_message = "Purchase Order deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));

	}



	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
