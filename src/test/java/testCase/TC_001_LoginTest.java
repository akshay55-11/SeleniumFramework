package testCase;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.LoginPage;

public class TC_001_LoginTest extends BaseTest{
	
	
	@Test
	public void testLogin()
	{
	LoginPage lp = new LoginPage(driver);	
	lp.enterUsernameInputbox("Admin");
	lp.enterPasswordInputbox("admin123");
	lp.clickLoginbtn();
	}
	
}
