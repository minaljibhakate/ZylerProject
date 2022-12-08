package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesPriceEstimatePage {

	public WebDriver driver;
	public SalesPriceEstimatePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Sale link from header
	private By sale_link = By.xpath("//a[normalize-space()='Sale']");
	
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Enquiry Menu
	private By sales_price_estimate_menu = By.xpath("(//a[normalize-space()='Sales Price Estimate'])[1]");
	
	//add product
	private By add_product_btn = By.xpath("//span[@id='manage_target']");

	// product name
	private By product_name = By.xpath("//input[@id='product']");

	// product name
	private By current_market_price = By.xpath("//input[@id='saleprice']");

	//Date Field
	private By date = By.xpath("//input[@id='estimatedate']");
	//private By date_calender_next_btn = By.xpath("(//button[@type='button'])[23]");
	private By date_dateSelect = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[1]");
		
	// product name
	private By save_button = By.xpath("//button[@id='btnSubmit']");
	
	// Search
	private By search = By.xpath("//input[@type='search']");
	
	// Edit button
	private By edit_button = By.xpath("//i[@title='Edit']");
	
	// 
	//private By sbc = By.xpath("");
	

	// Delete button
	private By delete_button = By.xpath("//td[5]//i[@title='Delete']");
	
	
	// Delete Confirmation pop up -> OK Button
	private By ok_button = By.xpath("//button[normalize-space()='OK']");
	
	public WebElement getSale()
	{
		return driver.findElement(sale_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getSalesPriceEstimateMenuClick()
	{
		return driver.findElement(sales_price_estimate_menu);
	}
	public WebElement getAddProductClick()
	{
		return driver.findElement(add_product_btn);
	}
	public WebElement getProductName()
	{
		return driver.findElement(product_name);
	}
	public WebElement getCurrentMarketPrice()
	{
		return driver.findElement(current_market_price);
	}
	public WebElement getDate()
	{
		return driver.findElement(date);
	}
	public WebElement getDateSelect()
	{
		return driver.findElement(date_dateSelect);
	}
	public WebElement getSave()
	{
		return driver.findElement(save_button);
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement getEdit()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getDelete()
	{
		return driver.findElement(delete_button);
	}
	public WebElement getOkButton()
	{
		return driver.findElement(ok_button);
	}
}
