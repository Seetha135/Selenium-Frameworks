package KeywordDF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Methods {
	static WebDriver driver;
	
	public static  void openBrowser() {
		 driver= new ChromeDriver();
		}
	
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
		}
	
	public static void implementWait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}	
	
	public static void navigateTo(String baseUrl) {
		
		driver.navigate().to(baseUrl);
	}
	
	public static void enterUName(String value,String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	}

	public static void enterPassword(String value,String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	}
	
	public static void clickSubmit(String value) {
		driver.findElement(By.id(value)).click();
		
	}
	
	public static void verifyMessage(String value,String msg) {
		String expMsg=msg;
		String actMsg=driver.findElement(By.id(value)).getText();
		Assert.assertEquals(actMsg,expMsg);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
}
