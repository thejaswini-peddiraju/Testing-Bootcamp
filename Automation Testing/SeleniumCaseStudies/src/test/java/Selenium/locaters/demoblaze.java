package Selenium.locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class demoblaze {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		
		
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (WebElement ele : allLinks) {
			System.out.println(ele.isDisplayed());
			System.out.println(ele.isEnabled());
			System.out.println(ele.getAttribute("href"));
		}

        
        WebElement ele = allLinks.get(3);
        ele.click();
        
	}

}
