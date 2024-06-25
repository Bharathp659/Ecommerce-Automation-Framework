package resourceses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;

	public WebDriver driver;

	public WebDriver Browsers() throws IOException {
		prop = new Properties();

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resourceses\\data.properties";
		FileInputStream Fis = new FileInputStream(path);
		prop.load(Fis);
		String browser = prop.getProperty("Browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("fire fox")) {
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String Screenshot(WebDriver driver, String testName) throws IOException {
		File Sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
		FileUtils.copyFile(Sourcefile, new File(path));
		return path;
	}
}
