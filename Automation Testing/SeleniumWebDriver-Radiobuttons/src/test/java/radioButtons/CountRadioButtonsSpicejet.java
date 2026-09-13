package radioButtons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CountRadioButtonsSpicejet {
	
	@Test
	public void TestRadioBtn() throws Exception {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		List<WebElement> radioButtons = driver.findElements(
        By.xpath("//input[@type='radio']"));
		
		int count = radioButtons.size();

        System.out.println("Total radio buttons: " + count);
        for (WebElement radio : radioButtons) {

            if (radio.isDisplayed() && radio.isEnabled()) {
                radio.click();
                Thread.sleep(1000);
            }
        }

        driver.quit();
        
	}

}
