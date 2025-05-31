package testCase;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.AdminPage;
import pageObject.LoginPage;

public class TC_002_AdminTest extends BaseTest {
	
	
	@Test
	public void admintest()
	{
		LoginPage lp = new LoginPage(driver);	
		lp.enterUsernameInputbox("Admin");
		lp.enterPasswordInputbox("admin123");
		lp.clickLoginbtn();
		
		AdminPage ap = new AdminPage(driver);
		ap.clickAdminTab();
	}
	
	}


