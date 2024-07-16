package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;

	String baseUrl = "https://demo.automationtesting.in/Alerts.html";

	@Test(enabled = false)
	public void alertOkTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement alertOkTest = driver
				.findElement(By.xpath("//button[contains(text(),'click the button to display an')]"));
		alertOkTest.click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(enabled = false)
	public void alertWithOkAndCancel() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement alertOkCancelTest = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		alertOkCancelTest.click();

		WebElement confirmBtn = driver
				.findElement(By.xpath("//button[text()='click the button to display a confirm box ']"));
		confirmBtn.click();

//		Alert alert = driver.switchTo().alert();   // goes to alert dialog
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());

		// to accept i.e. ok
//		alert.accept();

		// to reject i.e. cancel
		alert.dismiss();
	}

	@Test(enabled = true)
	public void alertWithTextBox() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

//		driver.findElement(By.xpath("//a[text()='Alert with Textbox']")).click();    --> shortcut but not preferable 

		WebElement alertTextBox = driver.findElement(By.xpath("//a[contains(.,'Alert with Textbox')]"));
		alertTextBox.click();

		WebElement confirmBtn = driver
				.findElement(By.xpath("//button[.='click the button to demonstrate the prompt box ']"));
		confirmBtn.click();

		Alert alert = driver.switchTo().alert(); // goes to alert dialog
		alert.sendKeys(" world");

		// to accept i.e. ok
		alert.accept();

		// to reject i.e. cancel
//		alert.dismiss();
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}
