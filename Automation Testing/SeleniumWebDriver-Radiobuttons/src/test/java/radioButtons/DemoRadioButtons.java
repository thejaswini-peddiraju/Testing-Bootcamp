package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoRadioButtons {
	
	@Test
	public void TestRadioBtn() throws Exception {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//label[@for='male']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='female']")).click();
		Thread.sleep(5000);
	}

}
