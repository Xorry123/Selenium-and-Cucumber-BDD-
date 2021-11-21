package NewPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CrossBroswerDemo {

	WebDriver driver;
	
	@Parameters("browser")
	@Test()
	public void launchAppTest(@Optional("Insert folder name here or leave empty")String browsername) throws InterruptedException {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browsername.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://sapf1q.dir.slb.com:44310/fiori?saml2=disabled&spnego=disabled");
		
		Thread.sleep(3000);
		driver.close();
		
		
	}
}
