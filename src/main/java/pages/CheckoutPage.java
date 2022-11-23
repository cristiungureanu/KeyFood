package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public By placeOrderButton = By.cssSelector("button[class='button alt']");
	public By termsCheckbox = By.cssSelector("input[id='terms']");
	
	public By orderPlacedMessage = By.cssSelector("p[class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
	public By orderNumber = By.cssSelector("li[class='woocommerce-order-overview__order order']");

}
