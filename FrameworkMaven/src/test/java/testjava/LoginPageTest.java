package testjava;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import mainjava.BaseClass;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void verifyUrl() {
		String url = loginpage.urlOfPage();
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/");
		Reporter.log(url, true);
	}

	@Test(priority = 1)
	public void verifyTitle() {
		String title = loginpage.titleOfPage();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void verifyLoginWithinCorrect() {
		loginpage.invalidCred("sameer", "malage");

	}

}
