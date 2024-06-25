package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentreportes;

	public static ExtentReports getExtentReporter() {

		String path = System.getProperty("user.dir") + "\\reports\\extentreport.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(path);
		Reporter.config().setReportName("Flipkart automation results");
		Reporter.config().setDocumentTitle("Test Reulsts");
		extentreportes = new ExtentReports();

		extentreportes.attachReporter(Reporter);
		extentreportes.setSystemInfo("Operating System", "Windows 10");

		extentreportes.setSystemInfo("Tested By", "Bharath");
		return extentreportes;
	}

}
