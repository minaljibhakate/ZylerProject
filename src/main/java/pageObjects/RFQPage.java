package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RFQPage {
	public WebDriver driver;
	
	public RFQPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By rfq_menu = By.xpath("(//a[normalize-space()='RFQ'])[1]");
	private By create_new_rfq = By.xpath("//a[normalize-space()='Create New RFQ']");
	
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
	
	//success message
	private By success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	//preview close button
	private By preview_close_button = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");
	
	//edit button
	private By edit_button = By.xpath("//a[@class='btn btn-default btn-with-tooltip float-left mr-2']");
	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getRFQMenu()
	{
		return driver.findElement(rfq_menu);
	}
	public WebElement getCreateNewRFQ()
	{
		return driver.findElement(create_new_rfq);
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
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}

}
