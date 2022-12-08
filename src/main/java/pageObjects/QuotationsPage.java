package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuotationsPage {

	public WebDriver driver;

	public QuotationsPage(WebDriver driver)
	{
		this.driver=driver;
	}	
	private By sale_link = By.xpath("//a[normalize-space()='Sale']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By QuotationMenu_link = By.xpath("//a[contains(text(), 'Quotations')]");
	private By convertToQuotation_btn = By.xpath("//a[contains(text(), 'Convert to quotation')]");
	private By submit_btn = By.xpath("//button[@type='submit']");
	private By quotation_number_text = By.xpath("//div[@class='col-md-6']//a[contains(text(),'JOQT')]");
	private By info_popup_close_btn = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By enquiry_id = By.xpath("(//a[contains(text(),'JOSO')])[26]");
	private By convertToSalesOrder_btn = By.xpath("//a[contains(text(),'Convert To Sales Order')]");
	private By printable_text_field = By.xpath("//textarea[@name='items[1][printable_description]']");
	private By rate_text_field = By.xpath("//input[@id='rate']");
	private By product_description = By.xpath("(//textarea[@name='items[1][long_description]'])");
	private By save_btn = By.xpath("//button[@id='qoToso']");

	//Status
	private By salesRep_dropdown = By.xpath("//button[@type='button']//span[normalize-space()='Sales Agent']");
	private By salesRep_list = By.xpath("//ul[@class='dropdown-menu show']//li");
	private By salesRep_column_list = By.xpath("//table[@id='table-quotations']//td[@title='Minal Jibhakate']");	

	//preview close button
	private By preview_close_btn = By.xpath("(//button[@type='button'])[8]");

	//quotation ID click		
	private By quotationID_click = By.xpath("//tbody//tr[1]//td[1]//a");

	//Edit button click
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");
	
	//Item
	private By add_item_dropdown = By.xpath("(//button[@type='button'])[5]");
	private By add_item_dropdown_search = By.xpath("(//input[@aria-label='Search'])[3]");
	private By add_item_dropdown_suggestions = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
	//Quantity field
	private By qty_field = By.xpath("//input[@name='quantity']");
	
	//Lead time field
	private By lead_time_field = By.xpath("//input[@name='lead_time']");
	
	//Unit Price 
	private By unit_price = By.xpath("//input[@name='rate']");
	
	//Add Line Item
	private By add_line_item_click = By.xpath("//i[@class='fas fa-plus-circle']");
	
	//preview close button
	private By preview_close_btn2 = By.xpath("(//button[@type='button'])[7]");
	
	//preview close button
	private By more_button = By.xpath("(//button[@type='button'])[8]");
		
	//preview close button
	private By delete_button = By.xpath("//a[normalize-space()='Delete Quotation']");
	
	//Status
	//private By status_dropdown = By.xpath("//button[@title='New']");
	private By status_dropdown = By.xpath("//span[normalize-space()='Status']");//(//button[@type='button'])[4]
	private By status_list = By.xpath("//ul[@class='dropdown-menu show']//li");
	private By status_column_list = By.xpath("//tbody//tr//td[14]//span");	
	
	public WebElement getSale()
	{
		return driver.findElement(sale_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getQuotationMenuClick()
	{
		return driver.findElement(QuotationMenu_link);
	}
	public WebElement getConvertToQuotation()
	{
		return driver.findElement(convertToQuotation_btn);
	}
	public WebElement getSubmitButton()
	{
		return driver.findElement(submit_btn);
	}
	public WebElement getQuotationNumber()
	{
		return driver.findElement(quotation_number_text);
	}
	public WebElement getInfoPopupClose_btn()
	{
		return driver.findElement(info_popup_close_btn);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getEnquiryId()
	{
		return driver.findElement(enquiry_id);
	}
	public WebElement getConvertToSalesOrderButtonClick()
	{
		return driver.findElement(convertToSalesOrder_btn);
	}
	public WebElement getPrintableTxt()
	{
		return driver.findElement(printable_text_field);
	}
	public WebElement getProductDescription()
	{
		return driver.findElement(product_description);
	}
	public WebElement getRateTxt()
	{
		return driver.findElement(rate_text_field);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_btn);
	}

	//Sales Representative
	public WebElement getsalesRepDropdown()
	{
		return driver.findElement(salesRep_dropdown);
	}
	public List<WebElement> getsalesRepList()
	{
		return driver.findElements(salesRep_list);
	}
	public List<WebElement> getsalesRepColumnList()
	{
		return driver.findElements(salesRep_column_list);
	}

	//preview close button
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_btn);
	}

	//quotation ID click
	public WebElement getQuotationIDClick()
	{
		return driver.findElement(quotationID_click);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
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
		return driver.findElement(qty_field);
	}
	public WebElement getLeadTime()
	{
		return driver.findElement(lead_time_field);
	}
	public WebElement getTargetPrice()
	{
		return driver.findElement(unit_price);
	}
	public WebElement getAddLineItemClick()
	{
		return driver.findElement(add_line_item_click);
	}
	public WebElement getPreviewCloseButton2()
	{
		return driver.findElement(preview_close_btn2);
	}
	
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
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
	
}
