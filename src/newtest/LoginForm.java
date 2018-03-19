package newtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginForm {
	
		
	// Instantiating browser and URL
	
	public static WebDriver driver;
	@BeforeTest
	public static void openBrowserUrl() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://automationpractice.com/index.php");
	Thread.sleep(1500);
	}
	
	//Navigating to login page
	@Test(priority = 1)
	public static void loginPageHeader() throws InterruptedException
	{
		driver.findElement(By.className("login")).click();
		Thread.sleep(1500);
		String actloginpageheader = driver.findElement(By.className("page-heading")).getText();
		String exploginpageheader = "AUTHENTICATION";
		if (actloginpageheader.equals(exploginpageheader))
		{
			System.out.println("You are now in the login page");
		}
		else
		{
			System.out.println("You are on the wrong page buddy!");
		}
	}
	@AfterTest
	public static void createLogin() throws InterruptedException
	{
		WebElement element;
		
		element = driver.findElement(By.id("email_create"));
		element.sendKeys("mgmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(1500);
		String actloginerror = driver.findElement(By.id("create_account_error")).getText();
		String exploginerror = "Invalid email address.";
		if (actloginerror.equals(exploginerror))
		{
			System.out.println("Invalid email address.Enter proper email!!");
		}
		element.clear();
		element.sendKeys("bgm@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		
		String actformheader = driver.findElement(By.className("page-heading")).getText();
		String expformheader = "CREATE AN ACCOUNT";
		if(actformheader.equals(expformheader))
		{
			System.out.println("Creation of Login is successful!");
		}
		else
		{
			System.out.println("Creation of Login is UNsuccessful!");
		}
		driver.findElement(By.id("uniform-id_gender2")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Harry");
		driver.findElement(By.id("customer_lastname")).sendKeys("Potter");
		driver.findElement(By.id("passwd")).sendKeys("Potter");
		Select daysdropdown = new Select(driver.findElement(By.id("days")));
		daysdropdown.selectByValue("31");
		Select monthdropdown = new Select(driver.findElement(By.id("months")));
		monthdropdown.selectByValue("1");
		Select yeardropdown = new Select(driver.findElement(By.id("years")));
		yeardropdown.selectByVisibleText("1992");
		driver.findElement(By.id("newsletter")).click();
	}
	
/*	public static void main(String[] args) throws InterruptedException {
						
// Instantiating browser and URL
	//	LoginForm.openBrowserUrl();
		
		// Navigating to login page
		LoginForm.loginPageHeader();
		
		// Trying to create new account
		LoginForm.createLogin();
		
	
	}*/

}
