package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToBeSourcedPage {

	public WebDriver driver;
	public ToBeSourcedPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");
	private By toBeSorced_link = By.xpath("//div[@id='client-sidebar']//li[5]//a[1]");
	private By toBeSourcedProduct = By.xpath("(//a[contains(@onclick,'init_enquiry_items')])[1]");
	private By sourcingStaff_dropdown = By.xpath("(//select[@name='sourcing_staff'])[1]");
	private By assign_btn = By.xpath("//a[normalize-space()='Assigned']");
	private By sourcingFailure_dropdown = By.xpath("(//select[@name='src_failure'])[1]");
	private By priority_dropdown = By.xpath("(//button[@type='button'])[4]");
	private By priority_list = By.xpath("//ul[@class='dropdown-menu show']//li");
	private By priority_column_high_list = By.xpath("//table[@id='table-required_sourcing']//span[@class='priority High']");
	private By reset_btn = By.xpath("//a[normalize-space()='Reset']");            //a[contains(text(),'Reset')]
	private By priority_column_normal_list = By.xpath("//table[@id='table-required_sourcing']//span[@class='priority Normal']");
	private By sourcingPerson_dropdown = By.xpath("(//button[@type='button'])[5]");
	private By sourcingPerson_list = By.xpath("//ul[@class='dropdown-menu show']//li[@class='cursor']");
	private By sourcingStaff_column_list = By.xpath("//select[@name='sourcing_staff']");
	private By dateRange_btn = By.xpath("(//button[@type='button'])[3]");
	private By fromInput = By.xpath("//input[@id='from_date']");
	private By fromDate = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[1]");
	private By yes_button = By.xpath("//button[normalize-space()='Yes']");
	
//	private By tillDate = By.xpath("//select[@name='sourcing_staff']");
//	private By ddd = By.xpath("//select[@name='sourcing_staff']");
	
	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getToBeSourcedClick()
	{
		return driver.findElement(toBeSorced_link);
	}
	public WebElement getToBeSourcedProduct()
	{
		return driver.findElement(toBeSourcedProduct);
	}
	public WebElement getSourcingStaffDropdown()
	{
		return driver.findElement(sourcingStaff_dropdown);
	}
	public WebElement getAssignedButtonClick()
	{
		return driver.findElement(assign_btn);
	}
	public WebElement getSourcingFailureDropdown()
	{
		return driver.findElement(sourcingFailure_dropdown);
	}
	public WebElement getPriorityDropdown()
	{
		return driver.findElement(priority_dropdown);
	}
	public List<WebElement> getPriorityList()
	{
		return driver.findElements(priority_list);
	}
	public List<WebElement> getPriorityColumnHighList()
	{
		return driver.findElements(priority_column_high_list);
	}
	public WebElement getResetButtonClick()
	{
		return driver.findElement(reset_btn);
	}
	public List<WebElement> getPriorityColumnNormalList()
	{
		return driver.findElements(priority_column_normal_list);
	}
	public WebElement getSourcingPersonDropdown()
	{
		return driver.findElement(sourcingPerson_dropdown);
	}
	public List<WebElement> getSourcingPersonList()
	{
		return driver.findElements(sourcingPerson_list);
	}
	public List<WebElement> getSourcingStaffColumnList()
	{
		return driver.findElements(sourcingStaff_column_list);
	}
	
	public WebElement getDateRangeClick()
	{
		return driver.findElement(dateRange_btn);
	}
	public WebElement getFrominputClick()
	{
		return driver.findElement(fromInput);
	}
	public WebElement getFromDateClick()
	{
		return driver.findElement(fromDate);
	}
	public WebElement getYesButton()
	{
		return driver.findElement(yes_button);
	}
}

