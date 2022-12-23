package GreenJeeva.Purchase;

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
import utils.ExcelUtils;

public class RFQTest extends base{
	WebDriver driver;
	String sucess_message, expected_success_message;
	ExcelUtils excel;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	@Test(priority = 1)
	public void add_rfq() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Create New RFQ------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "RFQ");		
		RFQPage rfq = new RFQPage(driver);
		rfq.getPurchase().click();
		rfq.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rfq.getRFQMenu().click(); //Clicking on RFQ Menu option
		Thread.sleep(2000);
		rfq.getCreateNewRFQ().click();//Clicking on create new RFQ button


		//Add Item Code
		rfq.getItemDropdown().click();
		rfq.getItemDropdownSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(rfq.getItemDropdownList()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//fresh vendor
		rfq.getFreshVendor().click();
		rfq.getFreshVendorSearch().sendKeys(excel.getCellDataString(1, 2));
		Thread.sleep(2000);
		List<WebElement> freshVendorList = rfq.getFreshVendorList();
		for(int i=0 ; i<freshVendorList.size(); i++) {
			if(freshVendorList.get(i).getText().contains(excel.getCellDataString(1, 2)) ) {
				freshVendorList.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//Add Quantity code
		rfq.getQuantity().clear();
		rfq.getQuantity().sendKeys(excel.getCellDataNumber(1, 1));

		rfq.getAddLineItem().click();
		rfq.getSaveButton().click();

		sucess_message = rfq.getSuccessMessage().getText();
		expected_success_message = "RFQ added Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Add Message: "+sucess_message.replace("×", ""));

		driver.switchTo().activeElement();
		Thread.sleep(2000);
		rfq.getPreviewCloseButton().click();
	}

	@Test(priority = 2)
	public void edit_rfq() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Edit RFQ------");
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "RFQ");		
		RFQPage rfq = new RFQPage(driver);

		rfq.getPurchase().click();
		rfq.getHamburgerMenuClick().click();
		Thread.sleep(2000);
		rfq.getRFQMenu().click(); //Clicking on RFQ Menu option
		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@id='table-estimates']//tr[1]//td[1]//a")).click();
		Thread.sleep(2000);

		driver.switchTo().activeElement();
		rfq.getEditButton().click();

		//Add Item Code
		rfq.getItemDropdown().click();
		rfq.getItemDropdownSearch().sendKeys(excel.getCellDataString(2, 0));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(rfq.getItemDropdownList()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(2, 0)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//fresh vendor
		rfq.getFreshVendor().click();
		rfq.getFreshVendorSearch().sendKeys(excel.getCellDataString(2, 2));
		Thread.sleep(2000);
		List<WebElement> freshVendorList = rfq.getFreshVendorList();
		for(int i=0 ; i<freshVendorList.size(); i++) {
			if(freshVendorList.get(i).getText().contains(excel.getCellDataString(2, 2)) ) {
				freshVendorList.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//Add Quantity code
		rfq.getQuantity().clear();
		rfq.getQuantity().sendKeys(excel.getCellDataNumber(2, 1));

		rfq.getAddLineItem().click();
		rfq.getSaveButton().click();

	}

	@AfterTest
	public void driverClose() 	
	{

		driver.close();
	}
}
