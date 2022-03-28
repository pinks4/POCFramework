package walmart;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class SearchTest extends Base {

	HomePage homepage;

	/*
	 * Random 'Are you human' bot detection page appearing,hence tests are failing
	 * sometimes.
	 */

	@Test
	public void searchValidProduct() {
		homepage = new HomePage(driver);
		homepage.getSearch().sendKeys("Coconut");
		homepage.searchBtn().click();
		/*
		 * Actions actions = new Actions(driver); WebElement
		 * bot=driver.findElement(By.id("")); actions.moveToElement(bot);
		 * actions.clickAndHold().perform();
		 */
		// searchText=driver.findElement(By.cssSelector("span[data-automation='breadcrumb-search-term']")).getText();
		Assert.assertEquals(homepage.getSearchSuccess().getText(), "Search: coconut");
		System.out.println("Searched the correct product");

	}

	@Test
	public void searchInvalidProduct() {
		homepage = new HomePage(driver);
		homepage.getSearch().sendKeys("%&");
		homepage.searchBtn().click();
		Assert.assertEquals(homepage.getErrorMsg().getText(), "Sorry! We can't find a match for '%&'.");
		System.out.println("Correct Error message displayed for invalid input in search field");

	}

}
