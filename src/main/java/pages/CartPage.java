package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers{

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public By increaseQuantityButton = By.cssSelector("div[class='quantity-button plus']");
	public By totalPrice = By.cssSelector("td[data-title='Total']");
	public By checkoutButton = By.cssSelector("a[class=\"checkout-button button alt wc-forward\"]");
	
	
	
}
