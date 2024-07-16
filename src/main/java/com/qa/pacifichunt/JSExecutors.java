package com.qa.pacifichunt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class JSExecutors {
	WebDriver driver;
	String baseUrl = "https://pacifichunt.com";
	JavascriptExecutor js;

	@Test(enabled = false)
	public void clickPrivacyAndPolicy() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement privacy = driver.findElement(By.xpath("//a[.='Privacy Policy']/li"));
		Thread.sleep(2000);

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", privacy);
		Thread.sleep(3000);

		privacy.click();
//		Thread.sleep(2000);

	}

	@Test(enabled = false)
	public void clickTermsOfServices() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement termOfService = driver.findElement(By.xpath("//li[.='Terms of Service']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", termOfService);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(termOfService));
		termOfService.click();
	}

	@Test(enabled = true)
	public void lastTopJob() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		WebElement lastJob = driver.findElement(By.xpath("//a[.='Project management']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", lastJob);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(lastJob));
		lastJob.click();

	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}