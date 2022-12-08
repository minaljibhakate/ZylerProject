package GreenJeeva;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.EntityPage;
import utils.ExcelUtils;
import java.util.Random;

public class EntityTest extends base{

	WebDriver driver;
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test
	public void addNewCustomerEntity() throws IOException, InterruptedException
	{
		System.out.println("------Started Executing Add New Customer------");
		Random random = new Random();       		 // Generate random integers in range 0 to 999
		int random_int = random.nextInt(1000);        // Generate random integers in range 0 to 999
		EntityPage ep = new EntityPage(driver);
		ep.getEntity().click();
		ep.getNewCustomer().click();
		ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "Customer");
		
		//company name	
		String company_name = excel.getCellDataString(1, 0)+random_int;
		ep.getCompany().sendKeys(company_name);//
		
		//Country
		ep.getCountryDropdown().click();
		Thread.sleep(2000);
		ep.getCountryDropdownSearch().sendKeys(excel.getCellDataString(1, 1));
		List<WebElement> countryList = ep.getCountryDropdownSuggestion();//driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']//li"));
		for(int i=0 ; i<countryList.size(); i++) {
			String list_country = countryList.get(i).getText().replace(" -", "");
			String Excel_data=excel.getCellDataString(1, 1);
			
			if( Excel_data.matches(list_country)) {
				countryList.get(i).click();
				break;
			}
		}
			
		//State
		ep.getState().sendKeys(excel.getCellDataString(1, 2));
		Thread.sleep(2000);
		List<WebElement> stateList = ep.getStateList();//driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']//li"));
		for(int i=0 ; i<stateList.size(); i++) {
			if(stateList.get(i).getText().contains(excel.getCellDataString(1, 2))) {
				stateList.get(i).click();
				break;
			}
		}
		
		
		//City
		ep.getCity().sendKeys(excel.getCellDataString(1, 3));
		Thread.sleep(2000);
		List<WebElement> cityList = ep.getCitySuggestion();//driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']//li"));
		for(int i=0 ; i<cityList.size(); i++) {
			if(cityList.get(i).getText().contains(excel.getCellDataString(1, 3))) {
				cityList.get(i).click();
				break;
			}
		}
		
		//Region
		ep.getRegionDropdown().click();
		Thread.sleep(2000);
		List<WebElement> list = ep.getRegionList();
		for(int i=0 ; i<list.size(); i++) {
			//System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains(excel.getCellDataString(1, 4))) {
				list.get(i).click();
			}
		}
		
		//Address
		ep.getAddress().sendKeys(excel.getCellDataString(1, 5));
		
		//Phone Number
		ep.getPhone().sendKeys(excel.getCellDataNumber(1, 8));
		
		//Postal Code
		ep.getZipcode().sendKeys(excel.getCellDataNumber(1, 6));
		Thread.sleep(2000);
		List<WebElement> zipCodeList = ep.getZipcodeList();
		for(int i=0 ; i<zipCodeList.size(); i++) {
			if(zipCodeList.get(i).getText().contains(excel.getCellDataNumber(1, 6))) {
				zipCodeList.get(i).click();
				break;
			}
		}
		
		
		//groups
		ep.getGroupDropdown().click();
		ep.getGroupDropdownSearch().click();
		ep.getGroupDropdownSearch().sendKeys(excel.getCellDataString(1, 13));
		List<WebElement> groupList = ep.getGroupDropdownSuggestion();
		for(int i=0 ; i<groupList.size(); i++) {
			if(groupList.get(i).getText().contains(excel.getCellDataString(1, 13)) ) {
				groupList.get(i).click();
				break;
			}
		}
		ep.getGroupDropdown().click();
					
		ep.getFDAReg().sendKeys(excel.getCellDataString(1, 14));
		
		
		//Save button click
		ep.getSaveButton().click();
		
		//Verifying success Message
		WebElement success_wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ep.getSuccessMessage()));	
		String sucess_message = success_wait.getText();
		String expected_success_message = "Customer added Successfully.";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}
	
	@AfterTest
	public void driverClose() 	
	{
	
		driver.close();
	}
}
