package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReceivedQuotationPage {
	public WebDriver driver;

	public ReceivedQuotationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By received_quotation_menu = By.xpath("(//a[normalize-space()='Received Quotation'])[1]");

	//Edit button
	private By edit_button = By.cssSelector("a[class='btn btn-default btn-with-tooltip float-left mr-2'] i[class='material-icons']");

	//item
	private By item_dropdown = By.xpath("//button[@data-id='item_select_rfq']");
	private By item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[3]");
	private By item_dropdown_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");

	//Quantity
	private By quantity = By.xpath("//input[@name='quantity']");

	//Prefered Vendor
	private By preferred_vendor = By.xpath("//button[contains(@data-id,'vendor_id')]");

	//Fresh Vendor
	private By fresh_vendor = By.xpath("//button[contains(@data-id,'vendorid')]");

	//Fresh Vendor search
	private By fresh_vendor_search = By.xpath("(//input[@aria-label='Search'])[5]");

	//fresh vendor list
	private By fresh_vendor_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");

	//Add line Item
	private By add_line_item = By.xpath("//i[@class='fas fa-plus-circle']");

	//Save button
	private By save_button = By.xpath("//button[@id='rfq_submit']");

	//More BUtton
	private By more_button = By.xpath("(//button[@type='button'])[4]");

	//View As Vendor
	private By view_as_vendor = By.xpath("//a[normalize-space()='View as Vendor']");

	//Convert To Purchase
	private By convert_to_purchase = By.xpath("//a[normalize-space()='Convert to purchases']");

	//Customer
	private By customer = By.xpath("//button[@data-id='clientid']");

	//Customer Search
	private By customer_search = By.xpath("(//input[@aria-label='Search'])[3]");

	//Customer LIst
	private By customer_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");

	private By currency = By.xpath("//button[@data-id='currency']");
	private By currency_search = By.xpath("(//input[@aria-label='Search'])[5]");
	private By currency_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");

	//purchase date
	private By purchase_date = By.xpath("//input[@id='date']");
	private By calender_next_btn = By.xpath("//div[contains(@class,'xdsoft_mounthpicker')]//button[3]");
	private By dateSelect = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[1]");

	//Save button
	private By save_rfq_purchase = By.xpath("//button[@id='rfq_purchase']");

	//success message
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	//preview close button
	private By preview_close_button = By.xpath("(//button[@type='button'])[8]");
	
	//delete RFQ
	private By delete_rfq = By.xpath("//a[normalize-space()='Delete RFQ']");


	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getReceivedQuotationMenu()
	{
		return driver.findElement(received_quotation_menu);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getItemDropdown()
	{
		return driver.findElement(item_dropdown);
	}
	public WebElement getItemDropdownSearch()
	{
		return driver.findElement(item_dropdown_search);
	}
	public List<WebElement> getItemDropdownList()
	{
		return driver.findElements(item_dropdown_list);
	}
	public WebElement getQuantity()
	{
		return driver.findElement(quantity);
	}
	public WebElement getPreferredVendor()
	{
		return driver.findElement(preferred_vendor);
	}
	public WebElement getFreshVendor()
	{
		return driver.findElement(fresh_vendor);
	}
	public WebElement getFreshVendorSearch()
	{
		return driver.findElement(fresh_vendor_search);
	}
	public List<WebElement>  getFreshVendorList()
	{
		return driver.findElements(fresh_vendor_list);
	}
	public WebElement getAddLineItem()
	{
		return driver.findElement(add_line_item);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getViewAsVendor()
	{
		return driver.findElement(view_as_vendor);
	}
	public WebElement getConvertToPurchase()
	{
		return driver.findElement(convert_to_purchase);
	}
	public WebElement getCustomerDropdown()
	{
		return driver.findElement(customer);
	}
	public WebElement getCustomerSearch()
	{
		return driver.findElement(customer_search);
	}
	public List<WebElement> getCustomerList()
	{
		return driver.findElements(customer_list);
	}
	public WebElement getCurrecy()
	{
		return driver.findElement(currency);
	}
	public WebElement getCurrencySearch()
	{
		return driver.findElement(currency_search);
	}
	public List<WebElement> getCurrencyList()
	{
		return driver.findElements(currency_list);
	}
	public WebElement getPuchaseDate()
	{
		return driver.findElement(purchase_date);
	}
	public WebElement getCalendarNextButton()
	{
		return driver.findElement(calender_next_btn);
	}
	public WebElement getDateSelect()
	{
		return driver.findElement(dateSelect);
	}

	public WebElement getSaveRfqPurchase()
	{
		return driver.findElement(save_rfq_purchase);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	public WebElement getDeleteRFQ()
	{
		return driver.findElement(delete_rfq);
	}
}
