package mainjava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BaseClass {

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement adminBtn;

	@FindBy(xpath = "//*[@id='searchSystemUser_userName']")
	WebElement userNameBtn;

	@FindBy(xpath = "//*[@id='searchSystemUser_userType']")
	WebElement userTypeBtn;

	@FindBy(xpath = "//*[@id='searchSystemUser_employeeName_empName']")
	WebElement empNameBtn;

	@FindBy(xpath = "//*[@name='searchSystemUser[status]']")
	WebElement statusBtn;

	@FindBy(xpath = "//*[@id='searchBtn']")
	WebElement searchBtn;

	@FindBy(css = "#resetBtn")
	WebElement resetBtn;

	@FindBy(xpath = "//table//tr//td//input[@type='checkbox']")
	List<WebElement> checkBoxBtn;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String adminBtnCheck() {
		adminBtn.click();
		String adText = adminBtn.getText();
		System.out.println(adText);

		String adColor = adminBtn.getCssValue("background-color");
		System.out.println(adColor);
		return adColor;
	}

	public void searchSystemUserMeth(String name, String uType, String eName, String statusType) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userNameBtn.sendKeys(name);
		Select sel = new Select(userTypeBtn);
		sel.selectByVisibleText(uType);
		empNameBtn.sendKeys(eName);
		Select sel1 = new Select(statusBtn);
		sel1.selectByVisibleText(statusType);
		searchBtn.click();
		resetBtn.click();
	}

	public void alterCheckBox() {
		for (int i = 1; i <checkBoxBtn.size(); i++) {
			if (i % 2 == 0) {
				driver.findElement(By.xpath("(//*[contains(@id,'ohrmList_chkSelectRecord_')])["+i+"]")).click();
				driver.findElement(By.xpath("(//*[contains(@id,'ohrmList_chkSelectRecord_')])["+i+"]")).click();
			}
		}

	}
	
	public void perticularCheckBox(String specific) {
		WebElement pqr = driver.findElement(By.xpath("//table//tr//td//a[text()='"+specific+"']//ancestor::tr//td//input"));
		pqr.click();
		boolean selectorNot = pqr.isSelected();
		System.out.println(selectorNot);
	}

}
