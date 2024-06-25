package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resourceses.Base;

import utilities.ExtentReporter;

public class Listener extends Base implements ITestListener {
	ExtentReports extentReportes = ExtentReporter.getExtentReporter();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extentReportes.createTest(result.getName() + " execution started");
		extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTestThread.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	extentTestThread.get().fail(result.getThrowable());
	WebDriver driver = null;
	
	String testMethodName = result.getName();

	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
				.get(result.getInstance());
	} catch (Exception e) {
		e.printStackTrace();
	}

	try {
		String screenshotFilePath = Screenshot(driver,testMethodName);
		extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
	} catch (IOException e) {

		e.printStackTrace();
	}
}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReportes.flush();
	}

}
