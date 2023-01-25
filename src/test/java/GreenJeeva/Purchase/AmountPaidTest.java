package GreenJeeva.Purchase;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;
import pageObjects.Purchase.AmountPaidPage;
import utils.ExcelUtils;
import utils.FileDownloadVerification;

public	 class AmountPaidTest extends base {

	WebDriver driver;
	AmountPaidPage app;
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


	@Test(priority = 1)
	public void print_amount_paid() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Print Amount Paid------");
		app = new AmountPaidPage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAmountPaidMenu().click();
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getPrint().click();

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

	@Test(priority = 2)
	public void download_pdf_amount_paid() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Download PDF for Amount Paid------");
		app = new AmountPaidPage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAmountPaidMenu().click();
		System.out.println("table id :"+ app.getTableIDClick().getText());
		String fileName = "PAYMENT-"+ app.getTableIDClick().getText();
		System.out.println("fileName: "+ fileName);
		app.getTableIDClick().click();
		driver.switchTo().activeElement();
		app.getDownloadPdf().click();
		//Assert.assertTrue(isFileDownloaded("PAYMENT-201", "pdf", 5000));
		Assert.assertTrue(FileDownloadVerification.isFileDownloaded(fileName, "pdf", 5000));
	}
	@Test(priority = 3)
	public void edit_amount_paid() throws InterruptedException, IOException 
	{
		excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPPurchase.xlsx", "AccountPayable");	

		System.out.println("------Started Executing Edit Amount Paid------");
		app = new AmountPaidPage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAmountPaidMenu().click();
		app.getTableIDClick().click();

		Thread.sleep(2000);
		app.getAmount().clear();
		app.getAmount().sendKeys("50000");
		app.getSaveButton().click();

		String sucess_message = app.getDeleteSuccessMessage().getText();
		String expected_success_message = "Payment updated Successfully";
		Assert.assertTrue(sucess_message.contains(expected_success_message));
		System.out.println("Message  : "+sucess_message.replace("×", ""));

	}
	@Test(priority = 4)
	public void delete_amount_paid() throws IOException,InterruptedException
	{
		System.out.println("------Started Executing Delete Amount Paid------");

		app = new AmountPaidPage(driver);

		app.getPurchase().click();
		app.getHamburgerMenuClick().click();
		app.getAmountPaidMenu().click();
		app.getTableIDClick().click();
		//driver.switchTo().activeElement();

		app.getDelete().click();

		driver.switchTo().alert().accept();

		String sucess_message = app.getDeleteSuccessMessage().getText();
		String expected_success_message = "Payment deleted Successfully";
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
