package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AdminPage extends BasePage {

	// Constructor
	public AdminPage(WebDriver driver) 
	{
		super(driver);
	}

    // Locators 
	@FindBy(xpath="//*[text()='Admin']")
	WebElement adminTab;
	
	// Actions Methods
	public void clickAdminTab()
	{
		adminTab.click();
	}






}
