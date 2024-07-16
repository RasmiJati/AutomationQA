package com.qa.pacifichunt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RegisterTest {

	WebDriver driver;
	String baseUrl = "https://pacifichunt.com";
	String strEmail = "test@gmail.com";
	String strPassword = "qwertyuioP@123";

	// Jobseeker

	@Test
	@Ignore
	public void signUpJobSeekerTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(2000);

		WebElement signUpBtn = driver.findElement(By.xpath("//button[text()='Sign up']"));
		signUpBtn.click();
		Thread.sleep(2000);

		WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.sendKeys("first");
		Thread.sleep(2000);

		WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
		lastName.sendKeys("test");
		Thread.sleep(2000);

		WebElement registerEmail = driver.findElement(By.name("email"));
		registerEmail.sendKeys(strEmail);
		Thread.sleep(2000);

		WebElement phoneNumber = driver.findElement(By.className("PhoneInputInput"));
		phoneNumber.sendKeys("+9779863524178");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(strPassword);
		Thread.sleep(2000);

		WebElement confirmPassword = driver.findElement(By.name("confirm_password"));
		confirmPassword.sendKeys(strPassword);

		WebElement submitForm = driver.findElement(By.xpath("//button[@type='submit']"));
		submitForm.click();

		WebElement verifyEmail = driver.findElement(By.xpath("//input[@type='email']"));
		verifyEmail.sendKeys(strEmail);

		WebElement nextBtn = driver.findElement(By.xpath("//button[text()='Next']"));
		nextBtn.click();

	}

	// Employer

	@Test(enabled = true)
	public void signUpEmployerTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// implicit wait --> global configuration wait and for through out the test
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(baseUrl);

		String strEmail = "tester65d98t@gmail.com";

		// explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign up']"))).click();

		WebElement signUpBtn = driver.findElement(By.xpath("//button[text()='Sign up']"));
		signUpBtn.click();

		WebElement signUpOption = driver.findElement(By.xpath("//button[text()='Sign up as Employer']"));
		signUpOption.click();

		WebElement representativeName = driver.findElement(By.name("owner_name"));
		representativeName.sendKeys("owner");

		WebElement representativeEmail = driver.findElement(By.name("owner_email"));
		representativeEmail.sendKeys("abcdef123@gmail.com");

		WebElement companyName = driver.findElement(By.name("company_name"));
		companyName.sendKeys("company2");

		WebElement companyEmail = driver.findElement(By.name("email"));
		companyEmail.sendKeys("abcdef123@gmail.com");

		// drop down
		WebElement selectCompanyType = driver.findElement(By.cssSelector("div[role='combobox']"));
		selectCompanyType.click();
		List<WebElement> companyTypeList = driver.findElements(By.xpath("//ul/li"));

//		for (WebElement companyList : companyTypeList) {
//			String selectCompanyList = companyList.getText();
//			if (selectCompanyList.equals("IT"))
//				companyList.click();
//		}

		// using indexing in less/small data/list

		int count = companyTypeList.size();
		companyTypeList.get(count - 6).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("PhoneInputCountry"))).click();

		// country code drop down

		List<WebElement> listOfCountryCodes = driver.findElements(By.xpath("//select/option"));
		for (WebElement countryCodeList : listOfCountryCodes) {

			String countryCodes = countryCodeList.getText();
			if (countryCodes.equals("Nepal"))
				countryCodeList.click();

		}

		WebElement phoneNumber = driver.findElement(By.xpath("//input[@type= 'tel']"));
		phoneNumber.sendKeys("9841528585");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(strPassword);

		WebElement confirmPassword = driver.findElement(By.name("confirm_password"));
		confirmPassword.sendKeys(strPassword);

		WebElement checkBox = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
		checkBox.click();

		WebElement submitForm = driver.findElement(By.xpath("//button[@type='submit']"));
		submitForm.click();
	}

	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Test Completed", true);
		driver.quit();
	}

}
