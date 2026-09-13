package SeleniumPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserCommands {
	@Test(priority=1)
	public void ChromeBrowserTest() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		driver.quit();
		}
	
	@Test(priority=2)	
	public  void SafariBrowserTest() {
	        ChromeDriver driver = new ChromeDriver();
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        driver.manage().window().maximize();
	        String browserTitle = driver.getTitle();
	        System.out.println(browserTitle);
	        String browserURL = driver.getCurrentUrl();
	        System.out.println(browserURL);
	        driver.quit();
		
	    }
    @Test(priority = 3)
    public void EdgeBrowserTest() {

        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
	    
	}
	@Test(priority=4)
	public void ChromeBrowserTest2() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		driver.quit();
		}
	
	@Test(priority=5)	
	public  void SafariBrowserTest2() {
		ChromeDriver driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/");
	        driver.manage().window().maximize();
	        String browserTitle = driver.getTitle();
	        System.out.println(browserTitle);
	        String browserURL = driver.getCurrentUrl();
	        System.out.println(browserURL);
	        driver.quit();
		
	    }
    @Test(priority = 6)
    public void EdgeBrowserTest2() {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
	    
	}
	@Test(priority=7)
	public void ChromeBrowserTest3() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		driver.quit();
		}
	
	@Test(priority=8)	
	public  void SafariBrowserTest3() {
		ChromeDriver driver = new ChromeDriver();
	        driver.get("https://demoqa.com/");
	        driver.manage().window().maximize();
	        String browserTitle = driver.getTitle();
	        System.out.println(browserTitle);
	        String browserURL = driver.getCurrentUrl();
	        System.out.println(browserURL);
	        driver.quit();
		
	    }
    @Test(priority = 9)
    public void EdgeBrowserTest3() {

        WebDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
	    
	}
    
	@Test(priority=10)
	public void ChromeBrowserTest4() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		driver.quit();
		}
    

}