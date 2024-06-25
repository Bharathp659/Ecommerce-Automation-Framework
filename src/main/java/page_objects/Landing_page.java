package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_page {

	public WebDriver driver;

	public Landing_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement Searchbox;
	@FindBy(id = "nav-search-submit-button")
	private WebElement Searchbutton;

	public void Searchbutton() {
		Searchbutton.click();
	}

	public WebElement Searchbox() {
		return Searchbox;
	}

}
