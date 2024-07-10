package LoginAndSignUpWithRegisteredUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	String baseUrl = "file:///D:/QA/course/eclipse_project/automationQA/src/main/java/automationQA/FormExercise.html";

	@Test(enabled = true)
	public void verifyValidLogin() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement email = driver.findElement(By.id("login-email"));
		email.sendKeys("signuptest@gmail.com");

		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("qwertyuiop");

		WebElement login = driver.findElement(By.id("login-btn"));
		login.click();

		WebElement successMessage = driver.findElement(By.id("login-sucess-message"));
		String actualMessage = successMessage.getText();
		Assert.assertEquals(actualMessage, "Login successful");

		WebElement displayMessage = driver.findElement(By.id("login-display-values"));
		String actualDisplayMessage = displayMessage.getText();
		Assert.assertEquals(actualDisplayMessage, "Email: signuptest@gmail.com");
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Login Test Completed");
		driver.quit();
	}
}
