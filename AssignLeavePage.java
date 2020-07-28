import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignLeavePage {
	private WebDriver driver;
	
	private By byMenuLeave = By.cssSelector("#menu_leave_viewLeaveModule > b");
	private By byAssignLeave = By.id("menu_leave_assignLeave");
	private By byEmpName = By.id("assignleave_txtEmployee_empName");
	private By byLeaveType = By.id("assignleave_txtLeaveType");
	private By byLeaveFromDate = By.id("assignleave_txtFromDate");
	private By byLeaveToDate = By.id("assignleave_txtToDate");
	private By byAssignBtn = By.id("assignBtn");
	private By byConfirmBtn = By.id("confirmOkButton");
	
	public AssignLeavePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void AssignLeave(Employee emp) {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		// navigate from homepage to assign leave page
		wait.until(ExpectedConditions.elementToBeClickable(byMenuLeave));
		driver.findElement(byMenuLeave).click();
		wait.until(ExpectedConditions.elementToBeClickable(byAssignLeave));
	    	driver.findElement(byAssignLeave).click();
	    
		// fill in information
	    	driver.findElement(byEmpName).sendKeys(emp.get("First Name") + " " + emp.get("Middle Name") + " " + emp.get("Last Name"));
	    	{
	     	  WebElement dropdown = driver.findElement(byLeaveType);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Leave Type") + "']")).click();
	    	}
	    	driver.findElement(byLeaveFromDate).clear();
	    	driver.findElement(byLeaveFromDate).sendKeys(emp.get("From Date"));
	    	driver.findElement(byLeaveToDate).clear();
	    	driver.findElement(byLeaveToDate).sendKeys(emp.get("To Date"));
		
	    	// first click is to remove overlay, second click registers
	    	driver.findElement(byAssignBtn).click();
	    	driver.findElement(byAssignBtn).click();
	    
	    	// confirm button if employee doesn't have enough balance for leave
	    	wait.until(ExpectedConditions.elementToBeClickable(byConfirmBtn));
	    	driver.findElement(byConfirmBtn).click();
	}
}
