package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage
{
    //Constructor
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//*[@name='username']")
	WebElement UsernameInputbox;

	@FindBy(xpath="//*[@name='password']")
	WebElement PasswordInputbox;

	@FindBy(xpath="//*[@type='submit']")
	WebElement Loginbtn;
	
	
	//Action method
	public void enterUsernameInputbox(String username)
	{
		UsernameInputbox.sendKeys(username);
	}
	
	public void enterPasswordInputbox(String password)
	{
		PasswordInputbox.sendKeys(password);
	}
	
	public void clickLoginbtn()
	{
		Loginbtn.click();
	}
	
	
	
	
	
	
	
	
	
	

}
