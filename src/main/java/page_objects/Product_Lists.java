package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Lists {
	public WebDriver driver;

	public Product_Lists(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="a-autoid-3-announce")
	private WebElement Addcart;
	@FindBy(id="nav-cart-text-container")
	private WebElement cart;
	@FindBy(xpath="//body/div[@id='a-page']/div[1]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/a[1]/img[1]")
	private WebElement verifyproduct;	

	public WebElement verifyProduct() {
	return verifyproduct;
}
public void First_Product_Added_to_Cart() {
		Addcart.click();
	}

	public void openCart() {
		cart.click();
	}
}
