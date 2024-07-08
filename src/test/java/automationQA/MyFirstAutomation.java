package automationQA;

import org.testng.annotations.Test;

public class MyFirstAutomation {

//	@Test(priority = 1)
	@Test
	public void myFirstTest() {
		System.out.println("My first test");
	}

//	@Test(priority = 2)
	@Test
	public void mySecondTest() {
		System.out.println("My second test ");
	}

//	@Test(priority = 0)
	@Test
	public void myThirdTest() {
		System.out.println("My third test ");
	}

//	@Test(priority = -1)
	@Test
	public void betaTest() {
		System.out.println("My fourth test ");
	}

}
