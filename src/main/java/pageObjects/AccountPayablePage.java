package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPayablePage {

	public WebDriver driver;
	public AccountPayablePage(WebDriver driver)
	{
		this.driver=driver;
	}

	// Sale link from header
	private By purchase_link = By.xpath("//a[normalize-space()='Purchase']");

	//Hamburger Icon click
	private By hamburgermenu_button = By.xpath("//span[@class='material-icons left']");

	//Account Payable from Menu
	private By accountPayable_link = By.xpath("(//a[normalize-space()='Accounts Payable'])[1]");

	//PO order number click from Received PO column on Account Payable Page
	private By PO_link = By.xpath("//a[@title='JOINVPO-0922000225 ']");

	//Push to inventory Tick Mark click
	private By push_to_inventory_tick_mark = By.xpath("//i[@id='inventory_add_res']");

	//Quantity Field
	private By quantity_txt = By.xpath("//input[@id='locquantity']");

	//location field
	private By location_txt = By.xpath("//input[@id='locitemlocation']");

	//Type
	private By loc_type_dropdown = By.xpath("//select[@id='loctype']");

	//Add button
	private By add_btn = By.xpath("//button[normalize-space()='Add']");

	//Save button
	private By save_button = By.xpath("//button[@id='inventory_saves']");

	//Success Message
	private By success_msg = By.xpath("//div[@class='alert alert-success']");

	//Activity Log Click
	private By activity_log = By.xpath("//a[normalize-space()='Activity Log']");

	//Activity Log Message text for Push to inventory
	private By message_txt = By.xpath("//body/div[@class='page-wrapper']/div[@class='container-fluid']/div[@id='aa']/div[@id='purchase']/div[@role='document']/div[@class='modal-content p-3']/div[@class='preview-template']/div[@class='tab-content']/div[@id='tab_activity']/div[@id='accounts-payable-activity-log-data']/div[@id='tab_activity']/div[@class='row']/div[@class='col-md-12']/div[@class='activity-feed']/div[1]/div[1]");

	//Table Id click
	private By table_id_click = By.xpath("//table[@id='table-popurchases']//tr[1]//td[1]//a");

	//Edit button
	private By edit_button = By.xpath("(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[1]");

	//Save button
	private By save_btn = By.xpath("//button[@type='submit']");

	//Pack Size
	private By pack_size = By.xpath("//input[@id='pack']");

	//warehouse
	private By warehouse = By.xpath("(//button[@type='button'])[17]");

	//warehouse List
	private By warehouse_list = By.xpath("//ul[@class='dropdown-menu inner show']//li");

	//PO Purchase qty
	private By po_purchase_qty = By.xpath("//input[@id='popurchase_qty']");

	//Preview Close button
	private By preview_close_button = By.xpath("//div[@class='modal-content p-3']//i[@class='material-icons'][normalize-space()='navigate_next']");

	//Print
	private By print = By.xpath("//i[normalize-space()='print']");

	//download PDF
	private By download_pdf = By.xpath("//i[@class='fa fa-file-pdf-o']");//(//a[@class='btn btn-default btn-with-tooltip float-left mr-2'])[3]

	//attach a file
	private By attach_file = By.xpath("//a[normalize-space()='Attach File']");

	//More button
	private By more_btn = By.xpath("(//button[@class='btn btn-default btn-sm float-left mr-2 dropdown-toggle'])[1]");

	//sales upload
	private By sales_upload = By.xpath("//form[@id='sales-upload']");

	//sales upload close
	private By sales_upload_close = By.xpath("(//i[@class='material-icons'][normalize-space()='navigate_next'])[2]");

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

	//PO level Attachment
	private By po_level_attachment = By.xpath("//a[normalize-space()='Po level']");

	//PO level Attachment
	private By po_upload = By.xpath("//form[@id='po-upload']");

	//PO Upload close button
	private By po_upload_close_button = By.xpath("//button[@aria-label='Close']//span[@aria-hidden='true'][normalize-space()='×']");

	public WebElement getPurchase()
	{
		return driver.findElement(purchase_link);
	}
	public WebElement getHamburgerMenuClick()
	{
		return driver.findElement(hamburgermenu_button);
	}
	public WebElement getAccountPayableClick()
	{
		return driver.findElement(accountPayable_link);
	}
	public WebElement getPOCLick()
	{
		return driver.findElement(PO_link);
	}
	public WebElement getPushToInventoryTickMarkClick()
	{
		return driver.findElement(push_to_inventory_tick_mark);
	}
	public WebElement getQuantity()
	{
		return driver.findElement(quantity_txt);
	}
	public WebElement getLocation()
	{
		return driver.findElement(location_txt);
	}
	public WebElement getLocTypeDropdown()
	{
		return driver.findElement(loc_type_dropdown);
	}
	public WebElement getAddButton()
	{
		return driver.findElement(add_btn);
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(save_button);
	}
	public WebElement getSuccessMessage()
	{
		return driver.findElement(success_msg);
	}
	public WebElement getActivityLog()
	{
		return driver.findElement(activity_log);
	}
	public WebElement getMessagetext()
	{
		return driver.findElement(message_txt);
	}
	public WebElement getTableIDClick()
	{
		return driver.findElement(table_id_click);
	}
	public WebElement getEditButton()
	{
		return driver.findElement(edit_button);
	}
	public WebElement getSaveAccountPayable()
	{
		return driver.findElement(save_btn);
	}
	public WebElement getPackSize()
	{
		return driver.findElement(pack_size);
	}
	public WebElement getWarehouse()
	{
		return driver.findElement(warehouse);
	}
	public List<WebElement> getWarehouseList()
	{
		return driver.findElements(warehouse_list);
	}
	public WebElement getPOPurchaseQty()
	{
		return driver.findElement(po_purchase_qty);
	}
	public WebElement getPreviewCloseButton()
	{
		return driver.findElement(preview_close_button);
	}
	public WebElement getPrint()
	{
		return driver.findElement(print);
	}
	public WebElement getDownloadPdf()
	{
		return driver.findElement(download_pdf);
	}
	public WebElement getMoreButton()
	{
		return driver.findElement(more_btn);
	}
	public WebElement getAttachFile()
	{
		return driver.findElement(attach_file);
	}
	public WebElement getSalesUpload()
	{
		return driver.findElement(sales_upload);
	}
	public WebElement getSalesUploadClose()
	{
		return driver.findElement(sales_upload_close);
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
	public WebElement getPOLevelAttachment()
	{
		return driver.findElement(po_level_attachment);
	}
	public WebElement getPOUpload()
	{
		return driver.findElement(po_upload);
	}
	public WebElement getPOUploadCloseButton()
	{
		return driver.findElement(po_upload_close_button);
	}
}
