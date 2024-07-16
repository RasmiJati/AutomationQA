package com.qa.pacifichunt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class JSExecutors {
	WebDriver driver;
	String baseUrl = "https://pacifichunt.com";

	@Test(enabled = true)
	public void clickPrivacyAndPolicy() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement privacy = driver.findElement(By.xpath("//a[.='Privacy Policy']/li"));
		WebElement vritTxtFooter = driver.findElement(By.xpath("//span[.='Vrit Tech']"));
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", vritTxtFooter);
		Thread.sleep(3000);

		privacy.click();

		// js.executeScript("arguments[0].click()", privacy);
		Thread.sleep(2000);

	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}