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

public class ExcelSample {

	public void commonCTSLoginFunction ()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		
		
		try {
		FileInputStream file = new FileInputStream("D:\\Selenium Class\\Assignments\\commonLogin.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Cognizant");
				
//		for (int i=1; i<=sh.getLastRowNum(); i++ )
//		{
//			for (int j=0; j<= sh.getRow(i).getLastCellNum(); j++ )
//			{
//				String URL = sh.getRow(i).getCell(j).getStringCellValue();
//				driver.get(URL);
//			}	
//		}
			
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
				
				String passwordxpath = sh.getRow(i).getCell(3).getStringCellValue();
				String password = sh.getRow(i).getCell(4).getStringCellValue();
				driver.findElement(By.xpath(passwordxpath)).sendKeys(password);
				
				String buttonxpath = sh.getRow(i).getCell(5).getStringCellValue();
				driver.findElement(By.xpath(buttonxpath)).click();
				Thread.sleep(3000);
				driver.close();
		    }
							
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
		
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
				driver.close();
		    }
							
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	

	/*public void openBrowserURL ()
	{
		try {

		FileInputStream file = new FileInputStream("D:\\Selenium Class\\Assignments\\sample excel.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c = sh.getRow(0).getCell(0);
		String url = c.getStringCellValue();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Class\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}*/
	
	public static void main(String[] args) {
	
		ExcelSample obj = new ExcelSample();
		//obj.openBrowserURL();
			obj.commonCTSLoginFunction();
		obj.commonAmazonGmailLoginFunction();		
	
	}}
