package GreenJeeva.Purchase;

import java.util.Iterator;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.RFQPage;
import pageObjects.ReceivedQuotationPage;
import utils.ExcelUtils;
import java.util.Set;
public class ReceivedQuotationTest extends base {

	WebDriver driver;
	ExcelUtils excel;
	String sucess_message, expected_success_message;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void edit_received_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Edit Received Quotation------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "ReceivedQuotation");		
		ReceivedQuotationPage rqp = new ReceivedQuotationPage(driver);
		rqp.getPurchase().click();
		rqp.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rqp.getReceivedQuotationMenu().click(); //Clicking on  Received Quotation Menu option

		///////////////////////////////////////////////////////////////////////////////////////////////
		//Below line of code needs to be dynamic. As from where this ID comes to Received Quotation Module
		String rfq_id = "JORFQ-012209";
		///////////////////////////////////////////////////////////////////////////////////////////////

		driver.findElement(By.xpath("//a[@title='"+rfq_id+" ']")).click();

		driver.switchTo().activeElement();
		rqp.getEditButton().click();

		//Add Item Code
		rqp.getItemDropdown().click();
		rqp.getItemDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(rqp.getItemDropdownList()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//fresh vendor
		rqp.getFreshVendor().click();
		rqp.getFreshVendorSearch().sendKeys(excel.getCellDataString(1, 2));
		Thread.sleep(2000);
		List<WebElement> freshVendorList = rqp.getFreshVendorList();
		for(int i=0 ; i<freshVendorList.size(); i++) {
			if(freshVendorList.get(i).getText().contains(excel.getCellDataString(1, 2)) ) {
				freshVendorList.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//Add Quantity code
		rqp.getQuantity().clear();
		rqp.getQuantity().sendKeys(excel.getCellDataNumber(1, 1));

		rqp.getAddLineItem().click();
		rqp.getSaveButton().click();

		driver.switchTo().activeElement();
		Thread.sleep(2000);
		RFQPage rfq = new RFQPage(driver);

		rfq.getPreviewCloseButton().click();
		rqp.getPurchase().click();
		rqp.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rqp.getReceivedQuotationMenu().click(); //Clicking on Received Quotation Menu option

		//RFQ updated Successfully.
	}

	@Test(priority = 2)
	public void view_as_vendor_received_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing View As Vendor in Received Quotation------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "ReceivedQuotation");		
		ReceivedQuotationPage rqp = new ReceivedQuotationPage(driver);
		rqp.getPurchase().click();
		rqp.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rqp.getReceivedQuotationMenu().click(); //Clicking on Received Quotation Menu option

		///////////////////////////////////////////////////////////////////////////////////////////////
		//Below line of code needs to be dynamic. As from where this ID comes to Received Quotation Module
		String rfq_id = "JORFQ-012209";
		///////////////////////////////////////////////////////////////////////////////////////////////
		driver.findElement(By.xpath("//a[@title='"+rfq_id+" ']")).click();

		driver.switchTo().activeElement();
		rqp.getMoreButton().click();
		rqp.getViewAsVendor().click();
		Thread.sleep(3000);

		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
		String pageURL = driver.getCurrentUrl();
		System.out.println("pageURL : "+pageURL);

		Assert.assertTrue(pageURL.contains("clients"));	
	}


	@Test(priority = 3)
	public void received_quotation_convert_to_purchase() throws IOException,InterruptedException
	{
		//(enabled = false)
		System.out.println("------Started Executing Received Quotation to Convert to Purchase------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "ReceivedQuotation");		
		ReceivedQuotationPage rqp = new ReceivedQuotationPage(driver);
		rqp.getPurchase().click();
		rqp.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rqp.getReceivedQuotationMenu().click(); //Clicking on Received Quotation Menu option

		String rfq_id = "JORFQ-122220";

		driver.findElement(By.xpath("//a[@title='"+rfq_id+" ']")).click();

		driver.switchTo().activeElement();
		rqp.getConvertToPurchase().click();

		//Add Item Code
		rqp.getCustomerDropdown().click();
		rqp.getCustomerSearch().sendKeys(excel.getCellDataString(1, 3));
		Thread.sleep(2000);
		List<WebElement> custList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(rqp.getCustomerList()));
		for(int i=0 ; i<custList.size(); i++) {
			if(custList.get(i).getText().contains(excel.getCellDataString(1,3)) ) {
				custList.get(i).click();
				break;
			}
		}

		//selecting Currency
		rqp.getCurrecy().click();
		rqp.getCurrencySearch().sendKeys(excel.getCellDataString(1, 4));
		Thread.sleep(2000);
		List<WebElement> currencyList = rqp.getCurrencyList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<currencyList.size(); i++) {
			if(currencyList.get(i).getText().contains(excel.getCellDataString(1, 4)) ) {
				currencyList.get(i).click();
				break;
			}
		}

		rqp.getPuchaseDate().click();
		rqp.getCalendarNextButton().click();
		rqp.getCalendarNextButton().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		rqp.getDateSelect().click();

		rqp.getSaveRfqPurchase().click();

		sucess_message = rqp.getSuccessMessage().getText();
		expected_success_message = "Converted successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Add Message: "+sucess_message.replace("×", ""));

		driver.switchTo().activeElement();
		Thread.sleep(2000);
		rqp.getPreviewCloseButton().click();

	}
	@Test(enabled = false)
	public void delete_received_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete Received Quotation------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "ReceivedQuotation");		
		ReceivedQuotationPage rqp = new ReceivedQuotationPage(driver);
		rqp.getPurchase().click();
		rqp.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rqp.getReceivedQuotationMenu().click(); //Clicking on Received Quotation Menu option

		String rfq_id = "JORFQ-012209";

		driver.findElement(By.xpath("//a[@title='"+rfq_id+" ']")).click();

		driver.switchTo().activeElement();

		rqp.getMoreButton().click();
		rqp.getDeleteRFQ().click();

		//Implementation of this test is PENDING; as page have only 1 Received Quotation with rejected status//////////// 
	}



	//	@AfterTest
	//	public void driverClose() 	
	//	{
	//
	//		driver.close();
	//	}
}
