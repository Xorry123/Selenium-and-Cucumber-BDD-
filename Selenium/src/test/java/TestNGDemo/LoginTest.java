package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(priority = 0)
	public void login() {
		System.out.println("Login method: Passed");
		Assert.assertTrue(true);
		 
	}
	
	@Test(priority = 1)
	public void ValidateHomePage() {
		System.out.println("ValidateHomePage method: Failed");
		Assert.assertTrue(false);
		 
	}
}
