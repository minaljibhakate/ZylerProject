package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SourcingPage {

	public WebDriver driver;
	public SourcingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Purchase link
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Sourcing Menu
	private By sourcing_link = By.xpath("//div[@class='account-details chart-of-acc']//li[4]//a[1]");
	
	//New Sourcing button
	private By newSourcing_btn = By.xpath("//a[normalize-space()='New Sourcing']");
	
	//Product
	private By productName_txt = By.xpath("//button[@data-id='name']");
	private By productName_search = By.xpath("(//input[@aria-label='Search'])[1]");
	private By productName_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//Vendor
	private By vendor_dropdown = By.xpath("//button[@data-id='clientid']");
	private By vendor_search = By.xpath("(//input[@aria-label='Search'])[2]");
	private By vendor_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//Lead Time
	private By lead_time_dropdown = By.xpath("//button[@title='Select Lead Time']");
	private By lead_time_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//Purchase price
	private By purchase_price_txt = By.xpath("//input[@id='purchase_price']");
	
	//Incoterm
	private By incoterm_dropdown = By.xpath("//button[contains(@data-id,'incoterm')]");
	private By incoterm_list = By.xpath("//ul[@class=\"dropdown-menu inner show\"]//li");
	
	//Packaging
	private By packaging_txt = By.xpath("//input[@id='packaging']");
	
	//Country
	private By country_dropdown = By.xpath("//button[@data-id='country_origin']");
	private By country_search = By.xpath("(//input[@aria-label='Search'])[3]");
	private By country_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//Quantity
	private By quantity_txt = By.xpath("//input[@id='quantity']");
	
	//MOQ
	private By moq_txt = By.xpath("//input[@id='moq']");
	
	//Organic STatus
	private By organicStatus_txt = By.xpath("//input[@id='organic_status']");
	
	//Location
	private By location_txt = By.xpath("//input[@id='location']");
	
	//Availability
	private By availability_txt = By.xpath("//input[@id='availability']");
	
	//Latin Name
	private By latinName_txt= By.xpath("//input[@id='latin_name']");
	
	//Description
	private By description_txt = By.xpath("//body[@data-id='description']");//body[@data-id='description']
	
	//Save button
	private By save_button = By.xpath("//button[normalize-space()='Save']");
	
	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getSourcingLink()
	{
		return driver.findElement(sourcing_link);
	}
	public WebElement getNewSourcing_btn()
	{
		return driver.findElement(newSourcing_btn);
	}
	public WebElement getProductName()
	{
		return driver.findElement(productName_txt);
	}
	public WebElement getProductSearch()
	{
		return driver.findElement(productName_search);
	}
	public List<WebElement> getProductList()
	{
		return driver.findElements(productName_list);
	}
	public WebElement getVendorDropdown()
	{
		return driver.findElement(vendor_dropdown);
	}
	public WebElement getVendorDropdownSearch()
	{
		return driver.findElement(vendor_search);
	}
	public List<WebElement> getVendorDropdownSuggestion()
	{
		return driver.findElements(vendor_list);
	}
	public WebElement getLeadTime()
	{
		return driver.findElement(lead_time_dropdown);
	}
	public List<WebElement> getLeadTimeList()
	{
		return driver.findElements(lead_time_list);
	}
	public WebElement getPurchasePrice()
	{
		return driver.findElement(purchase_price_txt);
	}
	public WebElement getIncoterm()
	{
		return driver.findElement(incoterm_dropdown);
	}
	public List<WebElement> getIncotermList()
	{
		return driver.findElements(incoterm_list);
	}
	public WebElement getPackaging()
	{
		return driver.findElement(packaging_txt);
	}
	public WebElement getCountryDropdown()
	{
		return driver.findElement(country_dropdown);
	}
	public WebElement getCountryDropdownSearch()
	{
		return driver.findElement(country_search);
	}
	public List<WebElement> getCountryDropdownSuggestion()
	{
		return driver.findElements(country_list);
	}
	public WebElement getQuantity()
	{
		return driver.findElement(quantity_txt);
	}
	public WebElement getMOQ()
	{
		return driver.findElement(moq_txt);
	}
	public WebElement getOrganicStatus()
	{
		return driver.findElement(organicStatus_txt);
	}
	public WebElement getLocation()
	{
		return driver.findElement(location_txt);
	}
	public WebElement getAvailability()
	{
		return driver.findElement(availability_txt);
	}
	public WebElement getLatinName()
	{
		return driver.findElement(latinName_txt);
	}
	public WebElement getDescription()
	{
		return driver.findElement(description_txt);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}

}
