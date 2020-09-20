package com.CamsOnline;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import setup.ExcelUtils;

public class CamsOnlineTradeTest {
	static WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		
	}

	@Test(dataProvider = "customerEntry")
	public void getCamsOnline(String email, String password) throws InterruptedException
	{
		try {
		driver.get("https://new.camsonline.com/Home");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@value = 'ACCEPT']/label/div[1]//input")));
		//driver.findElement(By.xpath("//*[@value = 'ACCEPT']/label/div[1]//input")).click();
		driver.findElement(By.xpath("//input[@value = 'PROCEED']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[contains(text()"
				+ ", 'CAMS+KFintech+FTAMIL')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Confirm Password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[contains(text() , 'Submit')]")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[contains(text()"
					+ ", 'CAMS+KFintech+FTAMIL')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Email']")).sendKeys(email);
			driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Password']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@class = 'mat-form-field-infix']/input[@placeholder = 'Confirm Password']")).sendKeys(password);
			driver.findElement(By.xpath("//*[contains(text() , 'Submit')]")).click();
			
			
		}
		
		
	}
	
	@DataProvider(name = "customerEntry")
	public Object[][] getData() throws IOException
	{
	   	Object[][] dataProviderObj = ExcelUtils.readExcel();
	   	return dataProviderObj;
	}
	
	
}
