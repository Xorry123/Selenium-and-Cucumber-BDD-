package NewPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {

	
	WebDriver driver;
	
	String URL = "https://the-internet.herokuapp.com/key_presses";
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	@Test
	public void keyBoardAction() throws InterruptedException {
		
		
	Actions act = new Actions(driver);	
		
	act.sendKeys(Keys.ARROW_DOWN).perform();
	Thread.sleep(2000);
	act.sendKeys(Keys.ARROW_LEFT).perform();
	Thread.sleep(2000);
	act.sendKeys(Keys.CONTROL).perform();
	Thread.sleep(2000);
	
		
		
	}
}
