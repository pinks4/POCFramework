package walmart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SignInPage;
import resources.Base;

public class SignInTest extends Base {

	Properties prop;

	@Test
	public void validSignIn() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File does not exists.");
		}
		SignInPage signIn = new SignInPage(driver);
		signIn.clickOnSignIn();
		signIn.usernameField().sendKeys(prop.getProperty("email"));
		signIn.passwordField().sendKeys(prop.getProperty("password"));
		signIn.getSignInOnSignInPage().click();
		System.out.println("Signed in successfully");

	}

	// @Test - test failing as a bot detection component pops!
	public void invalidSignIn() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File does not exists.");
		}
		SignInPage signIn = new SignInPage(driver);
		signIn.clickOnSignIn();
		signIn.usernameField().sendKeys(prop.getProperty("email"));
		signIn.passwordField().sendKeys(prop.getProperty("incorrectPassword"));
		signIn.getSignInOnSignInPage().click();
		String errorText = signIn.getIncorrectPwdError().getText();
		Assert.assertEquals(errorText, "Your password and email do not match. Please try again or ");
		System.out.println("User is unable to sign in due to incorrect credentials");

	}

}
