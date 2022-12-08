package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPayablePage {

	public WebDriver driver;
	public AccountPayablePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	
	//Hamburger Icon click
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Account Payable from Menu
	private By accountPayable_link = By.xpath("(//a[normalize-space()='Accounts Payable'])[1]");
	
	//PO order number click from Received PO column on Account Payable Page
	private By PO_link = By.xpath("//a[@title='JOINVPO-0922000225 ']");
	
	//Push to inventory Tick Mark click
	private By push_to_inventory_tick_mark = By.xpath("//i[@id='inventory_add_res']");
	
	//Quantity Field
	private By quantity_txt = By.xpath("//input[@id='locquantity']");

	//location field
	private By location_txt = By.xpath("//input[@id='locitemlocation']");

	//Type
	private By loc_type_dropdown = By.xpath("//select[@id='loctype']");
	
	//Add button
	private By add_btn = By.xpath("//button[normalize-space()='Add']");
	
	//Save button
	private By save_button = By.xpath("//button[@id='inventory_saves']");

	//Success Message
	private By success_msg = By.xpath("//div[@class='alert alert-success']");

	//Activity Log Click
	private By activity_log = By.xpath("//a[normalize-space()='Activity Log']");
	
	//Activity Log Message text for Push to inventory
	private By message_txt = By.xpath("//body/div[@class='page-wrapper']/div[@class='container-fluid']/div[@id='aa']/div[@id='purchase']/div[@role='document']/div[@class='modal-content p-3']/div[@class='preview-template']/div[@class='tab-content']/div[@id='tab_activity']/div[@id='accounts-payable-activity-log-data']/div[@id='tab_activity']/div[@class='row']/div[@class='col-md-12']/div[@class='activity-feed']/div[1]/div[1]");

	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getAccountPayableClick()
	{
		return driver.findElement(accountPayable_link);
	}
	public WebElement getPOCLick()
	{
		return driver.findElement(PO_link);
	}
	public WebElement getPushToInventoryTickMarkClick()
	{
		return driver.findElement(push_to_inventory_tick_mark);
	}
	public WebElement getQuantity()
	{
		return driver.findElement(quantity_txt);
	}
	public WebElement getLocation()
	{
		return driver.findElement(location_txt);
	}
	public WebElement getLocTypeDropdown()
	{
		return driver.findElement(loc_type_dropdown);
	}
	public WebElement getAddButton()
	{
		return driver.findElement(add_btn);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getActivityLog()
	{
		return driver.findElement(activity_log);
	}
	public WebElement getMessagetext()
	{
		return driver.findElement(message_txt);
	}
}
