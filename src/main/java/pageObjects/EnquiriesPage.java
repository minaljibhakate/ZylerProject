package pageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnquiriesPage {
	
	public WebDriver driver;
	public EnquiriesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	// Sale link from header
	private By sale_link = By.xpath("//a[normalize-space()='Sale']");
	
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Enquiry Menu
	private By enquiries_menu = By.xpath("//div[@id='client-sidebar']//li[3]//a[1]");
	public By create_new_enquiry_btn = By.xpath("//a[normalize-space()='Create New Enquiry']");
	
	//Customer
	private By customer_dropdown = By.xpath("//button[@data-id='clientid']");
	private By customer_dropdown_search = By.xpath("//div[contains(@class,'show')]//input[@aria-label='Search']");
	private By customer_dropdown_suggestion = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//Item
	private By add_item_dropdown = By.xpath("//button[@data-id='item_select_enquiry']");//*[@data-id="item_select_enquiry"]
	private By add_item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[3]");
	private By add_item_dropdown_suggestions = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//country
	private By country_dropdown = By.xpath("//div[contains(text(),'Select country')]");
	//private By country_dropdown_search = By.xpath("//div[contains(@x-placement,'bottom-start')]//input[contains(@aria-label,'Search')]");//input[@aria-invalid='false']
	private By country_dropdown_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");
	
	//Quantity field
	private By qty_txt_field = By.xpath("//input[@id='enq_quantity']");
	
	//Lead time field
	private By lead_time_field = By.xpath("//input[@id='lead_time']");
	
	//Date Field
	private By due_date = By.xpath("//input[@id='due_date']");
	private By due_date_calender_next_btn = By.xpath("(//button[@type='button'])[23]");
	private By edit_due_date_calender_next_btn = By.xpath("(//button[@type='button'])[27]");
	private By due_date_dateSelect = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[2]");
	
	//Target Price 
	private By target_price = By.xpath("//input[@name='target_price']");
	
	//Save button
	private By save_button =By.xpath("//button[@class='btn-tr btn btn-primary float-right enquiry_submit']");
	
	//Add Line Item
	private By add_line_item_click = By.xpath("//i[@class='fas fa-plus-circle']");
	
	//Success Message
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	//Enquiry ID
	private By enquiry_id = By.xpath("//div[@class='col-md-6']//a[contains(text(),'JOENQ')]");
	
	//Product Name
	private By product_name = By.xpath("(//a[@data-toggle='tooltip'])[4]");
	
	//close button
	//private By close_btn = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");
	private By close_btn = By.xpath("(//button[@class='close-arrow'])[1]");
		
	//priority
	private By priority_dropdown = By.xpath("//span[normalize-space()='Priority']");
	private By priority_list = By.xpath("//ul[@class='dropdown-menu show']//li");
	private By priority_column_high_list = By.xpath("//table[@id='table-enquiries']//span[@class='priority High']");
	private By priority_column_normal_list = By.xpath("//table[@id='table-enquiries']//span[@class='priority Normal']");
	
	//Status
	//private By status_dropdown = By.xpath("//button[@title='New']");
	private By status_dropdown = By.xpath("//span[normalize-space()='Status']");
	private By status_list = By.xpath("//ul[@class='dropdown-menu show']//li");
	private By status_column_list = By.xpath("//table[@id='table-enquiries']//span[@class='status New']");	
	
	//Sales Agent
	private By salesAgent_dropdown = By.xpath("(//button[@type='button'])[4]");
	private By salesAgent_list = By.xpath("//div[@class='simplebar-content']//li[@class='cursor']");
	private By salesAgent_column_list = By.xpath("//table[@id='table-enquiries']//td[@title='Minal Jibhakate']");	
	
	//Search
	private By search = By.xpath("//input[@type='search']");
	
	//Enquiry id from Table
	private By enquiry_id_from_table = By.xpath("//tbody//tr//td[1]");
	
	//edit enquiry button
	//private By edit_enquiry_btn = By.xpath("//a[@data-original-title='Edit Enquiry ']");
	private By edit_enquiry_btn = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");
	
	//comments
	private By comments = By.xpath("//textarea[@id='enq_comment']");
	
	//edit save button
	private By editSave_btn = By.xpath("(//button[@type='submit'])[1]");
	
	//More button
	private By more_btn = By.xpath("(//button[@type='button'])[9]");
			
	//Delete BUtton
	private By delete_btn = By.xpath("//a[normalize-space()='Delete Enquiry']");
	
	public WebElement getSale()
	{
		return driver.findElement(sale_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getEnquiryMenuClick()
	{
		return driver.findElement(enquiries_menu);
	}
	public WebElement getCreateNewEnquiryClick()
	{
		return driver.findElement(create_new_enquiry_btn);
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
	public WebElement getLeadTime()
	{
		return driver.findElement(lead_time_field);
	}
	public WebElement getDueDate()
	{
		return driver.findElement(due_date);
	}
	public WebElement getDueDateNextButton()
	{
		return driver.findElement(due_date_calender_next_btn);
	}
	public WebElement getEditDueDateNextButton()
	{
		return driver.findElement(edit_due_date_calender_next_btn);
	}
	public WebElement getDueDateSelect()
	{
		return driver.findElement(due_date_dateSelect);
	}
	public WebElement getTargetPrice()
	{
		return driver.findElement(target_price);
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
	public WebElement getEnquiryId()
	{
		return driver.findElement(enquiry_id);
	}
	public WebElement getProductName()
	{
		return driver.findElement(product_name);
	}
	
	public WebElement getCloseButton()
	{
		return driver.findElement(close_btn);
	}
	
	public WebElement getPriorityDropdown()
	{
		return driver.findElement(priority_dropdown);
	}
	public List<WebElement> getPriorityList()
	{
		return driver.findElements(priority_list);
	}
	public List<WebElement> getPriorityColumnHighList()
	{
		return driver.findElements(priority_column_high_list);
	}
	public List<WebElement> getPriorityColumnNormalList()
	{
		return driver.findElements(priority_column_normal_list);
	}
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
	//Sales Agent
	public WebElement getsalesAgentDropdown()
	{
		return driver.findElement(salesAgent_dropdown);
	}
	public List<WebElement> getsalesAgentList()
	{
		return driver.findElements(salesAgent_list);
	}
	public List<WebElement> getsalesAgentColumnList()
	{
		return driver.findElements(salesAgent_column_list);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getEnquiryIDTable()
	{
		return driver.findElement(enquiry_id_from_table);
	}
	public WebElement getEditEnquiryButton()
	{
		return driver.findElement(edit_enquiry_btn);
	}
	public WebElement getComments()
	{
		return driver.findElement(comments);
	}
	public WebElement getCountryDropdown()
	{
		return driver.findElement(country_dropdown);
	}
	
	public List<WebElement> getCountryDropdownlist()
	{
		return driver.findElements(country_dropdown_list);
	}
	public WebElement getEditSaveButton()
	{
		return driver.findElement(editSave_btn);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_btn);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_btn);
	}
	
}

