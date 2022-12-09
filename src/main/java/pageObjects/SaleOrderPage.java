package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaleOrderPage {

	public WebDriver driver;
	public SaleOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By sale_link = By.xpath("//a[normalize-space()='Sale']");
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	//Enquiry Menu
	private By so_menu = By.xpath("(//a[normalize-space()='Sales Order'])[1]");
	private By create_new_sales_order_btn = By.xpath("//a[@class='btn btn-default btn-sm btn-addon new-invoice-list']");
	private By customer_dropdown = By.xpath("//button[@data-id='clientid']");
	private By customer_dropdown_search = By.xpath("//div[@class='f_client_id_salesorder']//input[@aria-label='Search']");
	private By customer_dropdown_suggestion = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By sales_agent_dropdown = By.xpath("//button[contains(@data-id,'sale_agent')]");
	private By sales_agent_dropdown_search = By.xpath("//div[@x-placement='bottom-start']//input[@aria-label='Search']");
	private By sales_agent_dropdown_search_suggestion = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By add_item_dropdown = By.xpath("//button[@data-id='item_select_salesorder']");
	private By add_item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[6]");
	private By add_item_dropdown_suggestions = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	private By warehouse_dropdown = By.xpath("//button[@title='Select Warehouse']");
	private By warehouse_dropdown_selection = By.xpath("//div[@class='inner show']//li");
	private By qty_txt_field = By.xpath("//input[@name='quantity']");
	private By rate_txt_field = By.xpath("//input[@name='rate']");
	private By current_state_dropdown = By.xpath("//button[@data-id='so_current_status']");
	private By current_state_dropdown_suggestions = By.xpath("//div[@class=\"inner show\"]//li"); 
	private By add_line_item_click = By.xpath("//i[@class='fas fa-plus-circle']");
	private By save_button =By.xpath("//button[@id='submit_form']");
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By popup_modal = By.xpath("(//div[@class='modal-dialog modal-lg'])[1]");
	private By close_button = By.xpath("(//button[@class='close-arrow'])[1]");
	private By sales_order_id = By.xpath("(//a[contains(text(),'JOSO')])[26]");
	private By assigned_lot = By.name("lotno");	// By.xpath("//select[@name='lotno']");
	private By more_button = By.xpath("(//button[@type='button'])[9]");
	private By delete_button = By.xpath("//a[normalize-space()='Delete']");
	
	//current status
	private By current_status = By.xpath("(//div[@name='fetch_current_status'])[1]");
	//current status Select
	private By current_status_select = By.xpath("(//select[@name='so_current_status'])[1]");
	//Yes button
	private By yes_button = By.xpath("//button[normalize-space()='Yes']");
	//Search
	//	private By search = By.xpath("//input[@type='search']");
	//first SO number click from table
	private By SO_number_click = By.xpath("//tbody//tr[1]//td[1]//a");
	//Edit button click
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");
	
	//Status
	private By status_dropdown = By.xpath("(//button[@type='button'])[7]");
	private By status_list = By.xpath("//ul[@class='dropdown-menu show']//li//a");
	private By status_column_list = By.xpath("//table[@id='table-salesorders']//div[@class='input-group-text']");	
	
	public WebElement getSale()
	{
		return driver.findElement(sale_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getSOMenuClick()
	{
		return driver.findElement(so_menu);
	}
	public WebElement getCreateNewSalesOrder()
	{
		return driver.findElement(create_new_sales_order_btn);
	}
	public WebElement getCustomerDropdown()
	{
		return driver.findElement(customer_dropdown);
	}
	public WebElement getCustomerDropdownSearch()
	{
		return driver.findElement(customer_dropdown_search);
	}
	public List<WebElement> getCustomerDropdownSuggestion()
	{
		return driver.findElements(customer_dropdown_suggestion);
	}
	public WebElement getSalesAgentDropdown()
	{
		return driver.findElement(sales_agent_dropdown);
	}
	public WebElement getSalesAgentSearch()
	{
		return driver.findElement(sales_agent_dropdown_search);
	}
	public List<WebElement> getSalesAgentDropdownSuggestion()
	{
		return driver.findElements(sales_agent_dropdown_search_suggestion);
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
	public WebElement getWarehouseDropdown()
	{
		return driver.findElement(warehouse_dropdown);
	}
	public List<WebElement> getWarehouseDropdownSuggestion()
	{
		return driver.findElements(warehouse_dropdown_selection);
	}
	public WebElement getQty()
	{
		return driver.findElement(qty_txt_field);
	}
	public WebElement getRate()
	{
		return driver.findElement(rate_txt_field);
	}
	public WebElement getCurrentStatus()
	{
		return driver.findElement(current_state_dropdown);
	}
	public List<WebElement> getCurrentStatusDropdownSuggestion()
	{
		return driver.findElements(current_state_dropdown_suggestions);
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
	public WebElement getPopupModal()
	{
		return driver.findElement(popup_modal);
	}
	public WebElement getCloseButton()
	{
		return driver.findElement(close_button);
	}
	public WebElement getSalesOrderId()
	{
		return driver.findElement(sales_order_id);
	}
	public WebElement getAssignedLot()
	{
		return driver.findElement(assigned_lot);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getCurrentStatusList()
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
//	public WebElement getSearch()
//	{
//		return driver.findElement(search);
//	}
	public WebElement getSONumberClick()
	{
		return driver.findElement(SO_number_click);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
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
