package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.RMAPage;
import pageObjects.SaleOrderPage;
import utils.ExcelUtils;

public class RMATest extends base {

	WebDriver driver;
	String lotNo_name;
	String success_message ;
	RMAPage rma;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test
	public void SO_to_invoice_to_RMA() throws InterruptedException
	{
		rma= new RMAPage(driver); 
		System.out.println("------Started Executing RMA Flow------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);
		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();

		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(5, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		//				List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
		//						.until(ExpectedConditions.visibilityOfAllElements(sop.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(5, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);
		//Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(5, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(5, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(5, 3)) ) {
				warehouseList.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		//lot no
		Select assigned_lot = 	new Select(sop.getAssignedLot());
		Thread.sleep(2000);

		List <WebElement> lot = assigned_lot.getOptions();
		for(int i=0 ; i<lot.size(); i++) {
			if(lot.get(i).getText().contains("Select Lotno"))
			{
				continue;
			}
			else
			{
				lotNo_name = lot.get(i).getText();
			}
			break;
		}

		System.out.println("lotNo_name: "+ lotNo_name);
		assigned_lot.selectByVisibleText(lotNo_name);

		//Add Quantity code
		sop.getQty().clear();
		sop.getQty().sendKeys(excel.getCellDataNumber(5, 4));

		//Add Rate
		sop.getRate().sendKeys(excel.getCellDataNumber(5, 5));

		//Select Current status
		sop.getCurrentStatus().click();
		List<WebElement> CurrentStatusList = sop.getCurrentStatusDropdownSuggestion();
		for(int i=0 ; i<CurrentStatusList.size(); i++) {
			if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(5, 6)) ) {
				CurrentStatusList.get(i).click();
				break;
			}
		}

		//click on Add line Item
		sop.getAddLineItemClick().click();

		//click on Save button
		sop.getSaveButton().click();

		//success message
		success_message = sop.getSuccessMessage().getText();
		System.out.println("Success Message for SO Generation :"+success_message.replace("×", ""));

		Thread.sleep(3000);
		driver.switchTo().activeElement();

		//click on doc tab	
		rma.getDocumentTabClick().click();


		//send attachment 
		rma.getSendAttachment().sendKeys("D:\\\\Zyler ERP Automation\\\\ZylerERP\\\\TestDataExcel\\\\Dummy_pdf_12kb.pdf");

		//upload button click
		rma.getUploadButtonClick().click();
		Thread.sleep(6000);

		//more button click		
		rma.getMoreButtonSO().click();

		//Convert to Invoice click
		rma.getConvertToInvoice().click();

		//invoice page save button
		rma.getSaveButton().click();

		//success message
		success_message = sop.getSuccessMessage().getText();
		System.out.println("Success Message for SO converted to Invoice :"+success_message.replace("×", ""));

		Thread.sleep(2000);
		driver.switchTo().activeElement();

		//more button click
		rma.getMoreButtonAR().click();

		//return/replace button click
		rma.getReturnReplaceButtonClick().click();

		//return date
		rma.getReturnDate().click();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		rma.getReturnDateSelect().click();

		rma.getPOField().click();

		//save button click
		rma.getSaveButtonAR().click();

		//success message
		success_message = rma.getSuccessMessage().getText();
		System.out.println("Success Message for RMA Generation :"+success_message.replace("×", ""));

		Thread.sleep(2000);
		driver.switchTo().activeElement();

		String rma_number = rma.getRMANumber().getText();
		System.out.println("RMA Number Generated :"+rma_number);

		//Preview close button	
		rma.getPreviewCloseButton().click();
	}

	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
