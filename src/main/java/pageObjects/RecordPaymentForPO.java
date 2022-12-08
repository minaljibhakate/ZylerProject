package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecordPaymentForPO {

	public WebDriver driver;
	
	public RecordPaymentForPO(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Record Payment
	private By record_payment_btn = By.xpath("//a[normalize-space()='Record Payment']");

	//amount
	private By amount_txt = By.xpath("//input[@name='newitems[1][total]']");

	//bank account
	private By bankAccount_dropdown = By.xpath("//select[@id='bankaccount_code']"); 										

	//Cr Amount
	private By crAmount_txt = By.xpath("(//input[@id='cr_amount'])[2]");

	//Success Message
	private By journal_Desc	 = By.xpath("//input[@id='journal_desc']");
		
	//Save button
	private By save_btn = By.xpath("(//button[@type='submit'])[2]");

	//Success Message
	private By success_message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	//Voucher Generation Text
	private By voucher_generation_text = By.xpath("//p[@class='lead text-muted ']");
	
	//OK button
	private By ok_button = By.xpath("//button[normalize-space()='OK']");
	
	
	public WebElement getRecordPayment()
	{
		return driver.findElement(record_payment_btn);
	}
	public WebElement getAmount()
	{
		return driver.findElement(amount_txt);
	}
	public WebElement getJournal_desc()
	{
		return driver.findElement(journal_Desc);
	}
	public WebElement getBankAccountDropdown()
	{
		return driver.findElement(bankAccount_dropdown);
	}
	public WebElement getCrAmount()
	{
		return driver.findElement(crAmount_txt);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_btn);
	}
	public WebElement getSuccess_message()
	{
		return driver.findElement(success_message);
	}
	
	public WebElement getVoucherGenerationText()
	{
		return driver.findElement(voucher_generation_text);
	}
	
	public WebElement getOKButton()
	{
		return driver.findElement(ok_button);
	}
}
