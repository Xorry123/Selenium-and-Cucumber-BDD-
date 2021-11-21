package listeners;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
		Assert.assertTrue(false);
	}
	
	@Test
		public void test3() {
		System.out.println("Test3");
	}
	

}
