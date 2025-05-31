package base;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

//import adminPageObjects.Login_Logout_Page;
//import utilities.ExtentReportManager;

public class BaseTest {
	
public static WebDriver driver;     // Static for shared driver across tests
	 
	 @BeforeClass
	 public void setup() {
	     System.out.println("🚀 Starting WebDriver and launching the application...");
	     driver = new ChromeDriver(); 
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");   
	     driver.manage().window().maximize();
	     System.out.println("✅ Application launched successfully.");
	 }
	 
	 // Flexible random string generator
	    public String randomString(int length) 
	    {
	        return RandomStringUtils.randomAlphabetic(length);
	    }
	    
	    public String randomNumeric(int length)
		{
	    	return RandomStringUtils.randomNumeric(length);
		}
	  /*@AfterMethod
	 public void logoutIfTestFails(ITestResult result) 
	 {
	        if (result.getStatus() == ITestResult.FAILURE) 
	        {
	            System.out.println("❌ Test failed: " + result.getName() + " → Logging out...");
	            ExtentReportManager.test.log(Status.INFO, "❌ Test failed: " + result.getName() + " → Logging out.");
	            Login_Logout_Page logoutPage = new Login_Logout_Page(driver);
	            logoutPage.logout();
	            ExtentReportManager.test.log(Status.INFO, "✅ Logout successful!");
	        }
	    }*/
	    
	 @AfterClass
	 public void tearDown() {
	     if (driver != null) {
	         System.out.println("🛑 Closing WebDriver...");
	         driver.quit();
	         System.out.println("✅ WebDriver closed.");
	     }
	 
	 }
}
