package NewPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG_EMI {

	
WebDriver driver;
	
	String URL = "https://emicalculator.net/";
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	
	  @AfterClass public void tearDown() {
		  driver.close();
	  
	  }
	 
	
	@Test
	public void testSVGEMI() throws InterruptedException {
		
		String xpath = "//*[local-name()='g' and @class=\"highcharts-series-group\"]//*[name()='rect']";
		String tooltipPath = "//*[local-name()='svg']//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='text']";
		
		
		
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		Actions act = new Actions(driver);
		for(WebElement e:elementList) {
			act.moveToElement(e).build().perform();
			Thread.sleep(500);
			String name =driver.findElement(By.xpath(tooltipPath)).getText();
			System.out.println(name);
		}
	
		
		
	
		
	}
}
