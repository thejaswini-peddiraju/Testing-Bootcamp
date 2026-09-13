package screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class TestScreenShots1 {
	@Test
	
	public void Browser() throws Exception {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://auth.hollandandbarrett.com/u/login");
        driver.manage().window().maximize();
        
        Reusability.CapturedSCreenShot(driver, "A. LAunch Application - TakeScreenshot");
        
        driver.findElement(By.id("username")).sendKeys("thejaswini@gmail.com");
        driver.findElement(By.id("password")).sendKeys("thejaswini@123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@name='action']")).click();
        
        Reusability.CapturedSCreenShot(driver, "B. Click Sign In Button - TakesScreenShot");
        driver.quit();
        
	}

}
