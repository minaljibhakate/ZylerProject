package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntityPage {

	public WebDriver driver;
	public EntityPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By entity = By.xpath("//header//li[2]//a[1]");
	private By newCustomer_btn = By.xpath("//button[@class='btn btn-default btn-sm btn-addon']");
	private By company_txt_field = By.xpath("//input[@id='company']");
	private By country_dropdown = By.xpath("//button[@data-id='country']//div[@class='filter-option-inner-inner']");
	private By country_dropdown_search = By.xpath("//div[contains(@x-placement,'bottom-start')]//input[contains(@aria-label,'Search')]");//input[@aria-invalid='false']
	private By country_dropdown_suggestion = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	private By state_field = By.xpath("//input[@id='state']");
	private By state_list = By.xpath("//ul[@class='typeahead dropdown-menu']//li");
	private By city_field = By.xpath("//input[@id='city']");
	private By city_suggestion = By.xpath("//ul[@class='typeahead dropdown-menu']//li");
	private By region_dropdown = By.xpath("//button[@data-id='region']");//button[@data-id='region']//div[@class='filter-option']
	private By region_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By address_field= By.xpath("//input[@id='address']");
	private By zipcode = By.xpath("//input[@id='zip']");
	private By zipcode_list = By.xpath("//ul[@class='typeahead dropdown-menu']//li");
	private By phone_field = By.xpath("//input[@id='phonenumber']");
	private By companyEmail1_field = By.xpath("//input[@id='email_1']");
	
	private By group_dropdown= By.xpath("//button[@data-id='groups_in[]']//div[@class='filter-option']");
	private By group_dropdown_search = By.xpath("(//input[@aria-label=\"Search\"])[3]");
	private By group_dropdown_suggestion = By.xpath("//div[@class='inner show']//li");
	
	private By fda_reg_txt = By.xpath("//input[@id='vat']");
	private By save_btn = By.cssSelector("button[type='submit']");
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
//	private By attn_field = By.xpath("//input[@id='attn']");
//	private By company_email1_field = By.xpath("//input[@id='email_1']");
	private By avatar = By.xpath("//span[@class='material-icons align-middle']");
	private By logout = By.xpath("//a[normalize-space()='Logout']");
	
	public WebElement getEntity()
	{
		return driver.findElement(entity);
	}
	public WebElement getNewCustomer()
	{
		return driver.findElement(newCustomer_btn);
	}
	public WebElement getCompany()
	{
		return driver.findElement(company_txt_field);
	}
	public WebElement getCountryDropdown()
	{
		return driver.findElement(country_dropdown);
	}
	public WebElement getCountryDropdownSearch()
	{
		return driver.findElement(country_dropdown_search);
	}
	public List<WebElement> getCountryDropdownSuggestion()
	{
		return driver.findElements(country_dropdown_suggestion);
	}
	public WebElement getState()
	{
		return driver.findElement(state_field);
	}
	public List<WebElement> getStateList()
	{
		return driver.findElements(state_list);
	}
	public WebElement getCity()
	{
		return driver.findElement(city_field);
	}
	public List<WebElement> getCitySuggestion()
	{
		return driver.findElements(city_suggestion);
	}
	public WebElement getRegionDropdown()
	{
		return driver.findElement(region_dropdown);
	}
	public List<WebElement> getRegionList()
	{
		return driver.findElements(region_list);
	}
	public WebElement getAddress()
	{
		return driver.findElement(address_field);
	}
	public WebElement getZipcode()
	{
		return driver.findElement(zipcode);
	}
	public List<WebElement> getZipcodeList()
	{
		return driver.findElements(zipcode_list);
	}
	public WebElement getPhone()
	{
		return driver.findElement(phone_field);
	}
	public WebElement getCompanyEmail1()
	{
		return driver.findElement(companyEmail1_field);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_btn);
	}
	public WebElement getGroupDropdown()
	{
		return driver.findElement(group_dropdown);
	}
	public WebElement getGroupDropdownSearch()
	{
		return driver.findElement(group_dropdown_search);
	}
	public List<WebElement> getGroupDropdownSuggestion()
	{
		return driver.findElements(group_dropdown_suggestion);
	}
	public WebElement getFDAReg()
	{
		return driver.findElement(fda_reg_txt);
	}
	
	public WebElement getAvatar()
	{
		return driver.findElement(avatar);
	}
	public WebElement getLogoutClick()
	{
		return driver.findElement(logout);
	}
	
}
