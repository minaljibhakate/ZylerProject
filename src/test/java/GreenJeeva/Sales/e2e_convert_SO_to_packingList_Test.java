package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.SaleOrderPage;
import pageObjects.convertSOtoPackingListpage;
import utils.ExcelUtils;

public class e2e_convert_SO_to_packingList_Test extends base {

	WebDriver driver;
	convertSOtoPackingListpage csi;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test
	public void convert_so_to_packingList() throws InterruptedException
	{
		System.out.println("------Started Executing Converting Sales Order To packing List------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);
		
		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();
		
		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(4, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(4, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
				
	    //Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(4, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(4, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(4, 3)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		
		//Add Quantity code
		sop.getQty().clear();
		sop.getQty().sendKeys(excel.getCellDataNumber(4, 4));

		//Add Rate
		sop.getRate().sendKeys(excel.getCellDataNumber(4, 5));
		
		//Select Current status
		sop.getCurrentStatus().click();
		List<WebElement> CurrentStatusList = sop.getCurrentStatusDropdownSuggestion();
			for(int i=0 ; i<CurrentStatusList.size(); i++) {
				if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(4, 6)) ) {
					CurrentStatusList.get(i).click();
					break;
				}
			}
		
		//click on Add line Item
		sop.getAddLineItemClick().click();
				
		//click on Save button
		sop.getSaveButton().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		csi = new convertSOtoPackingListpage(driver);
		csi.getMoreButton().click();
		csi.getGeneratePackingList().click();
		csi.getSaveButton().click();
		
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		String success_message = csi.getSuccessMessage().getText();
		System.out.println("Success Message :"+success_message.replace("×", ""));
		
		driver.switchTo().activeElement();
		String packing_list_number = csi.getPackingListNumber().getText();
		System.out.println("Packing List Number is :"+packing_list_number);
		
		
	}

	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
