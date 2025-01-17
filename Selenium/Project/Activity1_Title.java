package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1_Title {
	
	 WebDriver driver;
	 @BeforeClass
	    public void setUp() {
	        // Initialize driver
	        driver = new FirefoxDriver();	        
	        
	        driver.get("http://alchemy.hguy.co/orangehrm");
	    }
	 
	 @Test
	 public void TitleTest() {		 
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");      
	    }
	       
	 @AfterClass
	 public void tearDown() {
	   // Close the browser
	     driver.quit();
	    }

}
