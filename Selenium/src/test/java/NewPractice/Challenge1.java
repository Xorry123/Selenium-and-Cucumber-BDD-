package NewPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Challenge1 {

	
	static WebDriver driver;
	
	String URL = "https://www.worldometers.info/world-population/";
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
	public void getPopulationData() throws InterruptedException {
		
		String xpath_currentPopulation = "//div[@class='maincounter-number']//span[@class='rts-counter']";
		String xpath_Today_Thisyear = "//div[ text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
		
		printData(xpath_Today_Thisyear);
		
		
	}
	
	public static void printData(String locator) throws InterruptedException {
		int counter=0;
		
		List<WebElement> popList = driver.findElements(By.xpath(locator));
		
		while(counter<6) {
			for (WebElement e : popList) {
				System.out.println(e.getText());
			}
			
			Thread.sleep(1000);
			counter+=1;
		}
	}
}
