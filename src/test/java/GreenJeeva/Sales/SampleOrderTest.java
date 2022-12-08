package GreenJeeva.Sales;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponents.base;
import pageObjects.SampleOrderPage;
import java.awt.AWTException;

public class SampleOrderTest extends  base {

	WebDriver driver;
	@BeforeTest
	public void driverOpen() throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}

	@Test(priority=1)
	public void add_New_Enquiry() throws IOException,InterruptedException, AWTException
	{

		System.out.println("------Started Executing Add New Sample Order------");
		//ExcelUtils excel = new ExcelUtils(dataExcelPath + "/TestDataExcel/ZylerERPTestDataExcel.xlsx", "SampleOrder");		
		SampleOrderPage sop = new SampleOrderPage(driver);
		sop.getSale().click();
		Thread.sleep(2000);

		sop.getHamburgerMenuClick().click();
		//Clicking on Enquiry option from Menu
		sop.getSampleOrderMenuClick().click();

		Thread.sleep(6000);

		sop.getCreateNewSampleOrderClick().click();

	}


	@AfterTest
	public void driverClose() 	
	{
		driver.close();
	}
}
