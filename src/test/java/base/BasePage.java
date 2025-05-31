package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.Status;

//import utilities.ExtentReportManager;

public class BasePage {

protected WebDriver driver;   // Protected so child classes can use it

public BasePage(WebDriver driver) 
{
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

 

protected void clickElement(WebElement element, String elementName, int timeout) {
    try {
        waitForElementToBeClickable(element, timeout);
        element.click();
        //ExtentReportManager.test.log(Status.INFO, "🟣 Step: Clicked on " + elementName + " --> ✅ Passed");
    } catch (Exception e) {
        //ExtentReportManager.test.log(Status.FAIL, "❌ ERROR: Failed to click on " + elementName + ". Exception: " + e.getClass().getSimpleName());
        throw e;  // Let the test fail naturally
    }
}

protected void enterText(WebElement element, String text, String fieldName) {
    try {
        element.sendKeys(text);
        //ExtentReportManager.test.log(Status.INFO, "🟣 Step: Entered text in " + fieldName + " --> ✅ Passed");
    } catch (Exception e) {
       // ExtentReportManager.test.log(Status.FAIL, "❌ ERROR: Failed to enter text in " + fieldName + ". Exception: " + e.getClass().getSimpleName());
        throw e;     // Let the test fail naturally
    }
}


// Wait for an element to be visible before interacting
public void waitForElement(WebElement element, int timeoutInSeconds) 
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.visibilityOf(element));
}

//Wait for an element to be click before interacting
public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) 
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

}
