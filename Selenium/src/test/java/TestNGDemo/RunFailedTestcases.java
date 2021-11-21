package TestNGDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterTest;



public class RunFailedTestcases {

	@AfterTest
	public void runfailedtestcases() {
		
		
		TestNG obj = new TestNG();
		
		List<String> list = new ArrayList<String>();		
		
		list.add("C:\\Users\\ralhat\\eclipse-workspace\\Selenium\\test-output\\Suite\\testng-failed.xml");
		obj.setTestSuites(list);
		
		obj.run(); 
		
				
				
				
		
		
	}
}
