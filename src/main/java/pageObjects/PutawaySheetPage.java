package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PutawaySheetPage {
	
	public WebDriver driver;
	public PutawaySheetPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//WMS link
	private By wms_link = By.xpath("//a[normalize-space()='WMS']");
	
	//Hamburger Menu
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//Put Away Menu link
	private By putAwaySheet_link = By.xpath("//div[@id='client-sidebar']//li[1]//a[1]");
	
	//product list
	private By product_list = By.xpath("//tr//td[2]");
	
	public WebElement getWms()
	{
		return driver.findElement(wms_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getPutAwayMenuClick()
	{
		return driver.findElement(putAwaySheet_link);
	}
	public List<WebElement> getProductList()
	{
		return driver.findElements(product_list);
	}
}
