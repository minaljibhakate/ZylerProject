package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import utils.FileDownloadVerification;

public class AccountPayableTest extends base {

	WebDriver driver;
	String PO_invoice_number;
	AccountPayablePage app;
	String parent,  child_window;
	Set<String>s;
	Iterator<String> I1;
	ExcelUtils excel;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	@Test(priority = 1)
	public void edit_account_payable() throws InterruptedException, IOException 
	{
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

		System.out.println("------Started Executing Edit Account Payable------");
		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getEditButton().click();

		//selecting warehouse
		app.getWarehouse().click();		
		List<WebElement> warehouseList = app.getWarehouseList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(2, 1)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		app.getPackSize().clear();
		app.getPackSize().sendKeys(excel.getCellDataNumber(2, 3));

		//		app.getPOPurchaseQty().clear();
		//		app.getPOPurchaseQty().sendKeys(excel.getCellDataNumber(2, 0));

		app.getSaveAccountPayable().click();

		Thread.sleep(1000);
		driver.switchTo().activeElement();
		app.getActivityLog().click();
		String expected_success_message ="Updated";
		String activity_log = app.getMessagetext().getText();
		Assert.assertTrue(activity_log.contains(expected_success_message));
		System.out.println("Account Payable is updated successfully.");

		Thread.sleep(2000);
		app.getPreviewCloseButton().click();
	}

	@Test(priority = 2)
	public void download_pdf_account_Payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Download PDF for Account Payable------");

		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		
		String fileName = app.getTableIDClick().getText();
		
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getDownloadPdf().click();

		app.getPreviewCloseButton().click();
		Assert.assertTrue(FileDownloadVerification.isFileDownloaded(fileName, "pdf", 5000));

	}

	@Test(priority = 3)
	public void attach_file_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Attach File For Account Payable------");

		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getMoreButton().click();
		app.getAttachFile().click();

		app.getSalesUpload().click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(dataExcelPath+"\\TestUploadFile\\FileUpload.exe"); 
		driver.switchTo().activeElement();

		Thread.sleep(5000);
		app.getActivityLog().click();

		String expected_success_message ="Attachment Added";
		String activity_log = app.getMessagetext().getText();
		System.out.println("activity_log: "+activity_log);
		Assert.assertTrue(activity_log.contains(expected_success_message));
		System.out.println("Attachment added successfully to Account Payable.");

		app.getPreviewCloseButton().click();
	}

	@Test(priority = 4)
	public void delete_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete Account Payable------");

		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getMoreButton().click();

		app.getDelete().click();

		driver.switchTo().alert().accept();

		String sucess_message = app.getDeleteSuccessMessage().getText();
		String expected_success_message = "popurchase deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}

	@Test(priority = 5)
	public void add_note_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add Note to Account Payable------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();

		app.getNote().click();

		app.getNoteDescription().sendKeys(excel.getCellDataString(1, 4));
		app.getAddNoteButton().click();
		Thread.sleep(3000);

		String note = app.getNoteVerification().getText();
		System.out.println("note: "+note);
		Assert.assertTrue(note.contains(excel.getCellDataString(1, 4)));

		app.getPreviewCloseButton().click();
	}

	@Test(priority = 6)
	public void po_Level_attachment_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Attach PO level For Account Payable------");

		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getMoreButton().click();

		app.getPOLevelAttachment().click();

		app.getPOUpload().click();

		Thread.sleep(2000);
		Runtime.getRuntime().exec(dataExcelPath+"\\TestUploadFile\\FileUpload.exe"); 
		driver.switchTo().activeElement();
		app.getPOUploadCloseButton().click();
		driver.switchTo().activeElement();
		app.getPreviewCloseButton().click();

	}

	@Test(priority = 7)
	public void print_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Print Account Payable------");
		app = new AccountPayablePage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAccountPayableClick().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getPrint().click();

		parent=driver.getWindowHandle();
		s=driver.getWindowHandles();
		I1= s.iterator();
		while(I1.hasNext())
		{
			child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
		String pageURL = driver.getCurrentUrl();
		System.out.println("pageURL : "+pageURL);

		Assert.assertTrue(pageURL.contains("print=true"));
		driver.switchTo().window(child_window).close();
		driver.switchTo().window(parent);
	}

	@Test(enabled = false , priority=8 ) 
	public void PO_push_to_inventory() throws InterruptedException, IOException 
	{
		//		PurchaseOrderTest pot = new PurchaseOrderTest();
		//		pot.add_Purchase_Order();
		//		pot.add_COA_Document_to_PO();

		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

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
