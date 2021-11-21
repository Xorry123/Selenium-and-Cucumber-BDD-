package NewPractice;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreens {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	@Test
	public void capturePageScreenshot() throws IOException {
		
		//************Full page Screenshot:-**************
		
		//We need to use TAKESSCREENSHOT interface here.
		//There are 3 interfaces Webdriver,TakesScreenShot and javaScriptExecutor
		//All have different methods and those are implemented by RemoteWebDriverClass
		//All Browser classes then inherit the RemoteWebDriverClass like  chrome,Firefox 
		//They need their separate variables to hold their instances.
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE); //Create File in JVM memory
		
		File trg = new File(".\\screenshots\\FullPage.png"); //Actual local disk path
		
		FileUtils.copyFile(src, trg);//JVM to local path
		
		
		
		
	}
	@Test 
	public void capturSectionScreenshot() throws IOException {
		
	//WebElement Section = driver.findElement(By.xpath("//*[text()='Health Care Essentials']"));	

	WebElement Section = driver.findElement(By.partialLinkText("https://rukminim1.flixcart.com/flap"));	
		
	File src =Section.getScreenshotAs(OutputType.FILE); //Create File in JVM memory
	
	File trg = new File(".\\screenshots\\PageSections.png"); //Actual local disk path
	
	FileUtils.copyFile(src, trg);//JVM to local path
	
	
	
	}
	
}
