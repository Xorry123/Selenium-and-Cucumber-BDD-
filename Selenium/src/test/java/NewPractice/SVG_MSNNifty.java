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

public class SVG_MSNNifty {

	WebDriver driver;

	String URL = "https://www.msn.com/en-in/money/watchlist?ocid=winp1taskbar&duration=5D";

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	  @AfterClass public void tearDown() { 
		  driver.close();
	  
	  }
	 

	@Test
	public void testSVG() throws InterruptedException {

		String xpath = "(//*[name()='svg' and @class=\"react-financial-charts\"]//*[name()='rect'])[4]";
		WebElement element = driver.findElement(By.xpath(xpath));

		String tooltip = "//*[@id='chartContainer']/div/div[2]/div";
		
		int getTopLeftY = ((element.getSize().getHeight()) / 2) - element.getSize().getHeight();
		int getTopLeftX = ((element.getSize().getWidth()) / 2) - element.getSize().getWidth();

		System.out.println(element.getSize() + " " +getTopLeftX + " " + getTopLeftY 
				+ "\n" + element.getLocation()+"\n"+element.getSize());
		 
		
		
		Actions act = new Actions(driver);

		for (int i = 1; i < 50; i+=5) {

			act.moveToElement(element, -275 + i, 0).build().perform();
			Thread.sleep(100);
			System.out.println(driver.findElement(By.xpath(tooltip)).getText());
		}

	}
}
