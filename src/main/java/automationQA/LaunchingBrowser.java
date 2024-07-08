package automationQA;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchingBrowser {

	String baseUrl = "https://pacifichunt.com";
	String expectedValue = "Pacific Dashboard";
	String message = "please check your spelling";
	WebDriver driver;

	@Test(priority = 1, enabled = false, description = "Important Test Case")
	public void runningOnChrome() {

		// run in 100 version of chrome
		ChromeOptions option = new ChromeOptions();
		option.setBrowserVersion("117");
		driver = new ChromeDriver(option);

		// maximize window
		driver.manage().window().maximize();
		driver.get(baseUrl);

		String actualValue = driver.getTitle();
		Assert.assertEquals(actualValue, expectedValue, message);

	}

	@Test(priority = 2, enabled = false)
	public void runningOnFirefox() {
		FirefoxOptions option = new FirefoxOptions();
		option.setBrowserVersion("100");
		driver = new FirefoxDriver();
		// maximize window
		driver.manage().window().maximize();
		driver.get(baseUrl);

		String actualValue = driver.getTitle();

		// without using Assert
//		if(actualValue.equals("Pacific Dashboard")) {
//			System.out.println("Title verified");
//		}else {
//			System.out.println("Title Not verified");
//		}

		Assert.assertEquals(actualValue, expectedValue, message);

	}

	@Test(priority = 3, enabled = true)
	public void runningOnEdge() {
		EdgeOptions option = new EdgeOptions();
		option.setBrowserVersion("100");
		driver = new EdgeDriver();
		// maximize window
		driver.manage().window().maximize();
		driver.get(baseUrl);

		String actualValue = driver.getTitle();
		Assert.assertEquals(actualValue, expectedValue);
		Assert.assertEquals(actualValue, expectedValue, message);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
