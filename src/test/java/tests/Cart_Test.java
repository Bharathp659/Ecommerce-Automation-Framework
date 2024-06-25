package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page_objects.Landing_page;
import page_objects.Product_Lists;
import resourceses.Base;

public class Cart_Test extends Base {
	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void OpensBrowser() throws IOException {
		log = LogManager.getLogger(Cart_Test.class.getName());
		driver = Browsers();
		log.debug("opens the browser");
		driver.get(prop.getProperty("url"));
		log.debug("navigate to the url");
	}

	@Test
	public void CartTest() throws IOException, InterruptedException {
		Landing_page Lp = new Landing_page(driver);
		Lp.Searchbox().sendKeys(prop.getProperty("product"));
		log.debug("search the given peoduct");
		Lp.Searchbutton();
		log.debug("navigated to search button");
		Product_Lists Pl = new Product_Lists(driver);
		Pl.First_Product_Added_to_Cart();
		log.debug("Adding the first project to cart");
		Pl.openCart();
		log.debug("opens the cart page");
	try{
		if(Pl.verifyProduct().isDisplayed());
		log.info("Product added to cart and verified");
		Screenshot(driver,"cart");
	}catch(Exception e)
	{
		log.error("Product not added to cart");
		
	}
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.debug("closes the browser");
	}
}
