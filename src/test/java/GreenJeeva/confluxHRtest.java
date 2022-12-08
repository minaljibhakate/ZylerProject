package GreenJeeva;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestComponents.base;

public class confluxHRtest extends base {

WebDriver driver;
	
	@BeforeTest
	public void driverOpen()  throws IOException, AWTException
	{
		driver=initializeDriver();
		launchApp();
	}
	@Test
	public void confluxHR_test() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("//a[@id='menu_a_27']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Company Policies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Add Company Policies']")).click();
		Thread.sleep(2000);
		Select s = new Select(driver.findElement(By.xpath("//select[@id='policy_type']")));
		Thread.sleep(2000);
		s.selectByVisibleText("Policy on Equality");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//form[@id='companypolicies']//input[@id='policy_attachment']")).click();
		driver.findElement(By.xpath("//form[@id='companypolicies']//input[@id='policy_attachment']")).sendKeys("D:\\Zyler ERP Automation\\ZylerERP\\TestDataExcel\\Dummy_pdf_12kb.pdf");
		driver.findElement(By.xpath("(//textarea[@id='policy_description'])[1]")).sendKeys("test minal automation");
		driver.findElement(By.xpath("//button[@id='policy_submit']")).click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
	}
}
