package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver;
	protected Properties prop;

	String dirPath = System.getProperty("user.dir");

	public WebDriver initializeDriver() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(dirPath + "/src/main/java/resources/data.properties");
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("File does not exists.");
		}
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", dirPath + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", dirPath + "/drivers/geckodriver64.exe");
			driver = new FirefoxDriver();

		} else

		{

			System.setProperty("webdriver.edge.driver", dirPath + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	@BeforeMethod
	public void openURL() {

		initializeDriver();
		driver.get("https://www.walmart.ca/en");
	}

	@AfterMethod
	public void closeBrowserInstance() {
		driver.close();
	}

}
