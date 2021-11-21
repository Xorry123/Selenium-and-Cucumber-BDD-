package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	 public void onTestStart(ITestResult result) {
		    
		    System.out.println("***** Test Started ***** " +result.getName());
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		    
		    System.out.println("***** Test Successfull ***** " +result.getName());
		  }
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("***** Test Failed ***** " +result.getName());
		  }
	
}
