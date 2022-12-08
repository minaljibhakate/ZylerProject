package GreenJeeva.Sales;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import pageObjects.QuotationsPage;
import utils.ExcelUtils;

public class QuotationsEditDeleteTest extends base{
	
	WebDriver driver;
	static String QuotationsNumber;
	QuotationsPage qp;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test(priority=1)
	public void edit_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Edit Quotation------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Quotation");		

		//Creating object of QuotationsPage class
		qp = new QuotationsPage(driver);
		
		qp.getSale().click();
		qp.getHamburgerMenuClick().click();
		qp.getQuotationMenuClick().click();//Clicking on Quotation option from Menu
		Thread.sleep(3000);
		
		qp.getQuotationIDClick().click();
		driver.switchTo().activeElement();
		qp.getEditButton().click();
		
		//Add Item Code
		
		qp.getAddItemDropdown().click();
		qp.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(4, 1));
		Thread.sleep(4000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(qp.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(4, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		//Add Lead Time 
		qp.getLeadTime().sendKeys(excel.getCellDataNumber(4, 2));
		
		//Add Quantity code
		qp.getQty().clear();
		qp.getQty().sendKeys(excel.getCellDataNumber(4, 3));
		
		//click on Add line Item
		qp.getAddLineItemClick().click();
		
		//click on Save button
		qp.getSubmitButton().click();
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		qp.getPreviewCloseButton2().click();
	}
	
	@Test(priority=2)
	public void delete_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Edit Quotation------");
		
		//Creating object of QuotationsPage class
		qp = new QuotationsPage(driver);
		
		qp.getSale().click();
		qp.getHamburgerMenuClick().click();
		qp.getQuotationMenuClick().click();//Clicking on Quotation option from Menu
		Thread.sleep(3000);
		
		qp.getQuotationIDClick().click();
		driver.switchTo().activeElement();
		
		qp.getMoreButton().click();
		qp.getDeleteButton().click();
		
		driver.switchTo().alert().accept();
		
		//Verifying success message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(qp.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Quotation deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Success Message  :"+sucess_message.replace("×", ""));		
	}
	
	
	
	/*
	@Test(priority=2)
	public void convert_To_SalesOrder() throws IOException,InterruptedException
	{	
		System.out.println("------Started Executing Convert To Sales Order------");
		//String QuotationsNumber= "JOQT-0822000258";
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Quotation");
		//creating object of QuotationsPage class
		QuotationsPage qp = new QuotationsPage(driver);
		
		qp.getSale().click();
		qp.getHamburgerMenuClick().click();
		qp.getQuotationMenuClick().click();//Clicking on Quotation option from Menu
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@title,'"+QuotationsNumber+"')]")).click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();	
		qp.getConvertToSalesOrderButtonClick().click();
		Thread.sleep(2000);

		//Printable text
		String printable_text = qp.getProductDescription().getText();
		qp.getPrintableTxt().sendKeys(printable_text);//qp.getPrintableTxt().sendKeys(excel.getCellDataString(1, 0));
		
		//Rate
		qp.getRateTxt().clear();
		qp.getRateTxt().sendKeys(excel.getCellDataNumber(1, 1));
		//Save button
		qp.getSaveButton().click();
		
		//Verifying success message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(qp.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Quotation converted to salesorder successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Success Message  :"+sucess_message.replace("×", ""));
		
		//Getting Sales Order ID
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		String SONumber = qp.getEnquiryId().getText();
		System.out.println("SalesOrder Number Generated:"+ SONumber);
		qp.getPreviewCloseButton().click();
		Thread.sleep(1000);

	}
	*/
	@Test(priority=3)
	public void quotation_salesRep_sorting() throws InterruptedException
	{
		System.out.println("------Started Executing Quotation Sales Representative filtering------");
		//Creating object of QuotationsPage class
		qp = new QuotationsPage(driver);
				
		qp.getSale().click();
		qp.getHamburgerMenuClick().click();
		qp.getQuotationMenuClick().click();//Clicking on Quotation option from Menu
		Thread.sleep(3000);
		
		qp.getsalesRepDropdown().click();
		List<WebElement> personList = qp.getsalesRepList();
		for(int i=0 ; i<personList.size(); i++) {
			if(personList.get(i).getText().contains("Minal Jibhakate") ) {
				personList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> salesRep = qp.getsalesRepColumnList();
		int staff_count =0;
		for(int i=0 ; i<salesRep.size(); i++) {
			if(salesRep.get(i).getText().contains("Minal Jibhakate") ) {
				salesRep.get(i).click();
				staff_count++;
			}
			
			else 
				break;
		}
		Assert.assertTrue(staff_count==salesRep.size());
		
	}
	
	@Test(priority=4)
	public void Enquiry_SortingOfStatus() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);

		 Robot robot=new Robot();
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_MINUS);
	     robot.keyRelease(KeyEvent.VK_MINUS);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	        
		System.out.println("------Started Executing Sorting Of Status in Quotations List Page------");
		qp = new QuotationsPage(driver);
		qp.getSale().click();
		Thread.sleep(2000);
		qp.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		qp.getQuotationMenuClick().click();
		Thread.sleep(2000);

		System.out.println("Verifying Status dropdown is working as expected for 'Open'");
		qp.getStatusDropdown().click();
		List<WebElement> statusList = qp.getStatusList();
		for(int i=0 ; i<statusList.size(); i++) {
			if(statusList.get(i).getText().contains("Open") ) {
				statusList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> statusColumnList = qp.getStatusColumnList();
		int status_count =0;
		Thread.sleep(3000);
		System.out.println("statusColumnList ==>"+statusColumnList.size());
		for(int i=0 ; i<statusColumnList.size(); i++) {
			if(statusColumnList.get(i).getText().contains("Open") ) {
				statusColumnList.get(i).click();
				status_count++;
			}
			else 
				break;
		}
		System.out.println("Status Count==>"+status_count);
		Assert.assertTrue(status_count==statusColumnList.size());
	}
	
	
	@AfterTest
	public void driverClose() throws InterruptedException 	
	{
		Thread.sleep(3000);
		driver.close();
	}
}
