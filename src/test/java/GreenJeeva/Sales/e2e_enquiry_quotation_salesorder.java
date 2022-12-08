package GreenJeeva.Sales;

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
import pageObjects.EnquiriesPage;
import pageObjects.QuotationsPage;
import utils.ExcelUtils;

public class e2e_enquiry_quotation_salesorder extends base {

	//static 
	String product_name , enquiryNumber, QuotationsNumber;
	WebDriver driver;
	EnquiriesPage ep;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test(priority=1)
	public void add_New_Enquiry() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add New Enquiry------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Enquiry");		
		ep = new EnquiriesPage(driver);
		ep.getSale().click();
		Thread.sleep(2000);
		ep.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		ep.getEnquiryMenuClick().click();
		Thread.sleep(3000);

		//Clicking on Add New Enquiry button
		//WebElement addNewEnquiryClickwait = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(ep.create_new_enquiry_btn));
		WebElement addNewEnquiryClickwait = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(ep.create_new_enquiry_btn));
		addNewEnquiryClickwait.click();
		
		//Selecting the desired customer name from dropdown
      
		ep.getCustomerDropdown().click();
		ep.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(5000);
		List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(ep.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		
		//Add Item Code
	
		ep.getAddItemDropdown().click();
		ep.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(1, 1));
		Thread.sleep(4000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(ep.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
		//Add Lead Time 
		ep.getLeadTime().sendKeys(excel.getCellDataNumber(1, 3));
		
		//Due Date
		ep.getDueDate().click();
		ep.getDueDateNextButton().click();
		ep.getDueDateNextButton().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		ep.getDueDateSelect().click();
	
		//Add Quantity code
		ep.getQty().clear();
		ep.getQty().sendKeys(excel.getCellDataNumber(1, 2));
		
		//click on Add line Item
		ep.getAddLineItemClick().click();
		
		//click on Save button
		ep.getSaveButton().click();
		
		//Verifying success Message
//		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ep.getSuccessMessage()));	
//		String sucess_message = success_wait.getText();
//		String expected_success_message = "Enquiry added Successfully.";
//		Assert.assertTrue(sucess_message.contains(expected_success_message));
//		System.out.println("Message  :"+sucess_message.replace("×", ""));

		Thread.sleep(3000);
		driver.switchTo().activeElement();
		enquiryNumber = ep.getEnquiryId().getText();
		System.out.println("Enquiry Number Generated:"+ enquiryNumber);
		ep.getCloseButton().click();
		
		driver.switchTo().activeElement();
		product_name = ep.getProductName().getText();
		System.out.println("First product_name from the list ==> "+ product_name);
	}
	
	@Test(priority=2)
	public void convert_To_Quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Convert To Quotation------");
		//Creating object of QuotationsPage class
		QuotationsPage qp = new QuotationsPage(driver);
	///	String enquiry_Number = EnquiriesTest.enquiryNumber;// Taking the values from Add Enquiry
		//System.out.println("addNewEnquiry class - enquiry_Number:" + enquiry_Number); // Taking the values from Add Enquiry 
		
		
		//creating object of Enquiry Test
		EnquiriesPage ep = new EnquiriesPage(driver);
		ep.getSale().click();
		ep.getHamburgerMenuClick().click();
		ep.getEnquiryMenuClick().click();//Clicking on Enquiry option from Menu
		Thread.sleep(3000);
		
		//String enquiry_Number_1 = "JOENQ-0920000555";
		driver.findElement(By.xpath("//a[contains(text(), '"+enquiryNumber+"')]")).click();

		driver.switchTo().activeElement();
		qp.getConvertToQuotation().click();
		Thread.sleep(3000);
		//Save button
		qp.getSubmitButton().click();
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		QuotationsNumber= qp.getQuotationNumber().getText();
		
		System.out.println("QuotationsNumber:"+QuotationsNumber);
		
		qp.getInfoPopupClose_btn().click();
		driver.switchTo().activeElement();	
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@title,"+QuotationsNumber+")]")).isDisplayed());
		System.out.println("Message  :");
		System.out.println(enquiryNumber +" is converted to Quotation of ID " + QuotationsNumber);
		
		
		//verifying that enquiry_Number is not displayed on enquiry page, after converting to Quotation
		/*ep.getSale().click();
		Thread.sleep(2000);
		ep.getHamburgerMenuClick().click();
		ep.getEnquiryMenuClick().click();//Clicking on Enquiry option from Menu
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(driver.findElement(By.xpath("//a[contains(text(), '"+enquiry_Number+"')]")).isDisplayed());
		//Assert.assertFalse(driver.findElement(By.xpath("//a[contains(text(), '"+enquiry_Number+"')]")).isDisplayed());
		//System.out.println("Enquiry isDisplayed:" + driver.findElement(By.xpath("//a[contains(text(), '"+enquiry_Number+"')]")).isDisplayed());
		System.out.println("Message  :");
		System.out.println(enquiry_Number_1 +" is now not displayed on Enquiry page as it is converted to Quotation");*/
		
	}
	
	@Test(priority=3)
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
	
	
	
	@AfterTest
	public void driverClose() 	
	{
		
		driver.close();
	}
}
