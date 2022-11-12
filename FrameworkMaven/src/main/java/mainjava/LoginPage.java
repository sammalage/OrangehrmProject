package mainjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	// All Locators of Login page

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement submit;

	@FindBy(id = "spanMessage")
	WebElement msg;

	//Initiallization
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// login method
	public void loginMethod(String UnameData, String passData) {
		username.sendKeys(UnameData);
		password.sendKeys(passData);
		submit.click();
	}

	// Method
	public String titleOfPage() {
		String title = driver.getTitle();
		return title;
	}

	public String urlOfPage() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String invalidCred(String invalidUname, String invalidPass) {
		username.sendKeys(invalidUname);
		password.sendKeys(invalidPass);
		submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String invalidMsg = msg.getText();
		return invalidMsg;
	}

	public String invalidCred2(String expectMsg) {
		String msgInvalid = msg.getText();
		return msgInvalid;
	}

}
