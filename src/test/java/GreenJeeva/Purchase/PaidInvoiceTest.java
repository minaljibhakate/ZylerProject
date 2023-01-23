package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.AccountPayablePage;
import pageObjects.Purchase.PaidInvoicePage;
import utils.ExcelUtils;

public class PaidInvoiceTest extends base{

	WebDriver driver;
	ExcelUtils excel;
	PaidInvoicePage pip;
	String parent,  child_window;
	Set<String>s;
	Iterator<String> I1;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void edit_paid_inovice() throws InterruptedException, IOException 
	{
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

		System.out.println("------Started Executing Edit Paid Invoices------");
		pip = new PaidInvoicePage(driver);

		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();
		pip.getEditButton().click();

		//selecting warehouse
		pip.getWarehouse().click();		
		List<WebElement> warehouseList = pip.getWarehouseList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(2, 1)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		pip.getPackSize().clear();
		pip.getPackSize().sendKeys(excel.getCellDataNumber(2, 3));

		//pip.getPOPurchaseQty().clear();
		//pip.getPOPurchaseQty().sendKeys(excel.getCellDataNumber(2, 0));

		pip.getSaveAccountPayable().click();

		pip.getPreviewCloseButton().click();
	}

	@Test(priority = 2)
	public void view_pdf_paid_invoice() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing View PDF Paid Invoices------");
		pip = new PaidInvoicePage(driver);
		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();

		driver.switchTo().activeElement();
		pip.getViewPDF().click();

		pip.getPreviewCloseButton().click();
	}

	@Test(priority = 3)
	public void attach_file_paid_invoice() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Attach File For Paid Invoices------");

		pip = new PaidInvoicePage(driver);
		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();
		pip.getMoreButton().click();
		pip.getAttachFile().click();

		pip.getSalesUpload().click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(dataExcelPath+"\\TestUploadFile\\FileUpload.exe"); 
		driver.switchTo().activeElement();

		Thread.sleep(5000);
		pip.getActivityLog().click();

		String expected_success_message ="Attachment Added";
		String activity_log = pip.getMessagetext().getText();
		System.out.println("activity_log: "+activity_log);
		Assert.assertTrue(activity_log.contains(expected_success_message));
		System.out.println("Attachment added successfully to Account Payable.");

		pip.getPreviewCloseButton().click();
	}
	
	@Test(priority = 4)
	public void delete_paid_invoice() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete Paid Invoice------");

		pip = new PaidInvoicePage(driver);

		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();
		pip.getMoreButton().click();

		pip.getDelete().click();

		driver.switchTo().alert().accept();

		String sucess_message = pip.getDeleteSuccessMessage().getText();
		String expected_success_message = "popurchase deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}

	@Test(priority = 5)
	public void po_Level_attachment_paid_invoice() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Attach PO level For Paid Invoices------");

		pip = new PaidInvoicePage(driver);
		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();
		pip.getMoreButton().click();

		pip.getPOLevelAttachment().click();

		pip.getPOUpload().click();

		Thread.sleep(2000);
		Runtime.getRuntime().exec(dataExcelPath+"\\TestUploadFile\\FileUpload.exe"); 
		driver.switchTo().activeElement();
		pip.getPOUploadCloseButton().click();
		driver.switchTo().activeElement();
		pip.getPreviewCloseButton().click();
	}

	
	@Test(priority = 5)
	public void add_note_account_payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add Note to Account Payable------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

		pip = new PaidInvoicePage(driver);

		pip.getPurchase().click();
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();

		pip.getNote().click();

		pip.getNoteDescription().sendKeys(excel.getCellDataString(1, 4));
		pip.getAddNoteButton().click();
		Thread.sleep(3000);

		String note = pip.getNoteVerification().getText();
		System.out.println("note: "+note);
		Assert.assertTrue(note.contains(excel.getCellDataString(1, 4)));

		pip.getPreviewCloseButton().click();
	}
	
	@Test
	public void print_paid_inovice() throws InterruptedException, IOException 
	{
		System.out.println("------Started Executing Print Paid Invoices------");
		pip = new PaidInvoicePage(driver);

		pip.getPurchase().click();
		Thread.sleep(2000);
		pip.getHamburgerMenuClick().click();
		pip.getPaidInvoicesClick().click();
		pip.getTableIDClick().click();
		driver.switchTo().activeElement();
		pip.getPrintButton().click();

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


	//		@AfterTest
	//		public void driverClose() throws InterruptedException 	
	//		{
	//			Thread.sleep(3000);
	//			driver.close();
	//		}

}
