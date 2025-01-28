package OrangeHRM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity9_emergencyContact {
	
	 static WebDriver driver;
	 static WebDriverWait wait;
	 @BeforeClass
	    public void setUp() {
	        // Initialize driver
	        driver = new FirefoxDriver();	        
	        driver.get("http://alchemy.hguy.co/orangehrm");
	    }	
	 @Test
	 public void loginTest() {
		 WebElement login_UserName = driver.findElement(By.id("txtUsername"));
		 login_UserName.sendKeys("orange");
		 WebElement login_securitykey = driver.findElement(By.id("txtPassword"));
		 login_securitykey.sendKeys("orangepassword123");
		 driver.findElement(By.id("btnLogin")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement login_Success = driver.findElement(By.id("welcome"));		 
		 
	    }
	 @Test(dependsOnMethods = {
			 "loginTest"			 
	 })	 
	 public void emergencyContactTest() {
		 //wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		 driver.findElement(By.linkText("Emergency Contacts")).click();
		 List<WebElement> mobileNumber = driver.findElements(By.xpath("//table/tbody/tr"));
			for(WebElement row : mobileNumber) {
				String number = row.findElement(By.xpath("./td[5]")).getText();
				String name = row.findElement(By.xpath("./td[1]")).getText();
				System.out.print(name);
				System.out.print(number);
				Reporter.log(number);
			}
			System.out.print(" ");
		
		
	 }
	       
	  @AfterClass
	  public void tearDown() {
	   // Close the browser
	     driver.quit();
	    }

}
