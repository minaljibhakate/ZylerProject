package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.AccountPayablePage;
import pageObjects.RMAPage;
import utils.ExcelUtils;
import utils.FileDownloadVerification;

public class RMATest extends  base {

	WebDriver driver;
	String PO_invoice_number;
	RMAPage rma;
	String parent,  child_window;
	Set<String>s;
	Iterator<String> I1;
	ExcelUtils excel;

	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	
	@Test(enabled = false)
	public void edit_RMA() throws InterruptedException, IOException 
	{
		System.out.println("------Started Executing Edit RMA------");
		rma = new RMAPage(driver);

		rma.getPurchase().click();
		rma.getHamburgerMenuClick().click();
		rma.getRMMenu().click();
		rma.getTableIDClick().click();
		driver.switchTo().activeElement();
		rma.getEditButton().click();

		rma.getTermsConditions().sendKeys("Test Terms and Conditions");
		
		//rma.getSaveRMA().click();

//		Thread.sleep(1000);
//		driver.switchTo().activeElement();
//		rma.getActivityLog().click();
//		String expected_success_message ="Updated";
//		String activity_log = app.getMessagetext().getText();
//		Assert.assertTrue(activity_log.contains(expected_success_message));
//		System.out.println("Account Payable is updated successfully.");
//
//		Thread.sleep(2000);
//		rma.getPreviewCloseButton().click();
	}
	
	@Test
	public void print_RMA() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Print RMA------");
		rma = new RMAPage(driver);

		rma.getPurchase().click();
		rma.getHamburgerMenuClick().click();
		rma.getRMMenu().click();
		rma.getTableIDClick().click();
		driver.switchTo().activeElement();
		rma.getPrint().click();

		parent=driver.getWindowHandle();
		s=driver.getWindowHandles();
		I1= s.iterator();
		while(I1.hasNext())
		{
			child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
		String pageURL = driver.getCurrentUrl();
		System.out.println("pageURL : "+pageURL);

		Assert.assertTrue(pageURL.contains("print=true"));
		driver.switchTo().window(child_window).close();
		driver.switchTo().window(parent);
	}
	
	@Test
	public void download_pdf_account_Payable() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Download PDF for Account Payable------");
		rma = new RMAPage(driver);

		rma.getPurchase().click();
		rma.getHamburgerMenuClick().click();
		rma.getRMMenu().click();
		
		String fileName = rma.getTableIDClick().getText();
		
		rma.getTableIDClick().click();
		driver.switchTo().activeElement();
		rma.getDownloadPdf().click();

		rma.getPreviewClose().click();
		Assert.assertTrue(FileDownloadVerification.isFileDownloaded(fileName, "pdf", 5000));

	}
	@Test
	public void delete_RMA() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete RMA------");

		rma = new RMAPage(driver);

		rma.getPurchase().click();
		rma.getHamburgerMenuClick().click();
		rma.getRMMenu().click();
		rma.getTableIDClick().click();
		driver.switchTo().activeElement();
		rma.getDelete().click();

		driver.switchTo().alert().accept();

		String sucess_message = rma.getDeleteSuccessMessage().getText();
		String expected_success_message = "Purchase Return deleted Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));
	}


	@AfterTest
	public void driverClose() throws InterruptedException 	
	{
		Thread.sleep(3000);
		driver.close();
	}
}
