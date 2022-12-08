package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	public WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By product_link = By.xpath("//a[@class='nav-link'][normalize-space()='Product']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By masterProduct_menu = By.xpath("//div[@class='page-wrapper']//li[5]//a[1]");
	private By newMasterProduct_btn = By.xpath("//a[normalize-space()='New Master Product']");
	/*
	 * private By product_name = By.xpath("//input[@id='name']");
	private By leadTime_dropdown = By.xpath("//button[@data-id='lead_time']");
	private By leadTime_dropdown_search = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
	private By leadTime_dropdown_suggestions = By.xpath("//div[@class='form-group no-margin']//li");//div[@class='form-group no-margin']//li[1]//a[1]
	private By sidi_type = By.xpath("//button[@data-id='type']");
	*/
	
	public WebElement getProduct()
	{
		return driver.findElement(product_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getMasterProductClick()
	{
		return driver.findElement(masterProduct_menu);
	}
	public WebElement getNewMasterProductClick()
	{
		return driver.findElement(newMasterProduct_btn);
	}
}
