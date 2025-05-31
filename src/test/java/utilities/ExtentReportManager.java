package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

    public class ExtentReportManager implements ITestListener {
    	
	public ExtentSparkReporter sparkReporter;            // UI of The Report
	public static ExtentReports extent;                 // Populate Common Information on the Report
	public static ExtentTest test;                     // Create Test Case Entries in the Report.(pass, fail, skip, screenshots)

	String repName;    

	public void onStart(ITestContext testContext) {
		
		
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";

	        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

	        sparkReporter.config().setDocumentTitle("eWorkstation Automation Report");
	        sparkReporter.config().setReportName("eWorkstation Automation Report");
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "eWorkstation");
	        extent.setSystemInfo("Domain", "Admin");
	        extent.setSystemInfo("User Name", System.getProperty("user.name"));
	        extent.setSystemInfo("Version", "6.5.52.1");
	    }

	    public void onTestStart(ITestResult result) {
	        // Initialize the test instance at the start of each test
	        test = extent.createTest(result.getName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "✅ Test Passed: " + result.getName());
	    }

	    
	    
	    /*public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "❌ Test Failed: " + result.getName());
	        test.log(Status.FAIL, "Cause: " + result.getThrowable());
	    }*/
	    
	    public void onTestFailure(ITestResult result) {
	        Throwable exception = result.getThrowable();
	        
	        // Extract only the exception type and the first line of the message
	        String shortErrorMessage = exception.getClass().getSimpleName() + ": " + 
	                                   (exception.getMessage() != null ? 
	                                    exception.getMessage().split("\n")[0] : "No Message");

	        test.log(Status.FAIL, "❌ Test Failed: " + result.getName());
	        test.log(Status.FAIL, "Cause: " + shortErrorMessage);
	    }


	    
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "⚠ Test Skipped: " + result.getName());
	        test.log(Status.INFO, "Reason: " + result.getThrowable());
	        System.out.println("⚠ Test Skipped: " + result.getName());
	    }


	    public void onFinish(ITestContext testContext) {
	        extent.flush();
	        System.out.println("✔ Extent Report Generated: " + ".\\reports\\" + repName);
	    }

	}
