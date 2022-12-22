package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.PurchaseOrderPage;
import utils.ExcelUtils;

public class PurchaseOrderTest extends base{

	static String  purchaseOrder_number;
	WebDriver driver;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void add_purchase_order() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "PurchaseOrder");		
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

		//Printing the Purchase order Generated
		Thread.sleep(4000);
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		purchaseOrder_number = pop.getPurchaseOrderId().getText();
		System.out.println("Purchase Order ID Generated:"+ purchaseOrder_number);
		Thread.sleep(3000);
		pop.getPreviewCloseButton1().click();
		Thread.sleep(3000);
	}

	@Test(priority =2)
	public void PO_Updating_current_status() throws InterruptedException
	{
		System.out.println("------Started Executing Updating Current Status Blank to New------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);

		//Click on Sale option on Header
		pop.getPurchase().click();

		//pop.getSearch().clear();pop.getSearch().sendKeys(purchaseOrder_number);
		Thread.sleep(2000);
		//System.out.println("Current status:" + pop.getCurrentStatus().getText());

		pop.getCurrentStatusSelect().click();
		Select status = new Select(pop.getCurrentStatusSelect());
		status.selectByVisibleText("New");
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		pop.getYesStatus().click(); 
		Thread.sleep(3000);
		//System.out.println("Status After Updation:" + pop.getCurrentStatus().getText());
	}

	@Test(priority = 3)
	public void edit_purchase_order() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Edit Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "PurchaseOrder");		
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();

		pop.getPOLink().click();
		driver.switchTo().activeElement();
		pop.getEditButton().click();

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
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
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
		pop.getAddLineItemClick().click();

		//click on Save button
		pop.getSaveButton().click();
	}

	@Test(priority = 4)
	public void delete_purchase_order() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete Purchase Order------");

		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();

		pop.getPOLink().click();
		driver.switchTo().activeElement();

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

	@Test(priority=5)
	public void salesorder_SortingOfStatus() throws InterruptedException
	{
		System.out.println("------Started Executing Sorting Of Status in Purchase Order List Page------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();//Click on Purchase option on Header

		System.out.println("Verifying Status dropdown is working as expected for 'New'");

		pop.getStatusDropdown().click();
		pop.getStatusDropdown().click();
		pop.getStatusDropdown().click();

		List<WebElement> statusList = pop.getStatusList();
		for(int i=0 ; i<statusList.size(); i++) {
			if(statusList.get(i).getText().contains("New") ) {
				statusList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> statusColumnList = pop.getStatusColumnList();
		int status_count =0;
		System.out.println("statusColumnList ==>"+statusColumnList.size());
		for(int i=0 ; i<statusColumnList.size(); i++) {
			if(statusColumnList.get(i).getText().contains("New") ) {
				statusColumnList.get(i).click();
				status_count++;
			}
			else 
				break;
		}
		System.out.println("Status Count==>"+status_count);
		Assert.assertTrue(status_count==statusColumnList.size());
	}





	/*
	@Test
	public void add_COA_Document_to_PO() throws InterruptedException, IOException
	{
		System.out.println("------Started Executing Add COA Document to Purchase Order------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		//purchaseOrder_number="JOPO-0922000251";
		//driver.findElement(By.xpath("//a[contains(text(),'"+purchaseOrder_number+"')][1]")).click();
		//pop.getSearch().sendKeys(purchaseOrder_number);
		//Thread.sleep(2000);
		pop.getPOLink().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		pop.getMoreButton().click();
		pop.getAttachCOADocument().click();
		pop.getUploadfile().click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\Zyler ERP Automation\\ZylerERP\\TestUploadFile\\FileUpload.exe"); 
		//Runtime.getRuntime().exec("D:\\Zyler ERP Automation\\FileUpload.exe");
		driver.switchTo().activeElement();
		pop.getUploadFileCloseButton().click();
		driver.switchTo().activeElement();
		pop.getPreviewCloseButton().click();
	}
	 */

	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
