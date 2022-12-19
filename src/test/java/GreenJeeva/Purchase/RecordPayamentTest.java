package GreenJeeva.Purchase;

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
import pageObjects.PurchaseOrderPage;
import pageObjects.RecordPaymentForPO;
import utils.ExcelUtils;

public class RecordPayamentTest extends base{

	WebDriver driver;
	RecordPaymentForPO rpp ;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test
	public void record_payent_for_Purchase_Order() throws InterruptedException
	{
		System.out.println("------Started Executing Record Payment for Purchase Order------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "PurchaseOrder");		
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getPurchase().click();
		//pop.getHamburgerMenuClick().click();
		Thread.sleep(2000);

		pop.getCreateNewPurchaseOrder_btn().click(); //Clicking on Create New purchase order button
		Thread.sleep(2000);

		//Selecting the desired Vendor name from dropdown
		pop.getVendorDropdown().click();
		pop.getVendorDropdownSearch().sendKeys(excel.getCellDataString(4, 0));
		Thread.sleep(3000);
		List<WebElement> vendorList = pop.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(4, 0)) ) {
				vendorList.get(i).click();
				break;
			}
		}

		//selecting warehouse
		pop.getCurrecy().click();
		pop.getCurrencySearch().sendKeys(excel.getCellDataString(4, 5));
		Thread.sleep(2000);
		List<WebElement> currencyList = pop.getCurrencyList();
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<currencyList.size(); i++) {
			if(currencyList.get(i).getText().contains(excel.getCellDataString(4, 5)) ) {
				currencyList.get(i).click();
				break;
			}
		}

		//Add Item Code
		pop.getAddItemDropdown().click();
		pop.getAddItemDropdownSearch().sendKeys(excel.getCellDataString(4, 1));
		Thread.sleep(2000);
		List<WebElement> itemList = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfAllElements(pop.getAddItemDropdownSuggestion()));
		for(int i=0 ; i<itemList.size(); i++) {
			if(itemList.get(i).getText().contains(excel.getCellDataString(4, 1)) ) {
				itemList.get(i).click();
				break;
			}
		}

		//selecting warehouse
		pop.getWarehouse().click();		
		List<WebElement> warehouseList = pop.getWarehouseList();
		//						//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(sop.getWarehouseDropdownSuggestion()));
		for(int i=0 ; i<warehouseList.size(); i++) {
			if(warehouseList.get(i).getText().contains(excel.getCellDataString(4, 4)) ) {
				warehouseList.get(i).click();
				break;
			}
		}

		//Add Pack Size code
		pop.getPackSize().clear();
		pop.getPackSize().sendKeys(excel.getCellDataNumber(4, 3));

		//Add Quantity code
		pop.getQty().clear();
		pop.getQty().sendKeys(excel.getCellDataNumber(4, 2));

		//Add Lot number
		pop.getLotNumber().sendKeys(excel.getCellDataNumber(4, 6));

		//Rate
		pop.getRate().clear();
		pop.getRate().sendKeys(excel.getCellDataNumber(4, 7));

		//click on Add line Item
		pop.getAddLineItemClick().click();

		//click on Save button
		pop.getSaveButton().click();

		driver.switchTo().activeElement();
		rpp = new RecordPaymentForPO(driver);
		rpp.getRecordPayment().click();
		//Thread.sleep(4000);
		rpp.getJournal_desc().sendKeys("Advance Payment - Full Payment");
		String  amount = rpp.getAmount().getAttribute("value");
		System.out.println("Amount:"+amount);

		Select bank_account_dropdown = new Select(rpp.getBankAccountDropdown());
		bank_account_dropdown.selectByVisibleText("HDFC Current Account# 6145");

		rpp.getCrAmount().sendKeys(amount);

		rpp.getSaveButton().click();

		String sucess_message = rpp.getSuccess_message().getText();
		String expected_success_message = "Expenses added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));

		driver.switchTo().activeElement();
		Thread.sleep(3000);
		String voucher_generation_text = rpp.getVoucherGenerationText().getText();
		String voucher_number = voucher_generation_text.substring(24, 34);
		System.out.println("Voucher Generation Text:"+voucher_generation_text);
		System.out.println("Voucher Number Generated:"+voucher_number);
		rpp.getOKButton().click();
	}

	@AfterTest
	public void driverClose() 	
	{
		driver.close();
	}
}
