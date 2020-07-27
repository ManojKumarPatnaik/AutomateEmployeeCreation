import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditContactPage {
	private WebDriver driver;
	
	private By byBtnSave = By.id("btnSave");
	private By byStreet1 = By.id("contact_street1");
	private By byStreet2 = By.id("contact_street2");
	private By byCity = By.id("contact_city");
	private By byProvince = By.id("contact_province");
	private By byZipcode = By.id("contact_emp_zipcode");
	private By byCountry = By.id("contact_country");
	private By byHomePhone = By.id("contact_emp_hm_telephone");
	private By byMobilePhone = By.id("contact_emp_mobile");
	private By byWorkPhone = By.id("contact_emp_work_telephone");
	private By byWorkEmail = By.id("contact_emp_work_email");
	private By byOtherEmail = By.id("contact_emp_oth_email");
	private By byContactDetails = By.linkText("Contact Details");
	
	
	public EditContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EditContact(Employee emp) {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		// navigate from employee page to edit contact page
		driver.findElement(byContactDetails).click();
		wait.until(ExpectedConditions.elementToBeClickable(byBtnSave));
	    driver.findElement(byBtnSave).click();
	    
	    // fill in information
	    driver.findElement(byStreet1).clear();
	    driver.findElement(byStreet1).sendKeys(emp.get("Address Street 1"));
	    driver.findElement(byStreet2).clear();
	    driver.findElement(byStreet2).sendKeys(emp.get("Address Street 2"));
	    driver.findElement(byCity).clear();
	    driver.findElement(byCity).sendKeys(emp.get("City"));
	    driver.findElement(byProvince).clear();
	    driver.findElement(byProvince).sendKeys(emp.get("State/Province"));
	    driver.findElement(byZipcode).clear();
	    driver.findElement(byZipcode).sendKeys(emp.get("Zip/Postal Code"));
	    {
	      WebElement dropdown = driver.findElement(byCountry);
	      dropdown.findElement(By.xpath("//option[. = '" + emp.get("Country") + "']")).click();
	    }
	    driver.findElement(byHomePhone).clear();
	    driver.findElement(byHomePhone).sendKeys(emp.get("Home Telephone"));
	    driver.findElement(byMobilePhone).clear();
	    driver.findElement(byMobilePhone).sendKeys(emp.get("Mobile"));
	    driver.findElement(byWorkPhone).clear();
	    driver.findElement(byWorkPhone).sendKeys(emp.get("Work Telephone"));
	    driver.findElement(byWorkEmail).clear();
	    driver.findElement(byWorkEmail).sendKeys(emp.get("Work Email"));
	    driver.findElement(byOtherEmail).clear();
	    driver.findElement(byOtherEmail).sendKeys(emp.get("Other Email"));
		
	    // save
	    driver.findElement(byBtnSave).click();
	}
}
