import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {
	private WebDriver driver;
	
	private By byMenuPim = By.cssSelector("#menu_pim_viewPimModule > b");
	private By byAddEmployee = By.id("menu_pim_addEmployee");
	private By byFirstName = By.id("firstName");
	private By byMiddleName = By.id("middleName");
	private By byLastName = By.id("lastName");
	private By byEmployeeId = By.id("employeeId");
	private By byCreateLogin = By.id("chkLogin");
	private By byUserName = By.id("user_name");
	private By byPassword = By.id("user_password");
	private By byConfirmPass = By.id("re_password");
	private By byBtnSave = By.id("btnSave");
	
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void AddEmployee(Employee emp) {
		int timeout = 10;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		// navigate to add employee page
		wait.until(ExpectedConditions.elementToBeClickable(byMenuPim));
		driver.findElement(byMenuPim).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(byAddEmployee));
		driver.findElement(byAddEmployee).click();
		
		// fill in information
		wait.until(ExpectedConditions.visibilityOfElementLocated(byFirstName));
		driver.findElement(byFirstName).sendKeys(emp.get("First Name"));
		driver.findElement(byMiddleName).sendKeys(emp.get("Middle Name"));
		driver.findElement(byLastName).sendKeys(emp.get("Last Name"));
		driver.findElement(byEmployeeId).clear();
		driver.findElement(byEmployeeId).sendKeys(emp.get("Employee Id"));
		driver.findElement(byCreateLogin).click();
		driver.findElement(byUserName).sendKeys(emp.get("User Name"));
		driver.findElement(byPassword).sendKeys(emp.get("Password"));
		driver.findElement(byConfirmPass).sendKeys(emp.get("Password"));
		
		// save
		wait.until(ExpectedConditions.elementToBeClickable(byBtnSave));
		driver.findElement(byBtnSave).click();
		
	}
}
