package automationQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BrowserWindowSwitching {

	WebDriver driver;

	@Test(enabled = true)
	public void browserWindowSwitching() {

		driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();
		driver.get("https://pacifichunt.com");

		driver.switchTo().newWindow(WindowType.TAB); // opening new tab in window

		driver.get("https://google.com");

		driver.switchTo().newWindow(WindowType.WINDOW); // opening new chrome window

		driver.get("https://google.com");

	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}
