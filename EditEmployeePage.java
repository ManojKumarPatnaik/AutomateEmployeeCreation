import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditEmployeePage {
	private WebDriver driver;
	
	private By byMenuPim = By.cssSelector("#menu_pim_viewPimModule > b");
	private By byBtnSave = By.id("btnSave");
	private By byLicenNum = By.id("personal_txtLicenNo");
	private By byLicExpDate = By.id("personal_txtLicExpDate");
	private By byOtherId = By.id("personal_txtOtherID");
	private By byMale = By.id("personal_optGender_1");
	private By byFemale = By.id("personal_optGender_2");
	private By byNation = By.id("personal_cmbNation");
	private By byMaritalStatus = By.id("personal_cmbMarital");
	private By byDateOfBirth = By.id("personal_DOB");
	private By byEmpSearch = By.id("empsearch_employee_name_empName");
	private By byBtnSearch = By.id("searchBtn");
	private By byFirstMiddle;
	
	
	public EditEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EditEmployee(Employee emp) {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		this.byFirstMiddle = By.linkText(emp.get("First Name") + " " + emp.get("Middle Name"));
		
		// navigate to employee list page
		wait.until(ExpectedConditions.elementToBeClickable(byMenuPim));
		driver.findElement(byMenuPim).click();
		
		// search for employee by full name
		wait.until(ExpectedConditions.elementToBeClickable(byEmpSearch));
	    	driver.findElement(byEmpSearch).sendKeys(emp.get("First Name") + " " + emp.get("Middle Name") + " " + emp.get("Last Name"));
	    	wait.until(ExpectedConditions.elementToBeClickable(byBtnSearch));
	    	driver.findElement(byBtnSearch).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(byFirstMiddle));
	    	driver.findElement(byFirstMiddle).click();
	    
	    	// edit personal details
	    	wait.until(ExpectedConditions.elementToBeClickable(byBtnSave));
	    	driver.findElement(byBtnSave).click();
	    
	    	// fill in information
		wait.until(ExpectedConditions.elementToBeClickable(byLicenNum));
		driver.findElement(byLicenNum).clear();
	    	driver.findElement(byLicenNum).sendKeys(emp.get("License Number"));
	    
	    	driver.findElement(byLicExpDate).clear();
	   	driver.findElement(byLicExpDate).sendKeys(emp.get("License Expiry Date"));
	    	driver.findElement(byOtherId).clear();
	    	driver.findElement(byOtherId).sendKeys(emp.get("Other Id"));
	    
	    	if(emp.get("Gender").compareTo("Male") == 0) {
	     	    driver.findElement(byMale).click();
	    	} else {
	    	    driver.findElement(byFemale).click();
	    	}
	 
	    	{
	      	  WebElement dropdown = driver.findElement(byNation);
	      	  dropdown.findElement(By.xpath("//option[. = '"+emp.get("Nationality") +"']")).click();
	    	}
	    
	    	driver.findElement(byMaritalStatus).click();
	    	{
	      	  WebElement dropdown = driver.findElement(byMaritalStatus);
	      	  dropdown.findElement(By.xpath("//option[. = '"+ emp.get("Marital Status") +"']")).click();
	    	}
	    
	    	driver.findElement(byDateOfBirth).clear();
	    	driver.findElement(byDateOfBirth).sendKeys(emp.get("Date of Birth"));
	    
	    	// save
	    	driver.findElement(byBtnSave).click();
	}
}
