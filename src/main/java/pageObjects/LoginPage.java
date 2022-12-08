package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email = By.id("email");
	By password = By.id("password");
	By loginButton = By.cssSelector("[type='submit']");
	//public Object getEmailAddress;
	
	public WebElement getEmailAddress()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
}

//id="email"
	//id="password"
	//	type="submit"		class="btn btn-login float-right"