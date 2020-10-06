package DataDrivenFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class DDF {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		
		//driver.manage().deleteAllCookies();* to delete the cookies
		
	}
	
	@Test
	public void testApp() throws IOException
	{
		
		String[][] data=ReadExcel.getData("TestData.xlsx", "Sheet1");
		
		for(int i=1;i<data.length;i++) {
			
		String username=data[i][0];
		String password=data[i][1];
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		String expMsg="Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.";
		String actMsg=driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p > font")).getText();
		Assert.assertEquals(actMsg, expMsg);
		
		driver.navigate().back();
	}

}
	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
	}
}
