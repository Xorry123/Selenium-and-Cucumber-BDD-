package NewPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTables {

	static WebDriver driver;
	String URL = "https://demo.opencart.com/admin/index.php";

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

	@Test
	public void TestWebTables() {
		
		WebElement username = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
		password.clear();
		password.sendKeys("demo");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		loginButton.click();
		
		//sales clicking
		driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a")).click();;
		
		driver.findElement(By.partialLinkText("Order")).click();
		
		//Table:- 
		
		String tabletext = driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText();
		//System.out.println(tabletext);
		int totalpages = Integer.valueOf(tabletext.substring(tabletext.indexOf("(")+1, tabletext.indexOf("Pages")-1));
	
		System.out.println("Toatl pages :- "+totalpages);	
		
		
		
		
		
		
		
		
		for(int i=1;i<2;i++) {
			WebElement activepage = driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li/span"));
			System.out.println("Active page:-" +activepage.getText());
			activepage.click();
			
			int totalrows_activepage = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr")).size();
			System.out.println("Total rows on active page: "+totalrows_activepage);	
			
			
			
			int orderID= getColumnIndex("Order ID");
			int status= getColumnIndex("Status");
			
			System.out.println("OrdrID:- "+orderID + "	Status:- "+status );
			
			for(int k=1;k<=totalrows_activepage;k++) {

				String rowID = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr["+k+"]//td["+orderID+"]")).getText();
				String rowstatus = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr["+k+"]//td["+status+"]")).getText();
				System.out.println(rowID+"	"+rowstatus);
			}
			
			//table[@class="table table-bordered table-hover"]//tbody//tr[1]//td[2]
			
			
			
			
			String pageno = Integer.toString(i+1);
			driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()='"+pageno+"']")).click();
			
			
		}
		
		
		
		
		
				
		
		
		
		
	}
	
	public static int getColumnIndex(String colname) {
		//get columns header
		int j;
		int cols  = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//thead//tr//td")).size();
		
		for(j=1;j<=cols;j++) {
			String colheader= driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]//thead//tr//td" + "["+j+"]")).getText();
			if (colname.equalsIgnoreCase(colheader)) {
				System.out.println(colheader);
				break;
			}
			
		}
		
		
		return j;
		
	}

}
