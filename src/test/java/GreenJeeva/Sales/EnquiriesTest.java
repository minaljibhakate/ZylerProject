package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.EnquiriesPage;


public class EnquiriesTest extends base{

	//static 
	String product_name ;
	WebDriver driver;
	static String enquiryNumber ;
	EnquiriesPage ep;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test(priority=2)
	public void Enquiry_SortingOfPriorityVerification() throws InterruptedException
	{
		System.out.println("------Started ExgetStatusDropdownecuting Sorting Of Priority in Enquiry List Page------");
		ep = new EnquiriesPage(driver);
		ep.getSale().click();
		Thread.sleep(2000);
		ep.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		ep.getEnquiryMenuClick().click();
		Thread.sleep(3000);

		System.out.println("Verifying Priority dropdown is working as expected for HIGH");
		ep.getPriorityDropdown().click();
		List<WebElement> priorityList = ep.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("High") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> priorityColumnList = ep.getPriorityColumnHighList();
		int priority_count =0;
		System.out.println("priorityColumnList for HIGH==>"+priorityColumnList.size());
		for(int i=0 ; i<priorityColumnList.size(); i++) {
			if(priorityColumnList.get(i).getText().contains("High") ) {
				priorityColumnList.get(i).click();
				priority_count++;
			}
			else 
				break;
		}
		System.out.println("priority_count HIGH==>"+priority_count);
		Assert.assertTrue(priority_count==priorityColumnList.size());

		Thread.sleep(5000);
		driver.navigate().refresh();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");

		System.out.println("Verifying Priority dropdown is workgin as expected for NORMAL");
		ep.getPriorityDropdown().click();
		priorityList = ep.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("Normal") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		priorityColumnList = ep.getPriorityColumnNormalList();
		priority_count =0;
		System.out.println("priorityColumnList for NORMAL==>"+priorityColumnList.size());
		for(int i=0 ; i<priorityColumnList.size(); i++) {
			if(priorityColumnList.get(i).getText().contains("Normal") ) {
				priorityColumnList.get(i).click();
				priority_count++;
			}
			else 
				break;
		}
		System.out.println("priority_count NORMAL==>"+priority_count);
		Assert.assertTrue(priority_count==priorityColumnList.size());
	}
	
	@Test(priority=3)
	public void Enquiry_SortingOfStatus() throws InterruptedException
	{
		System.out.println("------Started Executing Sorting Of Status in Enquiry List Page------");
		ep = new EnquiriesPage(driver);
		ep.getSale().click();
		Thread.sleep(2000);
		ep.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		ep.getEnquiryMenuClick().click();
		Thread.sleep(3000);

		System.out.println("Verifying Status dropdown is working as expected for 'New'");
		ep.getStatusDropdown().click();
		List<WebElement> statusList = ep.getStatusList();
		for(int i=0 ; i<statusList.size(); i++) {
			if(statusList.get(i).getText().contains("New") ) {
				statusList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> statusColumnList = ep.getStatusColumnList();
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
	
	@AfterTest
	public void driverClose() 	
	{
		
		driver.close();
	}
	/*
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
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ep.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Enquiry added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  :"+sucess_message.replace("×", ""));

		Thread.sleep(3000);
		driver.switchTo().activeElement();
		enquiryNumber = ep.getEnquiryId().getText();
		System.out.println("Enquiry Number Generated:"+ enquiryNumber);
		ep.getCloseButton().click();
		
		driver.switchTo().activeElement();
		product_name = ep.getProductName().getText();
		System.out.println("First product_name from the list ==> "+ product_name);
	}
	*/
}
