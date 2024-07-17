package com.qa.pacifichunt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	String baseUrl = "https://pacifichunt.com/";

	// Job seeker

	@Test(enabled = false)
	public void loginJobSeekerTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		loginBtn.click();

		WebElement loginEmail = driver.findElement(By.name("email"));
		loginEmail.sendKeys("jatirasmi45@gmail.com");

		WebElement loginPassword = driver.findElement(By.name("password"));
		loginPassword.sendKeys("qwertyuiop");

		WebElement loginForm = driver.findElement(By.xpath("//button[@type='submit']"));
		loginForm.click();

		WebElement dashboardText = driver.findElement(By.xpath("//li[text()='Dashboard']"));
		String actualText = dashboardText.getText();
		Assert.assertEquals(actualText, "Dashboard");

	}

	// Employer

	@Test(enabled = true)
	public void loginEmployerTest() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		loginBtn.click();

		WebElement loginAsEmployerBtn = driver.findElement(By.xpath("//button[.='LOGIN AS EMPLOYER']"));
		loginAsEmployerBtn.click();

		WebElement loginEmail = driver.findElement(By.name("email"));
		loginEmail.sendKeys("lixig48106@calunia.com");

		WebElement loginPassword = driver.findElement(By.name("password"));
		loginPassword.sendKeys("qwertyuioP@123");

		WebElement loginForm = driver.findElement(By.xpath("//button[@type='submit']"));
		loginForm.click();

		WebElement dashboardText = driver.findElement(By.xpath("//li[text()='Dashboard']"));
		String actualText = dashboardText.getText();
		Assert.assertEquals(actualText, "Dashboard");

	}
}
