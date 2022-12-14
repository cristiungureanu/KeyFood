package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers{

	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public By usernameField = By.id("username");
	public By passwordField = By.cssSelector("input[id='password']");
	public By submitButton = By.cssSelector("button[class='woocommerce-button button woocommerce-form-login__submit']");
	
	//public By loginErrorMessage = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By loginSuccessMessage = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--dashboard is-active']");
	
	public By logoutButton = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']");
	//public By closePopUpButton = By.cssSelector("a[class='popup_close']");
	
	//public void closeLoginPopUp() {
	//	driver.findElement(closePopUpButton).click();
	//}
	
	public void loginInApp(String username, String password) {
		
		sendKeys(usernameField, username);
		sendKeys(passwordField, password);
		click(submitButton);

	}
	
	public void logoutFromApp() {
		
		click(logoutButton);
	}
	
	
	public boolean loginSuccessMessageIsDisplayed() {
		
		return driver.findElement(loginSuccessMessage).isDisplayed(); // isDisplayed intoarce valoarea booleana - true sau false
	}
	/*
	public boolean loginErrorMessageIsDisplayed() {
		
		return driver.findElement(loginErrorMessage).isDisplayed(); 
	}
	
	public boolean loginMessageIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
	} */
}
