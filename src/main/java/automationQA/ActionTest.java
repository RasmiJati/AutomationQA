package automationQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionTest {

	WebDriver driver;

	@Test
	public void hoverTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nepal.ubuy.com/en");

		WebElement account = driver.findElement(By.xpath("(//span[.='Account'])[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform();

		WebElement signin = driver.findElement(By.xpath("//li[.='Sign in']"));
		action.moveToElement(signin).contextClick().build().perform(); // right click

//		 action.moveToElement(signin).click().build().perform();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}
