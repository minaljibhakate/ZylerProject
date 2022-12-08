package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CancelRejectPOPage {
	public WebDriver driver;
	
	public CancelRejectPOPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	//Hamburger Icon click
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	
	//More button	
	private By more_button = By.xpath("(//button[@type='button'])[9]");
	
	//Mark As reject
	private By markAsReject_button = By.xpath("//a[normalize-space()='Mark as Rejected']");
	
	//Mark As Cancel
	private By markAsCancel_button = By.xpath("//a[normalize-space()='Mark as Cancelled']");
	
	//Success Message
	private By success_message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	//Cancelled SO Menu
	private By cancelReject_PO_menu = By.xpath("(//a[normalize-space()='Cancel/Reject PO'])[1]");
	
	//preview close button
	private By previewClose_button = By.xpath("(//button[@class='close-arrow'])[1]");
	
	//Status
	//private By cancel_status = By.xpath("//span[@class='dtr-data']//span[@class='label label-warning Cancelled s-status']");
	private By cancel_status = By.xpath("//tbody//tr[1]//td[12]//span");
	//private By cancel_status = By.xpath("//tbody//tr[2]//td//li[1]//span[2]");
	//private By cancel_status = By.xpath("//tbody/tr[1]/td[12]/span[1]");
	
	
	//Reject Status
	//private By reject_status = By.xpath("//span[@class='dtr-data']//span[@class='label label-warning Rejected s-status'][normalize-space()='Rejected']");
	//private By reject_status = By.xpath("//tbody//tr[2]//td//li[1]//span[2]");
	private By reject_status = By.xpath("//tbody//tr[1]//td[12]//span");
	//	private By reject_status = By.xpath("//tbody/tr[1]/td[12]/span[1]");
	
	//+ icon click
	private By plusIcon_button = By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)");

	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	
	
	public WebElement getMoreButton()
	{
		return driver.findElement(more_button);
	}
	public WebElement getMarkAsReject()
	{
		return driver.findElement(markAsReject_button);
	}
	public WebElement getMarkAsCancel()
	{
		return driver.findElement(markAsCancel_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_message);
	}
	public WebElement getCancelRejectPOMenu()
	{
		return driver.findElement(cancelReject_PO_menu);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(previewClose_button);
	}
	public WebElement getPlusIconButton()
	{
		return driver.findElement(plusIcon_button);
	}
	public WebElement getCancelStatus()
	{
		return driver.findElement(cancel_status);
	}
	public WebElement getRejectStatus()
	{
		return driver.findElement(reject_status);
	}
}
