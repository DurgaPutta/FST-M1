import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}
	@Test
	public void loginButton() {
        WebElement username = driver.findElement(By.id("username"));    	
        WebElement password = driver.findElement(By.id("password"));
        
        // Enter credentials    	
        username.sendKeys("admin");	
        password.sendKeys("password");
        
        // Click login    	
        driver.findElement(By.xpath("//button[text()='Submit']")).click(); 
        String successMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assert.assertEquals("Welcome Back, Admin!", successMessage);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
