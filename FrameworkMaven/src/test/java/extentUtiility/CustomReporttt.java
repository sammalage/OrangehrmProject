package extentUtiility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomReporttt {
	
	public static ExtentReports extent;
	public static ExtentReports reportGen() {
		
		String path = System.getProperty("user.dir")+"\\reports\\clientreport.html";
		ExtentHtmlReporter sam= new ExtentHtmlReporter(path);
		sam.config().setReportName("Regression test");
		sam.config().setDocumentTitle("Mass report");
		sam.config().setTheme(Theme.DARK);
		sam.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		
		extent = new ExtentReports();
		extent.setSystemInfo("Os", "Window");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Org", "Royal");
		extent.attachReporter(sam);
		return extent;
	}
	

}
