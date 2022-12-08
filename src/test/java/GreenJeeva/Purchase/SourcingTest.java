package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.SourcingPage;
import utils.ExcelUtils;

public class SourcingTest extends base {

	WebDriver driver;
	
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test
	public void addNewSourcing() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Add New Sourcing------");
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Sourcing");		
		SourcingPage sp = new SourcingPage(driver);
		sp.getPurchase().click();
		sp.getHamburgerMenuClick().click();
		sp.getSourcingLink().click();
		
		Thread.sleep(2000);
		sp.getNewSourcing_btn().click(); //Clicking on New Sourcing Button
		
		//Selecting Product Name
		sp.getProductName().click();
		sp.getProductSearch().sendKeys(excel.getCellDataString(1, 0));
		Thread.sleep(3000);
		List<WebElement> productList = sp.getProductList();
		for(int i=0 ; i<productList.size(); i++) {
			if(productList.get(i).getText().contains(excel.getCellDataString(1, 0)) ) {
				productList.get(i).click();
				break;
			}
		}
		
		//Selecting the desired Vendor name from dropdown
		sp.getVendorDropdown().click();
		sp.getVendorDropdownSearch().sendKeys(excel.getCellDataString(1, 1));
		Thread.sleep(3000);
		List<WebElement> vendorList = sp.getVendorDropdownSuggestion();
		for(int i=0 ; i<vendorList.size(); i++) {
			if(vendorList.get(i).getText().contains(excel.getCellDataString(1, 1)) ) {
				vendorList.get(i).click();
				break;
			}
		} 
		
		//Selecting Lead Time from dropdown
		sp.getLeadTime().click();
		List<WebElement> LeadTimeList = sp.getLeadTimeList();
		for(int i=0 ; i<LeadTimeList.size(); i++) {
			if(LeadTimeList.get(i).getText().contains(excel.getCellDataNumber(1, 2)) ) {
				LeadTimeList.get(i).click();
				break;
			}
		}
		
		//Adding purchase price
		sp.getPurchasePrice().sendKeys(excel.getCellDataNumber(1, 3));
		
		//selecting Incoterm from dropdown
		sp.getIncoterm().click();
		List<WebElement> incotermList = sp.getIncotermList();
		for(int i=0 ; i<incotermList.size(); i++) {
			if(incotermList.get(i).getText().contains(excel.getCellDataString(1, 4)) ) {
				incotermList.get(i).click();
				break;
			}
		}
		
		//adding packing details
		sp.getPackaging().sendKeys(excel.getCellDataString(1, 5));
		
		//Country
		sp.getCountryDropdown().click();
		sp.getCountryDropdownSearch().sendKeys(excel.getCellDataString(1, 6));
		List<WebElement> countryList = sp.getCountryDropdownSuggestion();//driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li"));
		for(int i=0 ; i<countryList.size(); i++) {
			String list_country = countryList.get(i).getText().replace(" -", "");
			String Excel_data=excel.getCellDataString(1, 6);
			if( Excel_data.matches(list_country)) {
				countryList.get(i).click();
				break;
			}
		}
		
		//adding quantity
		sp.getQuantity().clear();
		sp.getQuantity().sendKeys(excel.getCellDataNumber(1, 7));
		
		//Adding MOQ, Organic Status, Location, Availability, Latin Name, description
		sp.getMOQ().sendKeys(excel.getCellDataString(1, 8));
		sp.getOrganicStatus().sendKeys(excel.getCellDataString(1, 9));
		sp.getLocation().sendKeys(excel.getCellDataString(1, 10));
		sp.getAvailability().sendKeys(excel.getCellDataNumber(1, 11));
		sp.getLatinName().sendKeys(excel.getCellDataString(1, 12));
		driver.switchTo().frame("description_ifr");
		sp.getDescription().sendKeys(excel.getCellDataString(1, 13));
		driver.switchTo().defaultContent();
		
		//Save button click
		sp.getSaveButton().click();
		
		//Sourcing added Successfully.
		//driver.findElement(By.xpath("//p[@class='alert-custom success']"));
		//System.out.println("Success Text==========>>"+driver.findElement(By.xpath("//p[@class='alert-custom success']")).getText());
		
		//verifying the record is appeared in Table listing of Sourcing
		driver.switchTo().activeElement();
		String excelData= excel.getCellDataString(1, 0);
		//System.out.println("ExcelData=========>>"+ excelData);
		String sku = driver.findElement(By.xpath("(//td[contains(@title,'"+excelData+"')])")).getText();
		//System.out.println("SKU========>>"+ sku);
		Assert.assertTrue(sku.matches(excelData));	
	}
	
	@AfterTest
	public void driverClose() 	
	{
		driver.close();
	}
}
