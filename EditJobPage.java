import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditJobPage {
	private WebDriver driver;
	
	private By byBtnSave = By.id("btnSave");
	private By byJobDetails = By.linkText("Job");
	private By byJobTitle = By.id("job_job_title");
	private By byEmploymentStatus = By.id("job_emp_status");
	private By byEeoCategory = By.id("job_eeo_category");
	private By byJoinedDate = By.id("job_joined_date");
	private By byJobUnit = By.id("job_sub_unit");
	private By byJobLocation = By.id("job_location");
	private By byContractStartDate = By.id("job_contract_start_date");
	private By byContractEndDate = By.id("job_contract_end_date");
	
	
	public EditJobPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EditJob(Employee emp) {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		// navigate from employee page to edit job page
		wait.until(ExpectedConditions.elementToBeClickable(byJobDetails));
		driver.findElement(byJobDetails).click();
	    	driver.findElement(byBtnSave).click();
	    
	    	// fill in information
	    	{
	      	  WebElement dropdown = driver.findElement(byJobTitle);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Job Title") + "']")).click();
	    	}
	    	{
	      	  WebElement dropdown = driver.findElement(byEmploymentStatus);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Employment Status") + "']")).click();
	    	}
	    	{
	      	  WebElement dropdown = driver.findElement(byEeoCategory);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Job Category") + "']")).click();
	    	}
	    	{
	      	  WebElement dropdown = driver.findElement(byJobUnit);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Sub Unit") + "']")).click();
	    	}
	    	{
	      	  WebElement dropdown = driver.findElement(byJobLocation);
	      	  dropdown.findElement(By.xpath("//option[. = '" + emp.get("Location") + "']")).click();
	    	}
	    	driver.findElement(byContractStartDate).clear();
	   	driver.findElement(byContractStartDate).sendKeys(emp.get("Contract Start Date"));
	   	driver.findElement(byContractEndDate).clear();
	   	driver.findElement(byContractEndDate).sendKeys(emp.get("Contract End Date"));
	   	driver.findElement(byJoinedDate).clear();
	    	driver.findElement(byJoinedDate).sendKeys(emp.get("Joined Date"));
	    
	    	// save
	    	driver.findElement(byBtnSave).click();
	}
}
