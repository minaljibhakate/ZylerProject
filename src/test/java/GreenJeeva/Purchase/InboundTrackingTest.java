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
import pageObjects.InboundTrackingPage;
import utils.ExcelUtils;

public class InboundTrackingTest extends base {

	WebDriver driver;
	//	String purchaseOrderNumber;
	//	static String ProductName ;
	static CharSequence invoice_number; 
	//	CharSequence IB_number;
	InboundTrackingPage itp;
	ExcelUtils excel ;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void edit_Inbound_Tracking() throws InterruptedException 
	{
		System.out.println("------Started Executing Edit Inbound Tracking------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "InboundTracking");	
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		itp.getTableIDClick().click();
		driver.switchTo().activeElement();

		itp.getEditButton().click();
		///JOINBTRKN-000068 updated Successfully.

		itp.getQuantityEdit().clear();
		itp.getQuantityEdit().sendKeys(excel.getCellDataNumber(2, 6));
		Thread.sleep(3000);
		itp.getSaveButton().click();

		//Verifying success Message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(itp.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "updated Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  :"+sucess_message.replace("×", ""));
	}

	@Test(priority = 2)
	public void attach_file_Inbound_Tracking() throws InterruptedException, IOException 
	{
		System.out.println("------Started Executing Attach A file to Inbound Tracking------");
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		itp.getTableIDClick().click();
		driver.switchTo().activeElement();
		itp.getMoreButton().click();
		itp.getAttachFile().click();

		itp.getFileUpload().click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(dataExcelPath+"\\TestUploadFile\\FileUpload.exe"); 
		Thread.sleep(5000);
		itp.getActivityLog().click();
		String activity_log_text = driver.findElement(By.xpath("(//div[@class='feed-item'])[1]")).getText();
		//System.out.println("text: "+activity_log_text);
		Assert.assertTrue(activity_log_text.contains("Attachment Added"));
		itp.getPreviewCloseButton().click();
	}



	@Test(priority = 3)
	public void delete_Inbound_Tracking() 
	{
		System.out.println("------Started Executing Delete Inbound Tracking------");
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		itp.getTableIDClick().click();

		driver.switchTo().activeElement();
		itp.getMoreButton().click();
		itp.getDeleteButton().click();
		driver.switchTo().alert().accept();

		//Verifying success Message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(itp.getDeleteSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Inbound Tracking deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  :"+sucess_message.replace("×", ""));
	}

	@Test(priority = 4)
	public void sorting_by_type_Inbound_Tracking() throws InterruptedException 
	{
		System.out.println("------Started Executing Sorting for Type Filter on Inbound Tracking------");
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		itp.getTypeFilter().click();
		itp.getInternationalFilter().click();

		Thread.sleep(3000);
		List<WebElement> statusColumnList = itp.getIBColunmnList();
		int status_count =0;
		System.out.println("statusColumnList ==>"+statusColumnList.size());
		for(int i=0 ; i<statusColumnList.size(); i++) {
			if(statusColumnList.get(i).getText().contains("International") ) {
				statusColumnList.get(i).click();
				status_count++;
			}
			else 
				break;
		}
		System.out.println("Status Count==>"+status_count);
		Assert.assertTrue(status_count==statusColumnList.size());

	}
	@Test(priority = 5)
	public void recieved_status_Inbound_Tracking() throws InterruptedException 
	{
		System.out.println("------Started Executing Received status verification in Received List Inbound Tracking------");
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		Thread.sleep(2000);
		itp.getReceivedButton().click();//driver.findElement(By.xpath("//a[normalize-space()='Received']")).click();

		itp.getTableIDClick().click();
		driver.switchTo().activeElement();

		String status = itp.getReceivedStatus().getText();//driver.findElement(By.xpath("(//tbody//tr//td[7])[6]")).getText();

		//	System.out.println("status: "+status);
		Assert.assertTrue(status.contains("Received"));
		itp.getPreviewCloseButton().click();
	}
	@Test(priority = 6)
	public void open_status_Inbound_Tracking() throws InterruptedException 
	{
		System.out.println("------Started Executing Open status verification in Yet to Receive List Inbound Tracking------");
		itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();

		itp.getTableIDClick().click();
		driver.switchTo().activeElement();

		String status = itp.getOpenStatus().getText(); // driver.findElement(By.xpath("(//tbody//tr//td[7])[27]")).getText();

		//	System.out.println("status: "+status);
		Assert.assertTrue(status.contains("Open"));
		itp.getPreviewCloseButton().click();
	}

	@AfterTest
	public void driverClose() throws InterruptedException 	
	{
		Thread.sleep(3000);
		driver.quit();
	}	

	/*
	@Test(priority = 1)
	public void add_Inbound_Tracking() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add Inbound Tracking------");
		//purchaseOrderNumber ="JOPO-0922000251";
		purchaseOrderNumber = PurchaseOrderTest.purchaseOrder_number;
		System.out.println("purchaseOrderNumber in addInboundTracking ==>"+ purchaseOrderNumber);
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

		//String purchaseOrderNumber = "JOPO-0922000199";

		// Purchase order number selection
		itp.getPurchaseOrderDropdown().click();
		System.out.println("Purchase Order Number in Add Inbound Tracking:"+purchaseOrderNumber);
		itp.getPurchaseOrderSearch().sendKeys(purchaseOrderNumber);
		Thread.sleep(5000);
		List<WebElement> POList = itp.getPurchaseOrderlist();
		for(int i=0 ; i<POList.size(); i++) {
			if(POList.get(i).getText().contains(purchaseOrderNumber) ) {
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

		//JOINBTRKN-000009 Added successfully
		//Verifying success message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(itp.getSuccessMessage()));	
		String success_message = success_wait.getText().replace("×", "");
		System.out.println("Success Message  : "+success_message);
		//.replace("×", "")

		//Printing the Purchase order Generated
		//Thread.sleep(2000);
		IB_number = success_message.substring(1, 17);
		System.out.println("Inbound Tracking ID Generated: "+ IB_number);
	}

	@Test(priority = 2)
	public void gerenate_PutAway_Sheet()
	{
		System.out.println("------Started Executing Generate Put Away Sheet------");
		InboundTrackingPage itp = new InboundTrackingPage(driver);
		itp.getPurchase().click();
		itp.getHamburgerMenuClick().click();
		itp.getInboundTrackingMenuClick().click();
		///IB_number="JOINBTRKN-000022";
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(IB_number);
		driver.findElement(By.xpath("(//a[@title='"+IB_number+"'])[1]")).click();
		driver.switchTo().activeElement();

	    ProductName = itp.getProductName().getText();//driver.findElement(By.cssSelector("tr[class='sortable'] td:nth-child(3)")).getText();
		System.out.println("Product Name for which Puyaway sheet created:"+ProductName);

		itp.getMoreButton().click();
		itp.getGeneratePutAwaySheetClick().click();
		String sucess_message = itp.getSuccessMessage().getText();//driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		String expected_success_message = "Put Away Sheet added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}

	@Test(priority = 3)
	public void verifying_putaway_sheet_inWMS()
	{
		PutawaySheetPage put = new PutawaySheetPage(driver);
		put.getWms().click();
		put.getHamburgerMenuClick().click();
		put.getPutAwayMenuClick().click();

		ProductName="Organic Artichoke Extract Powder 2.5% Cynarin HPLC";

		List<WebElement> productList = put.getProductList();
		for(int i=0 ; i<productList.size(); i++) {
			if(productList.get(i).getText().contains(ProductName) ) {
				productList.get(i).click();
				//productList.get(i).getAttribute(ProductName)
				break;
			}
		}

		String putAwaySheet_number= driver.findElement(By.xpath("//tr[1]//td[1]")).getText();
		System.out.println("Put Away Sheet Number generated for product "+ProductName +" is as " +putAwaySheet_number);
	}

	@Test(priority = 3)
	public void verifying_product_received_functionality_of_PO() throws InterruptedException
	{
		System.out.println("------Started Executing product received for Purchase Order ------");
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		itp = new InboundTrackingPage(driver);
		pop.getPurchase().click();
		//purchaseOrderNumber="JOPO-0922000232";
		driver.findElement(By.xpath("//a[contains(text(),'"+purchaseOrderNumber+"')][1]")).click();
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

		//driver.switchTo().activeElement();
//		Thread.sleep(3000);
//		pop.getPreviewCloseButton().click();		
	}
	 */


}
