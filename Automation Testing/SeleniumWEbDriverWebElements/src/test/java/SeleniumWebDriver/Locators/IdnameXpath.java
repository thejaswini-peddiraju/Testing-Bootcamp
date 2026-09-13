package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IdnameXpath {
	WebDriver driver;
	int Total =0;
	@BeforeTest
	public void setUp() throws Exception {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/");
		Thread.sleep(10000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookie popup not displayed.");
		}
	}
	@Test
	public void findElementByLinkTest() throws Exception {
		
		driver.findElement(By.linkText("Vitamins & Supplements")).click();
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int linkCount = links.size();
		Total = Total + links.size();
        
		System.out.println("Number of Links:" + linkCount);
		for (int i = 1; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}
	
        

    @AfterTest
    public void tearDown() {
    	driver.quit();
        

	
	
	}

}
