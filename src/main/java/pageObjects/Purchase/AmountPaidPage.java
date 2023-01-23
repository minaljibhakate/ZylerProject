package pageObjects.Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmountPaidPage {
	public WebDriver driver;
	public AmountPaidPage(WebDriver driver)
	{
		this.driver=driver;
	}

	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");
	//Hamburger Icon click
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");

	//Account Payable from Menu
	private By amountPaid_menu = By.xpath("(//a[normalize-space()='Amount Paid'])[1]");

	//preview close button
	private By preview_close_button = By.xpath("(//button[@class='close-arrow'])[1]");

	//Table Id click
	private By table_id_click = By.xpath("//table[@id='table-payments']//tr[1]//td[1]//a");

	//Print
	private By print = By.xpath("//i[normalize-space()='print']");

	//download PDF
	private By download_pdf = By.xpath("//i[@class='fa fa-file-pdf-o']");

	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getAmountPaidMenu()
	{
		return driver.findElement(amountPaid_menu);
	}

	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	public WebElement getTableIDClick()
	{
		return driver.findElement(table_id_click);
	}
	public WebElement getPrint()
	{
		return driver.findElement(print);
	}
	public WebElement getDownloadPdf()
	{
		return driver.findElement(download_pdf);
	}
}
