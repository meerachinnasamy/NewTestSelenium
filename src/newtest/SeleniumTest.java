package newtest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumTest {
	
	static Logger log = Logger.getLogger(SeleniumTest.class.getName());
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver.get("https://www.amazon.in");
		String expurl = "https://www.amazon.in/";
		driver.navigate().to(expurl);
		Thread.sleep(3000);
		
			
		/*driver.findElement(By.partialLinkText("See all")).click();
		Thread.sleep(3000);
		*/
			
		/*WebElement element;
		element = driver.findElement(By.id("staticImage"));
		element.click();
		
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		driver.findElement(By.id("hplogo")).click();
		driver.findElement(By.name("btnK")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		int length = url.length();
		System.out.println("The length is :" +length);
		System.out.println(url);
		if (url.equals(expurl))
		{
			System.out.println("The expected uRl matches with Actual URL");
		}
		else
		{
			System.out.println("The expected uRl DOES NOT match with Actual URL");
		}
		driver.quit();*/
	}

}
