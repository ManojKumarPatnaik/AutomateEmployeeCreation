import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import java.util.*;
import java.io.*;

public class AutomateEmployeeTest {
	private WebDriver driver;
	private ArrayList<Employee> empList;
	@Before
	public void setup() throws IOException {
		// 0 = Firefox, 1 = Chrome, 2 = Edge
		int browser = 0;
		
		if(browser == 1) {
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(chromeOpt);
		} else if (browser == 2) {
			System.setProperty("webdriver.edge.driver","D:\\WebDriver\\bin\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			// default
			driver = new FirefoxDriver();
		}

	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	    driver.manage().window().setSize(new Dimension(1920, 1080));
	    
	    // import data from xls file
	    String filename = "src/EmployeeData.xls";
		ImportXls xls = new ImportXls(filename);
		xls.populate();
		this.empList = xls.getEmpList();
		
	}
	
	@After
	public void exit() {
	    driver.quit();
	}
	
	@Test
	public void TestAddEmployee() throws InterruptedException {
		// Admin login details
		String adminName = "Admin";
		String adminPass = "admin123";
		
		// create objects for all pages needed
		LoginPage loginPage = new LoginPage(this.driver);
		AddEmployeePage empPage = new AddEmployeePage(this.driver);
		EditEmployeePage editPage = new EditEmployeePage(this.driver);
		EditContactPage contactPage = new EditContactPage(this.driver);
		EditJobPage jobPage = new EditJobPage(this.driver);
		AssignLeavePage leavePage = new AssignLeavePage(this.driver);
		LogoutPage logoutPage = new LogoutPage(this.driver);
		VerifyLeavePage verifyLeavePage = new VerifyLeavePage(this.driver);
		
		Employee emp = null;
		for(int i = 0; i<this.empList.size(); i++) {
			emp = this.empList.get(i);	
			try {
				loginPage.login(adminName, adminPass);
				
				empPage.AddEmployee(emp);
				editPage.EditEmployee(emp);
				contactPage.EditContact(emp);
				jobPage.EditJob(emp);
				leavePage.AssignLeave(emp);
				logoutPage.Logout();
				loginPage.login(emp.get("User Name"), emp.get("Password"));
				verifyLeavePage.VerifyLeave(emp);
				
				logoutPage.Logout();
			} catch (Exception e){
				fail();
			}
		}
		
	}
}
