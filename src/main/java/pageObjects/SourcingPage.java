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

	//Vendor Icon click
	private By vendor_icon = By.xpath("//table[@id='table-sources']//tr[1]//td[2]//i[@class='fa fa-vimeo-square']");

	//Purchase Icon
	private By purchase_icon = By.xpath("//table[@id='table-sourcing_vendors']//tr[1]//td[2]//i[@class='fab fa-product-hunt']");

	//Add Sourcing Price
	private By add_sourcing_price_btn = By.xpath("//button[contains(@onclick,'open_add_sourcing_price_div')]");

	//	Incotterm Select
	private By incorterm_select = By.xpath("//select[@id='incoterm']");

	//	Valid Till Date
	private By price_valid_till_date = By.xpath("//input[@id='valid_till_date']");

	//Country
	private By country_dropdown_sourcing_price = By.xpath("//div[contains(text(),'Select country')]");
	private By country_list_sourcing_price = By.xpath("//ul[@class='dropdown-menu inner show']//li");

	//	shelflife
	private By shelflife = By.xpath("//input[@id='shelflife']");

	//	Calendar next button
	private By calendar_next_button = By.xpath("//div[@class='xdsoft_mounthpicker']//button[3]");

	//	Date Selection
	private By date_selection = By.xpath("(//div[@class='xdsoft_calendar'])[1]");

	//	Latest Sourcing Data Text
	private By latest_sourcing_data_text = By.xpath("//p[@id='latest_sourcing_dat_preview']");

	//	Delete button
	private By delete_button = By.xpath("(//i[contains(@class,'material-icons')][normalize-space()='delete'])[1]");

	//	Yes Button
	private By yes_button = By.xpath("//button[normalize-space()='Yes']");

	//	SUccess Message
	private By success_message = By.xpath("//div[@class='sweet-alert hideSweetAlert']");

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
	public WebElement getVendorIcon()
	{
		return driver.findElement(vendor_icon);
	}
	public WebElement getPurchaseIcon()
	{
		return driver.findElement(purchase_icon);
	}
	public WebElement getAddSourcingPrice()
	{
		return driver.findElement(add_sourcing_price_btn);
	}
	public WebElement getIncotermSelect()
	{
		return driver.findElement(incorterm_select);
	}
	public WebElement getPriceValidTillDate()
	{
		return driver.findElement(price_valid_till_date);
	}

	public WebElement getCountryDropdownSourcingPrice()
	{
		return driver.findElement(country_dropdown_sourcing_price);
	}

	public List<WebElement> getCountryDropdownListSourcingPrice()
	{
		return driver.findElements(country_list_sourcing_price);
	}
	public WebElement getShelfLife()
	{
		return driver.findElement(shelflife);
	}
	public WebElement getCalendarNextButton()
	{
		return driver.findElement(calendar_next_button);
	}
	public WebElement getLatestSourcingData()
	{
		return driver.findElement(latest_sourcing_data_text);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getYesButton()
	{
		return driver.findElement(yes_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_message);
	}
	public WebElement getDateSelection()
	{
		return driver.findElement(date_selection);
	}
}
