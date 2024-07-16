package automationQA;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchTest {

	String baseUrl = "https://www.google.com/";
	WebDriver driver;

	@Test(enabled = true)
	public void searchIndexingInGoogle() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement inputTextBox = driver.findElement(By.name("q"));
		inputTextBox.sendKeys("Everest");

		Thread.sleep(3000);

		List<WebElement> searchList = driver.findElements(By.xpath("//ul/li"));
//		List<WebElement> searchList = driver.findElements(By.xpath("//div[@role='presentation']"));

		int count = searchList.size();
		System.out.println("total : " + count);

		Actions action = new Actions(driver);
		System.out.println(searchList.get(count - 6).getText());

		action.moveToElement(searchList.get(count - 6));
		
		searchList.get(count - 6).click();
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}
}
