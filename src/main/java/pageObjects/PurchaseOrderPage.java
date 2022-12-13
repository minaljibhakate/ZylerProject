package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOrderPage {

	public WebDriver driver;
	public PurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By createNewPurchaseOrder_btn = By.xpath("//a[normalize-space()='Create New purchase order']");
	private By vendor_dropdown = By.xpath("//button[@data-id='vendorid']");
	private By vendor_dropdown_search = By.xpath("(//input[@aria-label='Search'])[1]");
	private By vendor_dorpdown_suggestions_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By add_item_dropdown = By.xpath("//button[@data-id='purchase_item_select']");
	private By add_item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[6]");
	private By add_item_dropdown_suggestions = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By qty_txt_field = By.xpath("//input[@placeholder='Quantity']");
	private By packSize_txt_field = By.xpath("//input[@placeholder='PackSize']");
	private By warehouse = By.xpath("//div[contains(text(),'Select Warehouse')]");
	private By warehouse_list = By.xpath("//ul[@class=\"dropdown-menu inner show\"]//li");
	private By add_line_item_click = By.xpath("//i[@class='fas fa-plus-circle']");
	private By save_button =By.xpath("//button[@id='submit_form']");
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By currency = By.xpath("//button[@data-id='currency']");
	private By currency_search = By.xpath("(//input[@aria-label='Search'])[4]");
	private By currency_list = By.xpath("//ul[@class=\"dropdown-menu inner show\"]//li");
	private By purchase_id = By.xpath("(//a[contains(text(),'JOPO')])[26]");
	private By lotNumber = By.xpath("//input[@name='lotno']");
	private By more_btn = By.xpath("(//button[@type='button'])[9]");
	private By attachCOADocument_link = By.xpath("//a[contains(text(),'Attach COA Document')]");
	//Preview CLose button
	private By preview_close_button1 = By.xpath("(//button[@class='close-arrow'])[1]");
	//upload File
	private By upload_file = By.xpath("//form[@id='purchasecoa-upload']");
	private By upload_file_close_button = By.xpath("//button[@class='close']");
	//Preview CLose button
	private By preview_close_button = By.xpath("(//button[@type='button'])[8]");
	//Rate
	private By rate_txt = By.xpath("//input[@name='rate']");
	//	private By more_button = By.xpath("(//button[@type='button'])[9]");
	private By delete_button = By.xpath("//a[normalize-space()='Delete purchase']");

	//current status
	private By current_status = By.xpath("(//div[@name='fetch_current_status'])[1]");
	//current status Select
	private By current_status_select = By.xpath("(//select[@id='so_current_status'])[1]");
	//Yes button
	private By yes_button = By.xpath("//button[normalize-space()='Yes']");
	//Search
	private By search = By.xpath("//input[@type='search']");
	//PO Link
	private By po_link = By.xpath("//tbody//tr[1]//td[1]//a");
	//Edit button
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");


	//Status
	private By status_dropdown = By.xpath("(//button[@type='button'])[6]");
	private By status_list = By.xpath("//div[@class='dropdown-menu show']//li//a");
	private By status_column_list = By.xpath("//table[@id='table-purchases']//div[@class='input-group-text']");

	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getCreateNewPurchaseOrder_btn()
	{
		return driver.findElement(createNewPurchaseOrder_btn);
	}
	public WebElement getVendorDropdown()
	{
		return driver.findElement(vendor_dropdown);
	}
	public WebElement getVendorDropdownSearch()
	{
		return driver.findElement(vendor_dropdown_search);
	}
	public List<WebElement> getVendorDropdownSuggestion()
	{
		return driver.findElements(vendor_dorpdown_suggestions_list);
	}
	public WebElement getAddItemDropdown()
	{
		return driver.findElement(add_item_dropdown);
	}
	public WebElement getAddItemDropdownSearch()
	{
		return driver.findElement(add_item_dropdown_search);
	}
	public List<WebElement> getAddItemDropdownSuggestion()
	{
		return driver.findElements(add_item_dropdown_suggestions);
	}
	public WebElement getQty()
	{
		return driver.findElement(qty_txt_field);
	}
	public WebElement getPackSize()
	{
		return driver.findElement(packSize_txt_field);
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
	public WebElement getPreviewCloseButton1()
	{
		return driver.findElement(preview_close_button1);
	}
	public WebElement getPurchaseOrderId()
	{
		return driver.findElement(purchase_id);
	}
	public WebElement getRate()
	{
		return driver.findElement(rate_txt);
	}
	public WebElement getLotNumber()
	{
		return driver.findElement(lotNumber);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_btn);
	}
	public WebElement getAttachCOADocument()
	{
		return driver.findElement(attachCOADocument_link);
	}


	public WebElement getUploadfile()
	{
		return driver.findElement(upload_file);
	}
	public WebElement getUploadFileCloseButton()
	{
		return driver.findElement(upload_file_close_button);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}

	//	public WebElement getMoreButton()
	//	{
	//		return driver.findElement(more_button);
	//	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getCurrentStatus()
	{
		return driver.findElement(current_status);
	}
	public WebElement getCurrentStatusSelect()
	{
		return driver.findElement(current_status_select);
	}
	public WebElement getYesStatus()
	{
		return driver.findElement(yes_button);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getPOLink()
	{
		return driver.findElement(po_link);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	//status
	//status filter
	public WebElement getStatusDropdown()
	{
		return driver.findElement(status_dropdown);
	}
	public List<WebElement> getStatusList()
	{
		return driver.findElements(status_list);
	}
	public List<WebElement> getStatusColumnList()
	{
		return driver.findElements(status_column_list);
	}
}
