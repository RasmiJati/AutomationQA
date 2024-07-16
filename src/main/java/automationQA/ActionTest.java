package automationQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionTest {

	WebDriver driver;
	String baseUrl = "https://www.nepal.ubuy.com/en";

	@Test(enabled = false)
	public void hoveronAccountTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement account = driver.findElement(By.xpath("(//span[.='Account'])[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform(); // hover the element

		Thread.sleep(3000);

	}

	@Test(enabled = false)
	public void hoverOnSigninTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement account = driver.findElement(By.xpath("(//span[.='Account'])[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform(); // hover on Account
		Thread.sleep(3000);

		WebElement signin = driver.findElement(By.xpath("//li[.='Sign in']"));
		action.moveToElement(signin).build().perform(); // hover on Sign in

		Thread.sleep(3000);

	}

	@Test(enabled = true)
	public void hoverAndClickOnSigninTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement account = driver.findElement(By.xpath("(//span[.='Account'])[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform(); // hover on Account
		Thread.sleep(3000);

		WebElement signin = driver.findElement(By.xpath("//li[.='Sign in']"));
		action.moveToElement(signin).click().build().perform(); // hover and click on Sign in

		Thread.sleep(3000);

	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}
