package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InboundTrackingPage {
	
	public WebDriver driver;
	public InboundTrackingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Purchase link
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
		
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Inbound tracking menu
	private By inboundtracking_menu = By.xpath("(//a[normalize-space()='Inbound Tracking'])[1]");
	//private By inboundtracking_menu = By.xpath("//div[@class='page-wrapper']//li[10]//a[1]");// (.//a[contains(text(),'Inbound Tracking')])[3]
	
	//Create new inbound tracking
	private By create_new_inbound_tracking = By.xpath("//a[normalize-space()='Create New Inbound Tracking']");
	//private By create_new_inbound_tracking = By.xpath("(.//a[contains(text(),'Inbound Tracking')])[2]");
	
	//Vendor
	private By vendor_dropdown = By.xpath("//button[@data-id='clientid']");
	private By vendor_search = By.xpath("(//input[@aria-label='Search'])[1]");
	private By vendor_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//Vendor FDA reg number
	private By fda_number_txt = By.xpath("//input[@id='reg_no']");
	
	private By hsCode_txt = By.xpath("//input[@id='hs_code']");
	private By transport_txt = By.xpath("//input[@id='transport']");
	
	//Country
	private By country_dropdown = By.xpath("//button[@title='Select country']");
	private By country_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//add item
	private By add_item_dropdown = By.xpath("//button[@data-id='item_select_inbound_tracking']");
	private By add_item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[2]");
	private By add_item_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
		
	//purchase order
	private By purchase_order_dropdown = By.xpath("//button[@data-id='purchase_order']");
	private By purchaseOrder_search =By.xpath("(//input[@aria-label='Search'])[3]");
	private By purchaseOrder_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//Quantity
	private By qty_txt = By.xpath("//input[@name='quantity']");
	
	//warehouse
	private By warehouse = By.xpath("//div[contains(text(),'Select Warehouse')]");
	private By warehouse_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//line item add
	private By add_line_item_click = By.xpath("//i[@class='fas fa-plus-circle']");
	
	//Save button
	private By save_button =By.xpath("//button[normalize-space()='Save']");
	
	//Success message
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
									   //div[@class='alert alert-success alert-dismissible']
	//More button message
	private By more_btn = By.xpath("(//button[@type='button'])[5]");
	
	//Genrate putaway sheet button
	private By generate_putaway_sheet = By.xpath("//a[normalize-space()='Generate Putway sheet']");
	
	//product name
	private By productName_txt = By.cssSelector("tr[class='sortable'] td:nth-child(3)");
	
	//product received button
	private By product_received_btn = By.xpath("//a[normalize-space()='Product Received']");
	
	//recived Date
	private By received_date = By.xpath("//input[@id='receive_date']");
	private By received_date_select = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[2]");
	
	//Preview CLose button
	//private By preview_close_button = By.xpath("(//button[@type='button'])[7]");
	private By preview_close_button = By.cssSelector("div[class='modal-content p-3'] button[aria-label='Close'] i[class='material-icons']");
	
	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getInboundTrackingMenuClick()
	{
		return driver.findElement(inboundtracking_menu);
	}
	public WebElement getAddInboundTrackingClick()
	{
		return driver.findElement(create_new_inbound_tracking);
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
	public WebElement getFDANumber()
	{
		return driver.findElement(fda_number_txt);
	}
	public WebElement getHSCode()
	{
		return driver.findElement(hsCode_txt);
	}
	public WebElement getTransport()
	{
		return driver.findElement(transport_txt);
	}
	public WebElement getCountryDropdown()
	{
		return driver.findElement(country_dropdown);
	}
	public List<WebElement> getCountryList()
	{
		return driver.findElements(country_list);
	}
	
	public WebElement getAddItemDropdown()
	{
		return driver.findElement(add_item_dropdown);
	}
	public WebElement getAddItemDropdownSearch()
	{
		return driver.findElement(add_item_dropdown_search);
	}
	public List<WebElement> getAddItemlist()
	{
		return driver.findElements(add_item_list);
	}
	
	public WebElement getPurchaseOrderDropdown()
	{
		return driver.findElement(purchase_order_dropdown);
	}
	public WebElement getPurchaseOrderSearch()
	{
		return driver.findElement(purchaseOrder_search);
	}
	public List<WebElement> getPurchaseOrderlist()
	{
		return driver.findElements(purchaseOrder_list);
	}
	
	public WebElement getQuantity()
	{
		return driver.findElement(qty_txt);
	}
	
	public WebElement getWarehouse()
	{
		return driver.findElement(warehouse);
	}
	public List<WebElement> getWarehouseList()
	{
		return driver.findElements(warehouse_list);
	}
	public WebElement getAddLineItemClick()
	{
		return driver.findElement(add_line_item_click);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_btn);
	}
	public WebElement getGeneratePutAwaySheetClick()
	{
		return driver.findElement(generate_putaway_sheet);
	}
	public WebElement getProductName()
	{
		return driver.findElement(productName_txt);
	}
	public WebElement getProductReceived()
	{
		return driver.findElement(product_received_btn);
	}
	public WebElement getReceivedDate()
	{
		return driver.findElement(received_date);
	}
	
	
	public WebElement getReceivedDateSelect()
	{
		return driver.findElement(received_date_select);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	
}
