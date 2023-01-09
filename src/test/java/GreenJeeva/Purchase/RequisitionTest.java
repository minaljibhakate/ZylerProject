package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.RequisitionPage;
import utils.ExcelUtils;

public class RequisitionTest extends base {

	WebDriver driver;
	RequisitionPage rp;
	ExcelUtils excel ;
	String requisition_number ;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void add_requisition() throws InterruptedException 
	{
		System.out.println("------Started Executing Add Requisition------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "Requisition");

		rp = new RequisitionPage(driver);
		rp.getPurchase().click();
		rp.getHamburgerMenuClick().click();
		Thread.sleep(2000);

		rp.getRequisitionMenuClick().click();

		rp.getAddNewRequisitionClick().click();
		rp.getProductCategory().click();
		rp.getInternalCategory().click();

		rp.getInternalItem().click();

		//Selecting the desired Item name from dropdown
		Thread.sleep(3000);
		List<WebElement> itemList = rp.getInternalItemList();
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				itemList.get(i).click();
				break;
			}
		} 
		rp.getQuantity().clear();
		rp.getQuantity().sendKeys(excel.getCellDataNumber(1, 1));

		rp.getCurrency().click();
		List<WebElement> currecyList = rp.getCurrencyList();
		for(int i=0 ; i<currecyList.size(); i++) {
			if(currecyList.get(i).getText().contains(excel.getCellDataString(1, 2)) ) {
				currecyList.get(i).click();
				break;
			}
		} 

		rp.getRate().sendKeys(excel.getCellDataNumber(1, 3));
		rp.getAddLineItem().click();
		rp.getSaveButton().click();

		driver.switchTo().activeElement();
		Thread.sleep(1000);
		requisition_number = rp.getRequitionID().getText();	
		System.out.println("Requisition Number: "+ requisition_number);
		rp.getPreviewCloseButton().click();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void edit_requisition() throws InterruptedException 
	{
		System.out.println("------Started Executing Edit Requisition------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "Requisition");

		rp = new RequisitionPage(driver);
		rp.getPurchase().click();
		rp.getHamburgerMenuClick().click();
		rp.getRequisitionMenuClick().click();
		rp.getSearch().sendKeys(requisition_number);
		Thread.sleep(3000);
		rp.getRequisitionIDtable().click();
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		rp.getEditButton().click();

		rp.getInternalItem().click();
		List<WebElement> itemList = rp.getInternalItemList();
		System.out.println("item: "+ excel.getCellDataString(2, 0));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(2, 0)) ) {
				itemList.get(i).click();
				break;
			}
		} 

		rp.getQuantity().clear();
		rp.getQuantity().sendKeys(excel.getCellDataNumber(2, 1));

		rp.getCurrency().click();
		List<WebElement> currecyList = rp.getCurrencyList();
		for(int i=0 ; i<currecyList.size(); i++) {
			if(currecyList.get(i).getText().contains(excel.getCellDataString(2, 2)) ) {
				currecyList.get(i).click();
				break;
			}
		} 

		rp.getRate().sendKeys(excel.getCellDataNumber(2, 3));
		rp.getAddLineItem().click();
		rp.getSaveButton().click();

	}

	@Test(priority = 3)
	public void reject_requisition() throws InterruptedException 
	{
		System.out.println("------Started Executing Reject Requisition------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "Requisition");

		rp = new RequisitionPage(driver);
		rp.getPurchase().click();
		rp.getHamburgerMenuClick().click();
		rp.getRequisitionMenuClick().click();
				
		rp.getRequisitionIDtable().click();
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		rp.getRemark().sendKeys(excel.getCellDataString(1, 4));
		rp.getRejectButton().click();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		rp.getYesButton().click();
		Thread.sleep(9000);

		driver.switchTo().activeElement();
		rp.getPreviewCloseButton().click();
		Thread.sleep(1000);
		rp.getSearch().sendKeys(requisition_number);
		Thread.sleep(3000);

		String status = rp.getRejectStatus().getText();
		System.out.println("Status: "+	status);
		Assert.assertTrue(status.contains("Rejected"));
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void delete_requisition() throws InterruptedException 
	{
		System.out.println("------Started Executing Delete Requisition------");

		rp = new RequisitionPage(driver);
		rp.getPurchase().click();
		rp.getHamburgerMenuClick().click();
		rp.getRequisitionMenuClick().click();
		rp.getRequisitionIDtable().click();
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		rp.getMoreButton().click();
		rp.getDeleteButton().click();
		driver.switchTo().alert().accept();

		//Verifying success Message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(rp.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Requisition deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  :"+sucess_message.replace("×", ""));
	}

	@Test(priority=5)
	public void requitision_SortingOfCategory() throws InterruptedException
	{
		System.out.println("------Started Executing Sorting Of Categogy in Requisition List Page------");
		
		rp = new RequisitionPage(driver);
		rp.getPurchase().click();
		rp.getHamburgerMenuClick().click();
		rp.getRequisitionMenuClick().click();
		
		rp.getCategorySorting().click();
		rp.getCategoryInternal().click();
		
		Thread.sleep(3000);
		List<WebElement> statusColumnList = rp.getCategoryColumnList();
		int status_count =0;
		System.out.println("statusColumnList ==>"+statusColumnList.size());
		for(int i=0 ; i<statusColumnList.size(); i++) {
			if(statusColumnList.get(i).getText().contains("Internal") ) {
				statusColumnList.get(i).click();
				status_count++;
			}
			else 
				break;
		}
		System.out.println("Status Count==>"+status_count);
		Assert.assertTrue(status_count==statusColumnList.size());
	}
	
//	@AfterTest
//	public void driverClose() throws InterruptedException 	
//	{
//		Thread.sleep(3000);
//		driver.close();
//	}	
}
