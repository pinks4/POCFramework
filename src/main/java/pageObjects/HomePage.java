package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	// WebElement signInBtn=driver.findElement(By.xpath("//button[text()='Sign
	// in']"));
	public By searchField = By.cssSelector("input[placeholder*='looking for?']");
	public By searchBtn = By.cssSelector("button[type='submit']");
	By myAccount = By.xpath("//span[text()='My account']");
	By joinNow = By.xpath("//a[text()='Join now']");
	By searchBrdCrumb = By.cssSelector("span[data-automation='breadcrumb-search-term']");
	By error = By.xpath("//h1[contains(text(),\"Sorry! We can't find a match for\")]");
	By signInBtn = By.xpath("//span[text()='My account']");
	By headerQuickLinks = By.xpath("//div[@*='quick-links']");
	By clothingHeading = By.xpath("//h1[text()='Clothing, Shoes & Accessories']");

	public void clickSignIn() {
		driver.findElement(signInBtn).click();
	}

	public WebElement getSearch() {
		return driver.findElement(searchField);
	}

	public WebElement searchBtn() {
		return driver.findElement(searchBtn);
	}

	public WebElement getSearchSuccess() {
		return driver.findElement(searchBrdCrumb);
	}

	public WebElement getErrorMsg() {
		return driver.findElement(error);

	}

	public List<WebElement> getLinks() {

		return driver.findElements(headerQuickLinks);
	}

	public WebElement getClothingHeading() {

		return driver.findElement(clothingHeading);
	}

}
