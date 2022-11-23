package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.NavMenuPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest{

	@Parameters({"user", "pass"})
	@Test (priority=0, groups = "LoginFunctionality")
	public void loginTest(String username, String parola) throws InterruptedException {
		
		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(username, parola);
		
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		
		navMenu.searchProduct("Pretzels");
		
		// send Enter from keyboard 
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
		assertEquals(navMenu.readUrl(), "https://keyfood.ro/product/rold-gold-tiny-twists-pretzels/");
		
		ProductPage product = new ProductPage(driver);
		//click on Add To Cart
		navMenu.navigateTo(product.addToCartButton);
		
		
		assertTrue(driver.findElement(product.confirmationMessageAddedToCart).getText().contains("Rold Gold Tiny Twists Pretzels” has been added to your cart."));
		
		//navigateTo Cart
		navMenu.navigateTo(product.viewCartButton);
		
		CartPage cart = new CartPage(driver);
		
		System.out.println("TOTAL INITIAL PRICE IS " + driver.findElement(cart.totalPrice).getText().substring(1));
		
		navMenu.navigateTo(cart.increaseQuantityButton); //increase quantity
				
		double totalBeforeUpdate = Double.parseDouble(driver.findElement(cart.totalPrice).getText().substring(1));
		
		Thread.sleep(3000);
		System.out.println("TOTAL PRICE IS " + driver.findElement(cart.totalPrice).getText().substring(1));
		
		double totalAfterUpdate = Double.parseDouble(driver.findElement(cart.totalPrice).getText().substring(1));
		assertTrue(totalBeforeUpdate<totalAfterUpdate); // se verifica ca total price was updated
		
		navMenu.navigateTo(cart.checkoutButton);
		Thread.sleep(3000);
		
		CheckoutPage checkout = new CheckoutPage(driver);
		driver.findElement(checkout.termsCheckbox).click();

		driver.findElement(checkout.placeOrderButton).click();
		
		//se verifica ca "order is placed"
		assertTrue(driver.findElement(checkout.orderPlacedMessage).getText().contains("Thank you. Your order has been received"));
		
		//System.out.println(driver.findElement(checkout.orderNumber).getText().substring(14));
		
		//se verifica ca "order has a number"
		assertTrue(!driver.findElement(checkout.orderNumber).getText().substring(14).isEmpty());

	}	

}
