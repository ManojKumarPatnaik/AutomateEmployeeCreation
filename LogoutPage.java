import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	private WebDriver driver;
	
	private By byWelcome = By.id("welcome");
	private By byLogout = By.linkText("Logout");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Logout() {
		int timeout = 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		wait.until(ExpectedConditions.elementToBeClickable(byWelcome));
		driver.findElement(byWelcome).click();
		wait.until(ExpectedConditions.elementToBeClickable(byLogout));
	    driver.findElement(byLogout).click();
	}
}
