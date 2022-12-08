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

public class DeletingProductFromMultipleList extends base {

	WebDriver driver;
	String enquiryNumber , QuotationsNumber, product_name;
	
	int col=0;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void add_Enquiry_Multiple_Products() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add New Enquiry For Multiple Products------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Multiple");		
		EnquiriesPage ep = new EnquiriesPage(driver);
		ep.getSale().click();
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
		Thread.sleep(4000);
		List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(ep.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}

		//Adding multiple line item products
		for(int row=1 ; row<=5 ; row++) //Adding 5 Product // row<=5
		{
			col=1;
			for(int j=1 ; j<=4 ; j++) //For loop to add // j<=4   
			{
				//Add Item Code
				ep.getAddItemDropdown().click();
				ep.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(row, col));
				Thread.sleep(3000);
				List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.visibilityOfAllElements(ep.getAddItemDropdownSuggestion()));
				for(int i=0 ; i<itemList.size(); i++) {
					if(itemList.get(i).getText().contains(excel.getCellDataString(row, col)) ) {
						itemList.get(i).click();
						break;
					}
				}
				Thread.sleep(5000);

				col++;
				//Add Lead Time
				ep.getLeadTime().sendKeys(excel.getCellDataNumber(row, col));

				//Due Date
				ep.getDueDate().click();
				ep.getDueDateNextButton().click();
				ep.getDueDateNextButton().click();
				Thread.sleep(2000);
				driver.switchTo().activeElement();
				ep.getDueDateSelect().click();

				col++;
				//Add Quantity code
				ep.getQty().clear();
				ep.getQty().sendKeys(excel.getCellDataNumber(row, col));

				col++;
				//Adding Target Price
				ep.getTargetPrice().clear();
				ep.getTargetPrice().sendKeys(excel.getCellDataNumber(row, col));

				//click on Add line Item
				ep.getAddLineItemClick().click();				

				if(col==4)//col==4
					break;
			}//first for loop
		}//second for loop

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
		System.out.println("Enquiry Number Generated: "+ enquiryNumber);
		
	}
	
	@Test(priority = 2)
	public void Delete_products_while_converting_to_quotation() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Deleting 1 Product from Multiple Enquiry List while converting to quotation------");
		
//		EnquiriesPage ep = new EnquiriesPage(driver);
//		ep.getSale().click();
//		ep.getHamburgerMenuClick().click();
//		ep.getEnquiryMenuClick().click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[contains(@title,'JOENQ-1120000715')])[1]")).click();
//		driver.switchTo().activeElement();
//		Thread.sleep(3000);
				
		QuotationsPage qp = new QuotationsPage(driver);
		qp.getConvertToQuotation().click();
		Thread.sleep(4000);
		
		product_name = driver.findElement(By.xpath("(//textarea[@name='items[1][long_description]'])[1]")).getText();//tbody//tr[2]//td[3]
		System.out.println("Product which is deleted: "+ product_name);
		driver.findElement(By.xpath("(//i[contains(text(),'delete')])[1]")).click();
		Thread.sleep(2000);

		qp.getSubmitButton().click();
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		QuotationsNumber= qp.getQuotationNumber().getText();
		
		System.out.println("QuotationsNumber: "+QuotationsNumber);
		
		qp.getInfoPopupClose_btn().click();
	}
	
	
	@Test(priority = 3)
	public void verify_deleted_product_in_enquirylist() throws IOException,InterruptedException
	{
		System.out.println("------Verifying deleted product still listed in Enquiry List------");
		EnquiriesPage ep = new EnquiriesPage(driver);
		ep.getSale().click();
		ep.getHamburgerMenuClick().click();

		//Clicking on Enquiry option from Menu
		ep.getEnquiryMenuClick().click();
		Thread.sleep(3000);
		
		String product = driver.findElement(By.xpath("//tbody//tr[1]//td[4]//a")).getText();
		String enquiry = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		
		System.out.println("Product: "+ product);
		System.out.println("Enquiry: "+ enquiry);
		
//		Assert.assertTrue(product.contains(product_name));
//		Assert.assertTrue(enquiry.contains(enquiryNumber));
		
		Assert.assertEquals(product.contains(product_name), enquiry.contains(enquiryNumber));
	}
	
	
	
	
	@AfterTest
	public void driverClose() 
	{
			driver.close();
	}

}
