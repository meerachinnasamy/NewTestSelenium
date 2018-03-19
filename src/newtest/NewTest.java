package newtest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("TestNG test");
	  Reporter.log("TestNG test");
	  }
  
  @Test 
  public void commonAmazonGmailLoginFunction()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
			
		try {
		FileInputStream file = new FileInputStream("D:\\Selenium Class\\Assignments\\commonLogin.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Amazon_Gmail");
	    for (int i=1; i<=sh.getLastRowNum(); i++ )
		    {
		    	WebDriver driver = new ChromeDriver();
		    	String URL = sh.getRow(i).getCell(0).getStringCellValue();
				driver.get(URL);
				driver.manage().window().maximize();
				
				DataFormatter format = new DataFormatter();
				Cell usernamecell = sh.getRow(i).getCell(2);
				String usernamexpath = sh.getRow(i).getCell(1).getStringCellValue();
				String username = format.formatCellValue(usernamecell);
				driver.findElement(By.xpath(usernamexpath)).sendKeys(username);
				
				String nextbuttonxpath = sh.getRow(i).getCell(3).getStringCellValue();
				driver.findElement(By.xpath(nextbuttonxpath)).click();
				Thread.sleep(3000);
				
				String passwordxpath = sh.getRow(i).getCell(4).getStringCellValue();
				String password = sh.getRow(i).getCell(5).getStringCellValue();
				driver.findElement(By.xpath(passwordxpath)).sendKeys(password);
				
				String submitbuttonxpath = sh.getRow(i).getCell(6).getStringCellValue();
				driver.findElement(By.xpath(submitbuttonxpath)).click();
				Thread.sleep(2000);
				
				Reporter.log("Login successful");
				
				driver.close();
		    }
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
  
  
  
  }
