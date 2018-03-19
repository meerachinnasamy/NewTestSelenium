package newtest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flipkart {
	
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowserURL() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(newtest.FlipkartElements.baseURL);
		Assert.assertEquals(driver.getCurrentUrl(), newtest.FlipkartElements.baseURL);
		Reporter.log("You are now in Flipkart site");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		}
	
	@Test(priority = 1)
	public void loginFlipkart() throws InterruptedException {
		driver.findElement(By.className(newtest.FlipkartElements.usernameLocator)).sendKeys(newtest.FlipkartElements.username);
		driver.findElement(By.xpath(newtest.FlipkartElements.passwordLocator)).sendKeys(newtest.FlipkartElements.password);
		driver.findElement(By.xpath(newtest.FlipkartElements.submitButtonLocator)).click();
		Thread.sleep(3000);
		boolean myAccountPresence = driver.findElement(By.xpath(newtest.FlipkartElements.myAccountLocator)).isDisplayed();
		Assert.assertEquals(myAccountPresence, true);
		Reporter.log("Login is successful!");
		Reporter.log("Github test successful");
		}
	
	@Test(priority = 2)
	public void searchForProduct() {
		driver.findElement(By.name(newtest.FlipkartElements.searchBoxLocator)).sendKeys(newtest.FlipkartElements.productName);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath(newtest.FlipkartElements.searchButtonLocator)).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String searchResultsText = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div[2]")).getText();
		Assert.assertEquals(searchResultsText.contains(newtest.FlipkartElements.productName),true);
		Reporter.log("Search is successful! You can now select the product");
	}
	
	@Test(priority = 3)
	public void selectProduct() throws InterruptedException {
		driver.findElement(By.xpath(newtest.FlipkartElements.brandLocator)).sendKeys(newtest.FlipkartElements.brandName);
		driver.findElement(By.xpath(newtest.FlipkartElements.brandCheckbox)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(newtest.FlipkartElements.filterLocator)).click();
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath(newtest.FlipkartElements.productLocator)).click();
		Thread.sleep(5000);
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> itr = s1.iterator();
		String childWindow = itr.next();
		childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.xpath(newtest.FlipkartElements.addToCartButtonLocator)).isDisplayed(), true);
		Reporter.log("Product is selected");
	}
	
	@Test(priority = 4)
	public void addToCart() {
		driver.findElement(By.xpath(newtest.FlipkartElements.addToCartButtonLocator)).click();
		Assert.assertEquals(driver.findElement(By.className(newtest.FlipkartElements.myCartEmptyLocator)).getText(), "MY CART (1)");
		Assert.assertEquals(driver.findElement(By.xpath(newtest.FlipkartElements.placeOrderButtonLocator)).isDisplayed(), true);
		Reporter.log("Congrats! Product is successfully added to cart!");
	}
	
	@Test(priority = 5)
	public void removeFromCart() throws InterruptedException {
		driver.findElement(By.className(newtest.FlipkartElements.removeButtonLocator)).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.className(newtest.FlipkartElements.myCartEmptyLocator)).getText(), "MY CART (0)");
		Reporter.log("The cart is now emptied");
	}
	
	@AfterTest
	public void logout() throws InterruptedException {		
		driver.findElement(By.xpath(newtest.FlipkartElements.myAccountLocator)).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath(newtest.FlipkartElements.myProfileLocator)).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(newtest.FlipkartElements.logoutButtonLocator)).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.className(newtest.FlipkartElements.loginBoxLocator)).isDisplayed(), true);
		Reporter.log("Logout is successful!");
		}
	}
	
	

