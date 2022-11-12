package testjava;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {
	
	@Test(priority = 0)
	public void dashlog() {
		loginpage.loginMethod("Admin", "admin123");
	}

	@Test(priority = 1)
	public void verifyUrl() {
		String urldash = dashPage.urlOfPage();
		Assert.assertEquals(urldash, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Reporter.log(urldash, true);
	}

	@Test(priority = 2)
	public void verifyTitle() {
		String titledash = dashPage.titleOfPage();
		Assert.assertEquals(titledash, "OrangeHRM");
		Reporter.log(titledash, true);
	}

	@Test(priority = 3)
	public void verifyDash() {
		String dashName = dashPage.verifyDashboard();
		Assert.assertEquals(dashName, "Dashboard");
		Reporter.log(dashName, true);
	}

	@Test(priority = 4)
	public void verifyColor() {
		String color = dashPage.verifyColorOfDash();
		Assert.assertEquals(color, "rgba(242, 140, 56, 1)");
		Reporter.log(color, true);
	}

}
