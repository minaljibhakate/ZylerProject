package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.EnquiriesPage;
import pageObjects.ToBeSourcedPage;
import utils.ExcelUtils;

public class ToBeSourcedTest extends base {

	WebDriver driver;
	ToBeSourcedPage tbs; 
	String toBeSourced_productName_notAssigned;
	String productName ;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority=1)
	public void add_Enquiry_for_to_be_sourced() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add New Enquiry------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Enquiry");		
		EnquiriesPage ep = new EnquiriesPage(driver);
		ep.getSale().click();
		ep.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		ep.getEnquiryMenuClick().click();
		Thread.sleep(3000);

		//Clicking on Add New Enquiry button
		WebElement addNewEnquiryClickwait = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(ep.create_new_enquiry_btn));
		addNewEnquiryClickwait.click();


		//Selecting the desired customer name from dropdown
		ep.getCustomerDropdown().click();
		ep.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(2, 0));
		Thread.sleep(4000);
		List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(ep.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(2, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);

		//Add Item Code	
		ep.getAddItemDropdown().click();
		ep.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(2, 1));
		Thread.sleep(3000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(ep.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(2, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);

		//Add Lead Time 
		ep.getLeadTime().sendKeys(excel.getCellDataNumber(2, 3));

		//Due Date	
		ep.getDueDate().click();
		ep.getDueDateNextButton().click();
		ep.getDueDateNextButton().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		ep.getDueDateSelect().click();

		//Add Quantity code
		ep.getQty().clear();
		ep.getQty().sendKeys(excel.getCellDataNumber(2, 2));

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
		ep.getCloseButton().click();

		driver.switchTo().activeElement();
		productName = ep.getProductName().getText();
		System.out.println("First productName from the list ==> "+ productName);

	}

	@Test(priority=2)
	public void verifyToBeSourced() throws InterruptedException
	{
		System.out.println("------Started Executing To Be Sourced Test------");
		//productName = "Acai Extract Powder 4:1";
		System.out.println("Product Name from Enquiry in verifyToBeSourced =>> "+ productName);

		tbs = new ToBeSourcedPage(driver);
		tbs.getPurchase().click();
		Thread.sleep(2000);
		tbs.getHamburgerMenuClick().click();
		tbs.getToBeSourcedClick().click();

		System.out.println("------Verifying product Enquiry created , same product visible in To Be Sourced.------");
		String toBeSourced_productName = tbs.getToBeSourcedProduct().getText();
		System.out.println("toBeSourced_productName from the list==> "+toBeSourced_productName);
		Assert.assertTrue(toBeSourced_productName.contains(productName));

		System.out.println("------Selecting Sourcing Staff Name from Dropdown.------");
		toBeSourced_productName_notAssigned = tbs.getToBeSourcedProduct().getText();
		Select sourcingStaff_dropdown = new Select(tbs.getSourcingStaffDropdown());
		sourcingStaff_dropdown.selectByIndex(2);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		tbs.getYesButton().click(); //driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();	

		System.out.println("------In Assigned Tab, Selecting Failure Reason.------");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		tbs.getAssignedButtonClick().click();
		String assigned_product_name = tbs.getToBeSourcedProduct().getText();
		System.out.println("assigned PRODUCT name==>"+assigned_product_name);
		Assert.assertTrue(assigned_product_name.contains(toBeSourced_productName_notAssigned));
		Select sourcingStaff1_dropdown = new Select(tbs.getSourcingStaffDropdown());
		//sourcingStaff_dropdown.selectByVisibleText("Sonali Pradhan");
		System.out.println("Sourcing STAFF name==>"+sourcingStaff1_dropdown.getFirstSelectedOption().getText());
		Select failureReason_dropdown = new Select(tbs.getSourcingFailureDropdown());
		failureReason_dropdown.selectByIndex(1);
		System.out.println("Failure reason==>"+failureReason_dropdown.getFirstSelectedOption().getText());
	}


	@Test(priority=3)
	public void SortingOfPriorityVerificationInAssigned() throws InterruptedException
	{
		System.out.println("------Started Executing SortingOfPriorityVerificationInAssigned------");
		tbs = new ToBeSourcedPage(driver);
		tbs.getPurchase().click();
		tbs.getHamburgerMenuClick().click();
		tbs.getToBeSourcedClick().click();
		tbs.getAssignedButtonClick().click();		

		System.out.println("Verifying Priority dropdown is working	 as expected for HIGH");
		tbs.getPriorityDropdown().click();
		List<WebElement> priorityList = tbs.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("High") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> priorityColumnList = tbs.getPriorityColumnHighList();
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
		//tbs.getResetButtonClick().click();   //RESET button click

		System.out.println("Verifying Priority dropdown is workgin as expected for NORMAL");
		tbs.getPriorityDropdown().click();
		priorityList = tbs.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("Normal") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		priorityColumnList = tbs.getPriorityColumnNormalList();
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


	@Test(priority=4)
	public void enquiryMovedToAssigned() throws InterruptedException 
	{
		System.out.println("------Started Executing enquiry Moved To Assigned------");
		tbs = new ToBeSourcedPage(driver);
		tbs.getPurchase().click();
		tbs.getHamburgerMenuClick().click();
		tbs.getToBeSourcedClick().click();
		Thread.sleep(2000);
		tbs.getAssignedButtonClick().click();
		Thread.sleep(2000);

		System.out.println("Verifying filter for Sourcing Person is working as expected");
		//System.out.println("SourcingPersonName:"+SourcingPersonName);

		tbs.getSourcingPersonDropdown().click();
		tbs.getSourcingPersonDropdown().click();
		tbs.getSourcingPersonDropdown().click();
		Thread.sleep(2000);
		List<WebElement> personList = tbs.getSourcingPersonList();
		System.out.println("size:"+personList.size());
		for(int i=0 ; i<personList.size(); i++) {
			//if(personList.get(i).getText().contains("Sonali Pradhan") ) {
			if(personList.get(i).getText().contains(SourcingPersonName) ) {
				personList.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
		List<WebElement> staffList = tbs.getSourcingStaffColumnList();
		int staff_count =0;
		for(int i=0 ; i<staffList.size(); i++) {
			//if(staffList.get(i).getText().contains("Sonali Pradhan") ) {
			if(staffList.get(i).getText().contains(SourcingPersonName) ) {
				staffList.get(i).click();
				staff_count++;
			}
			else 
				break;
		}
		Assert.assertTrue(staff_count==staffList.size());
	}


	@Test(priority=5)
	public void SortingOfPriorityVerificationInNotAssigned() throws InterruptedException
	{
		System.out.println("------Started Executing Sorting Of Priority Verification In Not Assigned------");
		tbs = new ToBeSourcedPage(driver);
		tbs.getPurchase().click();
		tbs.getHamburgerMenuClick().click();
		tbs.getToBeSourcedClick().click();


		System.out.println("Verifying Priority dropdown is working	 as expected for HIGH");
		tbs.getPriorityDropdown().click();
		List<WebElement> priorityList = tbs.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("High") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> priorityColumnList = tbs.getPriorityColumnHighList();
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
		tbs.getPriorityDropdown().click();
		priorityList = tbs.getPriorityList();
		for(int i=0 ; i<priorityList.size(); i++) {
			if(priorityList.get(i).getText().contains("Normal") ) {
				priorityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		priorityColumnList = tbs.getPriorityColumnNormalList();
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

	@AfterTest
	public void driverClose() 	
	{
		driver.close();
	}
}
