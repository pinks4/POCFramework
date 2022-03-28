package walmart;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class HomePageTest extends Base {

	HomePage homepage;

	@Test
	public void homePageNavigation() {

		String HomePagetitle = driver.getTitle();
		Assert.assertEquals(HomePagetitle, "Online Shopping Canada: Everyday Low Prices at Walmart.ca!");
	}

	@Test
	public void clickFromMenuList() throws InterruptedException {
		homepage = new HomePage(driver);
		List<WebElement> menuLinks = homepage.getLinks();
		for (WebElement link : menuLinks) {
			String subLink = link.getText();

			if (subLink.equalsIgnoreCase("Clothing"))
				System.out.println(subLink);
			link.click();

		}

		String actualClothingPageHeading = homepage.getClothingHeading().getText();
		Assert.assertEquals(actualClothingPageHeading, "Clothing, Shoes & Accessories");
		System.out.println("User is successfully navigated to the clothing page");
	}

}
