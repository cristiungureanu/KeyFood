package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers{

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By addToCartButton = By.cssSelector("button[name='add-to-cart']");
	public By confirmationMessageAddedToCart = By.cssSelector("div[class='woocommerce-message']");
	public By viewCartButton = By.cssSelector("a[class='button wc-forward'][tabindex='1']");
	

}
