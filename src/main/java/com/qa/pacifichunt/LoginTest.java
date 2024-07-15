package com.qa.pacifichunt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	String baseUrl = "https://pacifichunt.com/";

	@Test(enabled = false)
	public void loginJobSeekerTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(3000);

		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		loginBtn.click();
		Thread.sleep(2000);

		WebElement loginEmail = driver.findElement(By.name("email"));
		loginEmail.sendKeys("jatirasmi45@gmail.com");
		Thread.sleep(2000);

		WebElement loginPassword = driver.findElement(By.name("password"));
		loginPassword.sendKeys("qwertyuiop");
		Thread.sleep(2000);

		WebElement loginForm = driver.findElement(By.xpath("//button[@type='submit']"));
		loginForm.click();
		Thread.sleep(2000);

		WebElement dashboardText = driver.findElement(By.xpath("//li[text()='Dashboard']"));
		String actualText = dashboardText.getText();
		Assert.assertEquals(actualText, "Dashboard");

	}
}
