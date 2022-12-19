package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.AccountPayablePage;
import pageObjects.InboundTrackingPage;
import pageObjects.PurchaseOrderPage;
import utils.ExcelUtils;

public class e2e_po_to_inboud_PutAway_prodReceived_pushtoinventory extends base {

	String  purchaseOrder_number, ProductName;
	WebDriver driver;
	InboundTrackingPage itp;
	CharSequence IB_number, invoice_number;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void add_Purchase_Order() throws IOException,InterruptedException
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

	@Test(priority = 2)
	public void add_COA_Document_to_PO() throws InterruptedException, IOException
	{
		System.out.println("------Started Executing Add COA Document to Purchase Order------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		pop.getSearch().sendKeys(purchaseOrder_number);
		Thread.sleep(2000);
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

	@Test(priority = 3)
	public void add_Inbound_Tracking() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add Inbound Tracking------");
		System.out.println("purchaseOrderNumber in addInboundTracking ==>"+ purchaseOrder_number);
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "InboundTracking");		
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();
		itp.getAddInboundTrackingClick().click();

		//Selecting the desired Vendor name from dropdown
		itp.getVendorDropdown().click();
		itp.getVendorDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(3000);
		List<WebElement> vendorList = itp.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				vendorList.get(i).click();
				break;
			}
		} 

		itp.getFDANumber().sendKeys(excel.getCellDataString(1, 1));
		itp.getHSCode().sendKeys(excel.getCellDataString(1, 2));
		itp.getTransport().sendKeys(excel.getCellDataNumber(1, 3));

		//Country
		itp.getCountryDropdown().click();
		List<WebElement> countryList = itp.getCountryList();
		for(int i=0 ; i<countryList.size(); i++) {
			String list_country = countryList.get(i).getText();
			String Excel_data=excel.getCellDataString(1, 4);
			if( Excel_data.matches(list_country)) {
				countryList.get(i).click();
				break;
			}
		}

		//Add Item Code
		itp.getAddItemDropdown().click();
		itp.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(1, 5));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(itp.getAddItemlist()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 5)) ) {
				itemList.get(i).click();
				break;
			}
		}		

		// Purchase order number selection
		itp.getPurchaseOrderDropdown().click();
		System.out.println("Purchase Order Number in Add Inbound Tracking:"+purchaseOrder_number);
		itp.getPurchaseOrderSearch().sendKeys(purchaseOrder_number);
		Thread.sleep(5000);
		List<WebElement> POList = itp.getPurchaseOrderlist();
		for(int i=0 ; i<POList.size(); i++) {
			if(POList.get(i).getText().contains(purchaseOrder_number) ) {
				POList.get(i).click();
				break;
			}
		}

		//Quantity
		itp.getQuantity().clear();
		itp.getQuantity().sendKeys(excel.getCellDataNumber(1, 6));

		//selecting warehouse
		itp.getWarehouse().click();		
		List<WebElement> warehouseList = itp.getWarehouseList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(1, 7)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		//click on Add line Item
		itp.getAddLineItemClick().click();

		//click on Save button
		itp.getSaveButton().click();

		//Verifying success message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(itp.getSuccessMessage()));	
		String success_message = success_wait.getText().replace("×", "");
		System.out.println("Success Message  : "+success_message);

		//Printing the Purchase order Generated
		IB_number = success_message.substring(1, 17);
		System.out.println("Inbound Tracking ID Generated: "+ IB_number);
	}
	
	@Test(priority = 4)
	public void gerenate_PutAway_Sheet()
	{
		System.out.println("------Started Executing Generate Put Away Sheet------");
		InboundTrackingPage itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();
		driver.findElement(By.xpath("(//a[@title='"+IB_number+"'])[1]")).click();
		driver.switchTo().activeElement();
		
	    ProductName = itp.getProductName().getText();
		System.out.println("Product Name for which Puyaway sheet created:"+ProductName);
		
		itp.getMoreButton().click();
		itp.getGeneratePutAwaySheetClick().click();
		String sucess_message = itp.getSuccessMessage().getText();
		String expected_success_message = "Put Away Sheet added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}
	
	@Test(priority = 5)
	public void verifying_product_received_functionality_of_PO() throws InterruptedException
	{
		System.out.println("------Started Executing product received for Purchase Order ------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		itp = new InboundTrackingPage(driver);
		pop.getPurchase().click();
		//purchaseOrderNumber="JOPO-0922000232";
		driver.findElement(By.xpath("//a[contains(text(),'"+purchaseOrder_number+"')][1]")).click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		pop.getMoreButton().click();
		itp.getProductReceived().click();	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		itp.getReceivedDate().click();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		itp.getReceivedDateSelect().click();
		itp.getSaveButton().click();
		itp.getSuccessMessage().getText();
		
		//Verifying success message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(itp.getSuccessMessage()));	
		String success_message = success_wait.getText().replace("×", "");
		System.out.println("Success Message  : "+success_message.replace("×", ""));
	
		//Printing the Invoice Number Generated
		//Thread.sleep(2000);
		invoice_number = success_message.substring(1, 19);
		System.out.println("Invoice Generated: "+ invoice_number);	
	}
	
	@Test (priority = 6)
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
		
		//PO_invoice_number = (String) InboundTrackingTest.invoice_number;     // "JOINVPO-0922000220";
		driver.findElement(By.xpath("//a[@title='"+invoice_number+" ']")).click();
		
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
	public void driverClose() 	
	{
		driver.close();
	}
}
