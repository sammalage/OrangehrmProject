package testjava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.AdminPage;
import mainjava.BaseClass;
import mainjava.DashboardPage;
import mainjava.LoginPage;

public class BaseTest extends BaseClass {

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		driver = new ChromeDriver(co);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@BeforeClass
	public void pageObject() {
		loginpage = new LoginPage(driver);
		dashPage = new DashboardPage(driver);
		adminPage = new AdminPage(driver);
	}

	@AfterClass
	public void browserQuit() {
		driver.quit();
	}

}
