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
	private By more_button = By.xpath("(//button[@class='btn btn-default btn-sm float-left mr-2 dropdown-toggle'])[1]");
	//private By more_button = By.xpath("(//button[@type='button'])[9]");

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

	//Table Id click
	private By table_id_click = By.xpath("//table[@id='table-purchases_status']//tr[1]//td[1]//a");

	//Delete
	private By delete = By.xpath("//a[normalize-space()='Delete purchase']");

	//Delete success Message
	private By delete_success_msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	//Note
	private By note = By.xpath("//a[normalize-space()='Notes']");

	//Note description
	private By note_description = By.xpath("//textarea[@id='description']");

	//Add Note button
	private By add_note_button = By.xpath("//button[normalize-space()='Add Note']");

	//Note verification
	private By note_verification = By.xpath("(//div[@class='text-ellipsis'])[1]");

	//Preview Close button
	private By preview_close_button = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");

	//Print
	private By print = By.xpath("//i[normalize-space()='print']");

	//download PDF
	private By download_pdf = By.xpath("//i[@class='fa fa-file-pdf-o']");

	//Unmark As Rejected
	private By unmark_as_rejected = By.xpath("//a[normalize-space()='Unmark as Rejected']");

	//Unmark As Cancelled
	private By unmark_as_cancelled = By.xpath("//a[normalize-space()='Unmark as Cancelled']");

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
		return driver.findElement(preview_close_button);
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
	public WebElement getTableIDClick()
	{
		return driver.findElement(table_id_click);
	}

	public WebElement getDelete()
	{
		return driver.findElement(delete);
	}
	public WebElement getDeleteSuccessMessage()
	{
		return driver.findElement(delete_success_msg);
	}
	public WebElement getNote()
	{
		return driver.findElement(note);
	}
	public WebElement getNoteDescription()
	{
		return driver.findElement(note_description);
	}
	public WebElement getAddNoteButton()
	{
		return driver.findElement(add_note_button);
	}
	public WebElement getNoteVerification()
	{
		return driver.findElement(note_verification);
	}
	public WebElement getPrint()
	{
		return driver.findElement(print);
	}
	public WebElement getDownloadPdf()
	{
		return driver.findElement(download_pdf);
	}
	public WebElement getUnmarkAsRejected()
	{
		return driver.findElement(unmark_as_rejected);
	}
	public WebElement getUnmarkAsCancelled()
	{
		return driver.findElement(unmark_as_cancelled);
	}
}

