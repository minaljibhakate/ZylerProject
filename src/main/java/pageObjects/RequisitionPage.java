package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequisitionPage {

	public WebDriver driver;
	public RequisitionPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//Purchase link
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");

	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");

	//Inbound tracking menu
	//private By requisition_menu = By.xpath("(//a[normalize-space()='Requisition'])[2]");
	private By requisition_menu = By.xpath("(//a[@id='contact-tab'])[1]");

	//create New Requisition
	private By add_new_requisition = By.xpath("//a[normalize-space()='Create New Requisition']");

	//	product category
	private By product_category = By.xpath("//button[@data-id='category']");

	//	internal category
	private By internal_category_click = By.xpath("//span[normalize-space()='Internal']");

	//	INternal Item
	private By internal_item = By.xpath("//button[@data-id='internal_item']");

	//internal Item List
	private By internal_item_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");

	//	Quantity
	private By quantity = By.xpath("//input[@name='quantity']");

	//	Currency
	private By currency = By.xpath("//button[@data-id='currency']");

	//currency list
	private By currency_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");

	//	Rate
	private By rate = By.xpath("//input[@name='rate']");

	//	Add line item
	private By add_line_item = By.xpath("(//i[@class='fas fa-plus-circle'])[1]");

	//	Save button
	private By save_button = By.xpath("//button[@id='requisition_submit']");

	//	Edit button
	//private By edit_button = By.xpath("//a[@data-original-title='Edit']");
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");

	//	preview close button
	private By preview_close_button = By.xpath("(//i[@class='material-icons'][normalize-space()='navigate_next'])[1]");

	//	table first record click
	private By requisition_id_table = By.xpath("//tbody//tr[1]//td[1]//a");

	//	Reject button
	private By reject_button = By.xpath("//button[normalize-space()='Reject']");

	//	Remark
	private By remark = By.xpath("//textarea[@id='description']");
	//private By remark = By.xpath("//textarea[@id='note']");

	//	Yes button
	private By yes_button = By.xpath("//button[normalize-space()='Yes']");

	//	reject status //Table column 'Status'
	//private By reject_status = By.xpath("//span[@class='label label-danger q-statusRejected']"); // Preview Page Status 
	private By reject_status = By.xpath("//table//tr[1]//td[12]"); // Table column 'Status'

	//	More button
	private By more_button = By.xpath("(//button[@type='button'])[5]");

	//	Delete Button
	private By delete_button = By.xpath("//a[normalize-space()='Delete']");

	//Success message
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	//	search
	private By search = By.xpath("//input[@type='search']");

	//	Requisition ID
	private By requisition_ID = By.xpath("//div[@id='popurchase-preview']//div//a[contains(text(),'JORQ')]");

	//	Category Sorting
	private By categoty_sort = By.xpath("(//button[@type='button'])[3]");

	//	Internal category 
	private By categoty_internal = By.xpath("//a[normalize-space()='Internal']");

	//	Category Column list
	private By 	category_col_list = By.xpath("//table//td[3]//span");

	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getRequisitionMenuClick()
	{
		return driver.findElement(requisition_menu);
	}
	public WebElement getAddNewRequisitionClick()
	{
		return driver.findElement(add_new_requisition);
	}
	public WebElement getProductCategory()
	{
		return driver.findElement(product_category);
	}
	public WebElement getInternalCategory()
	{
		return driver.findElement(internal_category_click);
	}
	public WebElement getInternalItem()
	{
		return driver.findElement(internal_item);
	}
	public List<WebElement> getInternalItemList()
	{
		return driver.findElements(internal_item_list);
	}
	public WebElement getQuantity()
	{
		return driver.findElement(quantity);
	}
	public WebElement getCurrency()
	{
		return driver.findElement(currency);
	}
	public List<WebElement> getCurrencyList()
	{
		return driver.findElements(currency_list);
	}
	public WebElement getRate()
	{
		return driver.findElement(rate);
	}
	public WebElement getAddLineItem()
	{
		return driver.findElement(add_line_item);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	public WebElement getRequisitionIDtable()
	{
		return driver.findElement(requisition_id_table);
	}
	public WebElement getRejectButton()
	{
		return driver.findElement(reject_button);
	}
	public WebElement getRemark()
	{
		return driver.findElement(remark);
	}
	public WebElement getYesButton()
	{
		return driver.findElement(yes_button);
	}
	public WebElement getRejectStatus()
	{
		return driver.findElement(reject_status);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getDeleteButton()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getRequitionID()
	{
		return driver.findElement(requisition_ID);
	}

	public WebElement getCategorySorting()
	{
		return driver.findElement(categoty_sort);
	}
	public WebElement getCategoryInternal()
	{
		return driver.findElement(categoty_internal);
	}

	public List<WebElement> getCategoryColumnList()
	{
		return driver.findElements(category_col_list);
	}
}
