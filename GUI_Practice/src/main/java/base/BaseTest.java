package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	protected String Browser = "Chrome";
	protected String Website = "https://testautomationpractice.blogspot.com/";
	
	
	@BeforeMethod
	public void launchWebsite() {
		if(Browser.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();	
		}
		
		else if(Browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();	
		}
		
		else if(Browser.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		driver.get(Website);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
