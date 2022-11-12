package testjava;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

	@Test(priority = 0)
	public void adminlog() {
		loginpage.loginMethod("Admin", "admin123");
	}

	@Test(priority = 1)
	public void verifyAdminBtn() {
		String colorofBtn = adminPage.adminBtnCheck();
		Assert.assertEquals(colorofBtn, "rgba(242, 140, 56, 1)");
		Reporter.log(colorofBtn, true);
	}

	@Test(priority = 2, enabled=true)
	public void verifySystemUser() {
		adminPage.searchSystemUserMeth("Aravind", "ESS", "Dominic Chase", "Enabled");

	}
	
	
	@Test(priority = 3, enabled=true)
	public void verifyAlternateCheckbox() {
		adminPage.alterCheckBox();
	}
	
	@Test(priority = 4)
	public void verifySecificCheckbox() {
		adminPage.perticularCheckBox("Charlie.Carter");
		adminPage.perticularCheckBox("Ehioze.Ebo");
	}

}
