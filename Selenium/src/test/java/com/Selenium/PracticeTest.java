package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PracticeTest {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		//for providing reports in a path this class is used
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("POC Automation Results");
		reporter.config().setDocumentTitle("Test Execution Report");
		
		// main class 
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit Alhat");
		extent.setSystemInfo("Project", "POC Web Automation");
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void loginChrome() {
		extent.createTest("Login OTM with Chrome");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ralhat\\Desktop\\Rohit\\Selenium\\Drivers\\chromedriver.exe");
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\ralhat\\Desktop\\Rohit\\Selenium\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://otm.qa.slb.com/GC3/glog.webserver.servlet.umt.Login?reqLoginOtmUI=true&redir=/GC3/glog.webserver.util.FrameGC3Servlet");
		System.out.println(driver.getTitle());
		
		extent.flush();
		
	
	
	}
	
	@Test
	public void loginFirefox() {
		
		extent.createTest("Login OTM with FireFox");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ralhat\\Desktop\\Rohit\\Selenium\\Drivers\\geckodriver.exe");
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\ralhat\\Desktop\\Rohit\\Selenium\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://otm.qa.slb.com/GC3/glog.webserver.servlet.umt.Login?reqLoginOtmUI=true&redir=/GC3/glog.webserver.util.FrameGC3Servlet");
	
		extent.flush();
	
	}
	
	
}
