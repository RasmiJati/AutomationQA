package automationQA;

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
	String baseUrl = "https://practicetestautomation.com/practice-test-login/";

	/*
	 * How to verify login passed: 
	 	* By CSS ID: find_element_by_id By CSS class name: find_element_by_class_name
	 	* By name attribute: find_element_by_name By DOM structure or Xpath:
	 	* find_element_by_xpath by tagName: find_element_by_tag_name() By link text:
	 	* find_element_by_link_text By partial link text:
	 	* find_element_by_partial_link_text By HTML tag name: find_element_by_tag_name
	 */

	@Test(enabled = false)
	public void verifyValidLogin() throws InterruptedException {

//		initalize browser / open browser
		driver = new ChromeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// passing url to go to url
		driver.get(baseUrl);

//		WebElement id1 = driver.findElement(By.xpath("//input[@id='username']"));   --> using xpath
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("student");

		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Password123"); // put data to the input field of password in login form

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

		String actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, "Test Login | Practice Test Automation");
	}

	
	//Invalid username
	@Test(enabled = true)
	public void verifyInvalidUserName() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("abcd");

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

		WebElement errorMsg = driver.findElement(By.id("error"));
		String actualValue = errorMsg.getText();
		Assert.assertEquals(actualValue, "Your username is invalid!");

	}

	
//	valid username and invalid password
	@Test(enabled = true)
	public void verifyInvalidPassword() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("student");

		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abcd");

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

		WebElement errorMsg = driver.findElement(By.id("error"));
		String actualValue = errorMsg.getText();
		Assert.assertEquals(actualValue, "Your password is invalid!");

	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}
}
