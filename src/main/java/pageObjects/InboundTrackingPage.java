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

	//table Id click
	private By table_id_click = By.xpath("//table[@id='table-inbTracking']//tr[1]//td[1]//a");

	//Delete message
	private By del_success_msg = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

	//delete bbutton
	private By delete_button = By.xpath("//a[normalize-space()='Delete']");

	//type filter
	private By type_filer = By.xpath("(//button[@type='button'])[3]");

	//internation type
	private By international_filter = By.xpath("//a[normalize-space()='International']");

	//IB tye column list
	//	private By IB_type_column_list = By.xpath("//table//tr//td[2]");
	private By IB_type_column_list = By.xpath("(//td[@title='International'][normalize-space()='International'])");

	//Edit button
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2 '])[1]");

	//Quantity field in Edit
	private By qty_edit= By.xpath("(//input[@type='number'])[2]");

	//Attach a File message
	private By attach_file = By.xpath("//a[normalize-space()='Attach File']");

	//file upload
	private By file_upload = By.xpath("//span[normalize-space()='Drop files here to upload']");

	//activity log
	private By activity_log = By.xpath("//a[normalize-space()='Activity Log']");

	//Received Button
	private By received_button = By.xpath("//a[normalize-space()='Received']");

	//Received Status
	private By received_status = By.xpath("(//tbody//tr//td[7])[6]");

	//Open Status
	private By open_status = By.xpath("(//tbody//tr//td[7])[27]");	

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
	public WebElement getTableIDClick()
	{
		return driver.findElement(table_id_click);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getDeleteSuccessMessage()
	{
		return driver.findElement(del_success_msg);
	}

	public WebElement getTypeFilter()
	{
		return driver.findElement(type_filer);
	}

	public WebElement getInternationalFilter()
	{
		return driver.findElement(international_filter);
	}

	public List<WebElement> getIBColunmnList()
	{
		return driver.findElements(IB_type_column_list);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getQuantityEdit()
	{
		return driver.findElement(qty_edit);
	}
	public WebElement getAttachFile()
	{
		return driver.findElement(attach_file);
	}
	public WebElement getFileUpload()
	{
		return driver.findElement(file_upload);
	}
	public WebElement getActivityLog()
	{
		return driver.findElement(activity_log);
	}
	public WebElement getReceivedButton()
	{
		return driver.findElement(received_button);
	}
	public WebElement getReceivedStatus()
	{
		return driver.findElement(received_status);
	}
	public WebElement getOpenStatus()
	{
		return driver.findElement(open_status);
	}
}
