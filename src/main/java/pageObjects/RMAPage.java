package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RMAPage {

	public WebDriver driver;
	public RMAPage(WebDriver driver)
	{
		this.driver=driver;
	}

	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");

	//Hamburger Icon click
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");

	//Account Payable from Menu
	private By RMA_menu_link = By.xpath("(//a[normalize-space()='RMA'])[1]");

	// Document tab click
	private By document_tab = By.xpath("//a[@id='tab_related_docs_tab']");

	// Send Attachment 
	private By send_attachment = By.xpath("//input[@class='upload_coa_file']");

	// Upload Button
	private By upload_button = By.xpath("(//i[@class='fa fa-upload cursor'])[1]");

	// more button
	private By more_button_so = By.xpath("(//button[@type='button'])[9]");

	// Convert to invoice
	private By convertToInvoice = By.xpath("//a[normalize-space()='Convert to Invoice']");

	// Save button
	private By save_button = By.xpath("//button[@id='submit_form']");

	// more button on AR page
	private By more_button_ar = By.xpath("(//button[@type='button'])[7]");

	// Return Replace Button
	private By return_replace_button = By.xpath("//a[normalize-space()='Return/Replace']");

	// Return Date field
	private By return_date_field = By.xpath("//input[@id='return_date']");

	// Return Date select
	private By return_date_select = By.xpath("(//td[contains(@class,'xdsoft_current')]//div)[1]");

	// PPO field
	private By po_txt_field = By.xpath("//input[@id='po']");

	// Save button on AR page
	private By save_button_AR = By.xpath("//button[@type='submit']");

	// Success Message
	private By success_message = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	// RMA number generated
	private By rma_number = By.xpath("//h4[@class='bold']//a[contains(text(),'GJRTN')]");

	// Preview Close button
	private By review_close_button = By.xpath("(//button[@type='button'])[4]");

	//term&conditions
	private By term_conditions = By.xpath("//textarea[@id='terms']");

	//Table Id click
	private By table_id_click = By.xpath("//table[@id='table-return_popurchase']//tr[1]//td[1]//a");

	//Edit button
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");

	//Save button
	//private By save_btn = By.xpath("//button[@type='submit']");

	//Print
	private By print = By.xpath("//i[normalize-space()='print']");

	//download PDF
	private By download_pdf = By.xpath("//i[@class='fa fa-file-pdf-o']");//(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[3]

	//Preview Close button
	private By preview_close = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");

	//Delete
	private By delete = By.xpath("//i[normalize-space()='delete']");

	//Delete success Message
	private By delete_success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getRMMenu()
	{
		return driver.findElement(RMA_menu_link);
	}
	public WebElement getDocumentTabClick()
	{
		return driver.findElement(document_tab);
	}
	public WebElement getSendAttachment()
	{
		return driver.findElement(send_attachment);
	}
	public WebElement getUploadButtonClick()
	{
		return driver.findElement(upload_button);
	}
	public WebElement getMoreButtonSO()
	{
		return driver.findElement(more_button_so);
	}
	public WebElement getConvertToInvoice()
	{
		return driver.findElement(convertToInvoice);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getMoreButtonAR()
	{
		return driver.findElement(more_button_ar);
	}
	public WebElement getReturnReplaceButtonClick()
	{
		return driver.findElement(return_replace_button);
	}
	public WebElement getReturnDate()
	{
		return driver.findElement(return_date_field);
	}
	public WebElement getReturnDateSelect()
	{
		return driver.findElement(return_date_select);
	}
	public WebElement getPOField()
	{
		return driver.findElement(po_txt_field);
	}
	public WebElement getSaveButtonAR()
	{
		return driver.findElement(save_button_AR);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_message);
	}
	public WebElement getRMANumber()
	{
		return driver.findElement(rma_number);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(review_close_button);
	}
	public WebElement getTermsConditions()
	{
		return driver.findElement(term_conditions);
	}
	public WebElement getTableIDClick()
	{
		return driver.findElement(table_id_click);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getSaveRMA()
	{
		return driver.findElement(save_button_AR);
	}
	public WebElement getPrint()
	{
		return driver.findElement(print);
	}
	public WebElement getDownloadPdf()
	{
		return driver.findElement(download_pdf);
	}
	public WebElement getPreviewClose()
	{
		return driver.findElement(preview_close);
	}
	public WebElement getDelete()
	{
		return driver.findElement(delete);
	}
	public WebElement getDeleteSuccessMessage()
	{
		return driver.findElement(delete_success_msg);
	}
}
