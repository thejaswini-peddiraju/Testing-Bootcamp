package webDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NavigationCommands {
	WebDriver driver;
	
	@Test(priority=0)
	
	public void NavigationDemo() {
		WebDriver driver = new EdgeDriver();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");

        String URL = driver.getCurrentUrl();
        driver.manage().window().maximize();

        
        System.out.println(URL);
        driver.quit();
	}
	
	@Test(priority=1)
	public void NavigateBackDemo() throws Exception {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

        String URL = driver.getCurrentUrl();
        
        System.out.println(URL);
        String Title = driver.getTitle();
        System.out.println(Title);
        driver.navigate().to("https://login.yahoo.com/");
        URL = driver.getCurrentUrl();
        System.out.println(URL);
        Thread.sleep(5000);
        
        driver.navigate().back();
        URL = driver.getCurrentUrl();
        System.out.println(URL);
	}
	
	@Test(priority=2)
	public void NavigateFOrward() throws Exception {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

        String URL = driver.getCurrentUrl();
        
        System.out.println(URL);
        String Title = driver.getTitle();
        System.out.println(Title);
        driver.navigate().to("https://login.yahoo.com/");
        URL = driver.getCurrentUrl();
        System.out.println(URL);
        Thread.sleep(5000);
        
        driver.navigate().back();
        URL = driver.getCurrentUrl();
        System.out.println(URL);
        Thread.sleep(5000);
        driver.navigate().forward();
        URL = driver.getCurrentUrl();
        System.out.println(URL);
	}

}
