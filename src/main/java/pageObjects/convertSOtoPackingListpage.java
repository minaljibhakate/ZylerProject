package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class convertSOtoPackingListpage {

	public WebDriver driver;
	public convertSOtoPackingListpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//More button
	private By more_button = By.xpath("(//button[@type='button'])[9]");
	
	//Generate Packing List
	private By generate_pkl_button = By.xpath("//a[normalize-space()='Generate PKL']");
	
	//save button
	private By save_button = By.xpath("//button[@type='submit']");
	
	//Success Message
	private By success_message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	//Packing List Number
	private By packingList_number = By.xpath("(//a[contains(text(),'JOPKGL')])[26]");
	
	
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getGeneratePackingList()
	{
		return driver.findElement(generate_pkl_button);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_message);
	}
	public WebElement getPackingListNumber()
	{
		return driver.findElement(packingList_number);
	}
}
