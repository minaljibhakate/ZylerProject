package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SampleOrderPage {

	public WebDriver driver;
	public SampleOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Sale link from header
	private By sale_link = By.xpath("//a[normalize-space()='Sale']");
		
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Enquiry Menu
	private By sampleOrder_menu = By.xpath("//div[@class='page-wrapper']//li[14]//a[1]");
	
	//Create Sample Order
	private By create_sample_oder = By.xpath("//a[normalize-space()='Create New Sample order']");
	
	private By client_dropdown = By.xpath("//button[@data-id='clientid']");
	
	private By client_search = By.xpath("(//input[@aria-label='Search'])[1]");
	
	private By client_list = By.xpath("//div[@aria-expanded='true']//ul[@class='dropdown-menu inner show']//li");
	
//	private By abcded = By.xpath("");
//	
//	private By abcded = By.xpath("");
	
	
	
	
	public WebElement getSale()
	{
		return driver.findElement(sale_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getSampleOrderMenuClick()
	{
		return driver.findElement(sampleOrder_menu);
	}
	public WebElement getCreateNewSampleOrderClick()
	{
		return driver.findElement(create_sample_oder);
	}
	
	public WebElement getClientDropdown()
	{
		return driver.findElement(client_dropdown);
	}
	public WebElement getClientDropdownSearch()
	{
		return driver.findElement(client_search);
	}
	public List<WebElement> getClientSuggestion()
	{
		return driver.findElements(client_list);
	}
	
}
