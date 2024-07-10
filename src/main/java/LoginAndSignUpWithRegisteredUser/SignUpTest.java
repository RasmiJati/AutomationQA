package LoginAndSignUpWithRegisteredUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SignUpTest {

	WebDriver driver;
	String baseUrl = "file:///D:/QA/course/eclipse_project/automationQA/src/main/java/automationQA/FormExercise.html";

	// valid email and password
	@Test(enabled = false)
	public void verifyValidRegister() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("signuptest");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("signuptest@gmail.com");

		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("qwertyuiop");

		Thread.sleep(1000);
		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("qwertyuiop");

		Thread.sleep(1000);
		WebElement register = driver.findElement(By.id("register-btn"));
		register.click();

		WebElement message = driver.findElement(By.id("success-message"));
		String actualValue = message.getText();
		Assert.assertEquals(actualValue, "Registration successful");

		WebElement showData = driver.findElement(By.id("display-values"));
		String actualResult = showData.getText();
		Assert.assertEquals(actualResult,
				"Name: signuptest\n" + "Email: signuptest@gmail.com\n" + "Password: qwertyuiop");
	}

	// invalid email and valid password
	@Test(enabled = false)
	public void InvalidEmail() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("abcdef");

		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("qwertyuiop");

		Thread.sleep(1000);
		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("qwertyuiop");

		Thread.sleep(1000);
		WebElement register = driver.findElement(By.id("register-btn"));
		register.click();

		WebElement emailError = driver.findElement(By.id("email-error"));
		String actualValue = emailError.getText();
		Assert.assertEquals(actualValue, "Please enter a valid email address");

	}

	// invalid password and valid email

	@Test(enabled = true)
	public void invalidPassword() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("signuptest@gmail.com");

		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abcd");

		Thread.sleep(1000);
		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("abcd");

		Thread.sleep(1000);
		WebElement register = driver.findElement(By.id("register-btn"));
		register.click();

		WebElement errorMsg = driver.findElement(By.id("password-error"));
		String actualMsg = errorMsg.getText();
		Assert.assertEquals(actualMsg, "Password must be at least 8 characters long");
	}

	// Password donot match
	@Test(enabled = false)
	public void unmatchedPasswordAndConfirmpassword() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("signuptest@gmail.com");

		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("qwertyuiop");

		Thread.sleep(1000);
		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("abcdefghij");

		Thread.sleep(1000);
		WebElement register = driver.findElement(By.id("register-btn"));
		register.click();

		WebElement errorMsg = driver.findElement(By.id("password-match-error"));
		String actualMsg = errorMsg.getText();
		Assert.assertEquals(actualMsg, "Passwords do not match");
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Sign Up Test Completed", true);
		driver.quit();
	}

}
