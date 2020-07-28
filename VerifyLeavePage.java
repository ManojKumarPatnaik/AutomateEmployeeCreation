import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLeavePage {
	private WebDriver driver;
	
	private By byMenuLeave = By.cssSelector("#menu_leave_viewLeaveModule > b");
	private By byFromToDate = null;
	
	public VerifyLeavePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void VerifyLeave(Employee emp) {
		int timeout = 2;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		String fromToDate = emp.get("From Date") + " to " + emp.get("To Date");
		this.byFromToDate = By.linkText(fromToDate);
		
		driver.findElement(byMenuLeave).click();
		
		// if element can be found, leave is assigned correctly
		// if element cannot be found, an exception is thrown
		// exception is caught in AutomateEmployeeTest and fails the test
		wait.until(ExpectedConditions.visibilityOfElementLocated(byFromToDate));
	    	driver.findElement(byFromToDate);
	   
	}
}
