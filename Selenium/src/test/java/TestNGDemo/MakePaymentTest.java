package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MakePaymentTest {
	
	
	@Test
	public void makePayment() {
		System.out.println("makePayment method: Passed");
		Assert.assertTrue(true);
		 
	}
	
	@Test
	public void paymentSuccessful() {
		System.out.println("paymentSuccessful method: Failed");
		Assert.assertTrue(false);
		 
	}
}
