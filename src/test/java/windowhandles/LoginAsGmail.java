package windowhandles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginAsGmail {

	WebDriver driver;
	String baseUrl = "https://pacifichunt.com/auth/login";
	String email = "skillshikshya.qa.test@gmail.com";
	String password = "Skillshikshya@123";

	@Test(enabled = false)
	public void loginAsGmail() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement signInAsGmailBtn = driver.findElement(By.className("nsm7Bb-HzV7m-LgbsSe-BPrWId"));
		signInAsGmailBtn.click();

		String mainWindow = driver.getWindowHandle();
		System.out.println("Main window id : " + mainWindow);

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();

		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				System.out.println("Child window id : " + childWindow);
				driver.switchTo().window(childWindow); // need to switch between window when there are multiple windows

				System.out.println(driver.getTitle());

				WebElement childEmail = driver.findElement(By.xpath("//input[@type='email']"));
				childEmail.sendKeys(email);

				WebElement emailNext = driver.findElement(By.xpath("//span[. = 'Next']"));
				emailNext.click();

				Thread.sleep(2000);

				WebElement childPassword = driver.findElement(By.xpath("//input[@type='password']"));
				childPassword.sendKeys(password);

				Thread.sleep(2000);
				WebElement passwordNext = driver.findElement(By.xpath("//span[. = 'Next']"));
				passwordNext.click();

			}
		}

		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());

	}

	@Test(enabled = true)
	public void loginAsApple() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement signInBtn = driver.findElement(By.xpath("//button[.='Continue with Apple']"));
		signInBtn.click();
		Thread.sleep(2000);
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main window id : " + mainWindow);

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();

		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				System.out.println("Child window id : " + childWindow);
				driver.switchTo().window(childWindow); // need to switch between window when there are multiple windows

				System.out.println(driver.getTitle());
				WebElement childEmail = driver.findElement(By.id("account_name_text_field"));
				childEmail.sendKeys(email);

				childEmail.sendKeys(Keys.RETURN); // next when enter is pressed

				WebElement childPassword = driver.findElement(By.xpath("//input[@type='password']"));
				childPassword.sendKeys(password);
				Thread.sleep(2000);
				childPassword.sendKeys(Keys.RETURN); // next button clicked when enter is pressed

			}
		}

		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
