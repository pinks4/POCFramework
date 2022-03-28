package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;

	}

	By userName = By.xpath("//input[@type='text']");
	By password = By.id("password"); // By.cssSelector("#password");
	By signIn = By.xpath("//button[text()='Sign in']");
	By signInPwdIncorrect = By.xpath("//div[@data-automation='error-105']");

	public void clickOnSignIn() {

		HomePage hp = new HomePage(driver);
		hp.clickSignIn();

	}

	public WebElement usernameField() {

		return driver.findElement(userName);
	}

	public WebElement passwordField() {

		return driver.findElement(password);
	}

	public WebElement getSignInOnSignInPage() {

		return driver.findElement(signIn);
	}

	public WebElement getIncorrectPwdError() {

		return driver.findElement(signInPwdIncorrect);
	}

}
