package lab_5;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_5 {
	
	WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
				
		String baseURL = "https://www.google.com/";
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); // cài max thời gian load được hướng dẫn trên udemy
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // cài thời gian chờ để cho web element load
		driver.navigate().to(baseURL);
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void TC001() throws InterruptedException {
		
		
			
		driver.findElement(By.xpath("//input[@title='Tìm kiếm']")).sendKeys("selenium");
		
	
		//WebDriverWait wait = new WebDriverWait(driver, 15); selenium 4 khong xai syntax nay
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); // selenium 4 xai syntax nay
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Tìm trên Google']")));
		
		
		driver.findElement(By.xpath("//input[@value='Tìm trên Google']")).click();
		
		
		
	}
	
	
}
