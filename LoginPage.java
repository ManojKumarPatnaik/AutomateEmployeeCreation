import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	
	private By byUsername = By.id("txtUsername");
	private By byPassword = By.id("txtPassword");
	private By byLoginBtn = By.id("btnLogin");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(byUsername));
		driver.findElement(byUsername).sendKeys(username);
		driver.findElement(byPassword).sendKeys(password);
		driver.findElement(byLoginBtn).click();
	}
	
}
