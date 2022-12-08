package GreenJeeva.Sales;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.SaleOrderPage;
import utils.ExcelUtils;

public class SaleOrderTest extends base{

	WebDriver driver;
	String SONumber;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority = 1)
	public void add_Sales_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Add New Sales Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);

		//Click on Sale option on Header
		sop.getSale().click();
		//Clicking on Add New Sales order button
		sop.getCreateNewSalesOrder().click();

		//Selecting the desired customer name from dropdown
		sop.getCustomerDropdown().click();
		sop.getCustomerDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(5000);
		List<WebElement> customerList = sop.getCustomerDropdownSuggestion();
		//		List<WebElement> customerList = new WebDriverWait(driver, Duration.ofSeconds(10))
		//				.until(ExpectedConditions.visibilityOfAllElements(sop.getCustomerDropdownSuggestion()));
		for(int i=0 ; i<customerList.size(); i++) {
			if(customerList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				customerList.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);
		//verifying if any data is selected for Sales Agent Field
		/*if (sop.getSalesAgentDropdown().getAttribute("title").matches("Nothing selected"))
			System.out.println("in if loop..");
		else {
				//Selecting the desired Sales Agent name from dropdown
				sop.getSalesAgentDropdown().click();
				sop.getSalesAgentSearch().sendKeys(excel.getCellDataString(1, 1));
				try{
					Thread.sleep(3000);
				}catch(InterruptedException ie){
				}
				List<WebElement> salesAgentList = new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.visibilityOfAllElements(sop.getSalesAgentDropdownSuggestion()));
				for(int i=0 ; i<salesAgentList.size(); i++) {
					String sales_agent_name = salesAgentList.get(i).getText().replace(" -", "");
					//if(salesAgentList.get(i).getText().contains(excel.getCellDataString(1, 1)) ) {
					if(sales_agent_name.contains(excel.getCellDataString(1, 1)) ) {
						//System.out.println("inside if - sales_agent_name:"+ sales_agent_name);
						salesAgentList.get(i).click();
						break;
					}
				}
			}*/

		//Selecting Item from list
		sop.getAddItemDropdown().click();
		sop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(1, 2));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(sop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 2)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//Warehouse selection
		sop.getWarehouseDropdown().click();		
		List<WebElement> warehouseList = sop.getWarehouseDropdownSuggestion();
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(1, 3)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		//Add Quantity code
		sop.getQty().clear();
		sop.getQty().sendKeys(excel.getCellDataNumber(1, 4));

		//Add Rate
		sop.getRate().sendKeys(excel.getCellDataNumber(1, 5));

		//Select Current status
//						sop.getCurrentStatus().click();
//						List<WebElement> CurrentStatusList = sop.getCurrentStatusDropdownSuggestion();
//						for(int i=0 ; i<CurrentStatusList.size(); i++) {
//							if(CurrentStatusList.get(i).getText().contains(excel.getCellDataString(1, 6)) ) {
//								CurrentStatusList.get(i).click();
//								break;
//							}
//						}

		//click on Add line Item
		sop.getAddLineItemClick().click();

		//click on Save button
		sop.getSaveButton().click();

		//Verifying success Message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(sop.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Salesorder added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));

		//closing the Sales order pop up so that user can click on log out
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		SONumber = sop.getSalesOrderId().getText();
		System.out.println("SalesOrder Number Generated:"+ SONumber);
		sop.getCloseButton().click();//driver.findElement(By.xpath("(//button[@class='close-arrow'])[1]")).click();
		Thread.sleep(3000);

	}
	
	@Test(priority = 2)
	public void edit_Sales_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Add New Sales Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SalesOrder");		
		SaleOrderPage sop = new SaleOrderPage(driver);

		//Click on Sale option on Header
		sop.getSale().click();
		
		sop.getSearch().sendKeys(SONumber);
		Thread.sleep(2000);
		
		sop.getSONumberClick().click();
		driver.switchTo().activeElement();
		sop.getEditButton().click();
		
		
		
		
	}
	
	@Test(priority = 4)
	public void SO_Updating_current_status() throws InterruptedException
	{
			System.out.println("------Started Executing Updating Current Status Blank to New------");
			SaleOrderPage sop = new SaleOrderPage(driver);
		
			//Click on Sale option on Header
			sop.getSale().click();
			
			sop.getSearch().sendKeys(SONumber);
			Thread.sleep(2000);
			System.out.println("Current status:" + sop.getCurrentStatusList().getText());
		
			sop.getCurrentStatusSelect().click();
			Select status = new Select(sop.getCurrentStatusSelect());
			status.selectByVisibleText("New");
			Thread.sleep(2000);
			driver.switchTo().activeElement();
			Thread.sleep(1000);
			sop.getYesStatus().click(); 
			Thread.sleep(1000);
			System.out.println("Status After Updation:" + sop.getCurrentStatusList().getText());
	}

	
	
	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
