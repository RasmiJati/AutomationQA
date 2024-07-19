package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigurationTest {

	WebDriver driver;
	Properties prop;

	// launching browser from configuration.properties
	@BeforeMethod
	public void testConfig() {
		prop = new Properties();
		try {
			// relative path / dynamic path --> look for project in package not directory
			FileInputStream input = new FileInputStream("./src/test/java/properties/configuration.properties");

			prop.load(input); // load the file in properties
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browseName = prop.getProperty("browser");
		if (browseName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browseName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browseName.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			System.out.println("invalid browser choice.. \nso running on default chrome browser");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("baseurl"));
	}

	// login as employer
	@Test(enabled = false)
	public void loginAsEmployer() {

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.findElement(By.xpath("//button[.='LOGIN AS EMPLOYER']")).click();

		driver.findElement(By.name("email")).sendKeys(getEmail());

		driver.findElement(By.name("password")).sendKeys(getPassword());

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualText = driver.findElement(By.xpath("//li[text()='Dashboard']")).getText();
		Assert.assertEquals(actualText, "Dashboard");
	}

	// login as Job Seeker
	@Test(enabled = true)
	public void loginAsJobSeeker() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.findElement(By.name("email")).sendKeys(getJobSeekerEmail());

		driver.findElement(By.name("password")).sendKeys(getJobSeekerPassword());

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualText = driver.findElement(By.xpath("//li[text()='Dashboard']")).getText();
		Assert.assertEquals(actualText, "Dashboard");
	}

	public String getEmail() {
		return prop.getProperty("email");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getJobSeekerEmail() {
		return prop.getProperty("loginemail");
	}

	public String getJobSeekerPassword() {
		return prop.getProperty("loginpassword");
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
