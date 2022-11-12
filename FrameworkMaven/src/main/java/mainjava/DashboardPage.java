package mainjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {
	
	@FindBy(xpath="//*[@class='head']//h1")
	WebElement titleDashboard;
	
	@FindBy(xpath="//*[@id='menu_dashboard_index']//b")
	WebElement dashboardButton;
	
	@FindBy(xpath="//*[@id='welcome']")
	WebElement wel;
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement logOutBtn;
	
	//Initiallization
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String titleOfPage() {
		String dashTitle = driver.getTitle();
		System.out.println(dashTitle);
		return dashTitle;
	}
	
	public String urlOfPage() {
		String dashUrl = driver.getCurrentUrl();
		System.out.println(dashUrl);
		return dashUrl;
	}
	
	public String verifyDashboard() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String xyz = titleDashboard.getText();
		System.out.println(xyz);
		return xyz;
	}
	
	public String verifyColorOfDash() {
		String colorValue = dashboardButton.getCssValue("background-color");
		System.out.println(colorValue);
		return colorValue;
	}
	
	public void logOutMeth() {
		wel.click();
		logOutBtn.click();
	}

}
