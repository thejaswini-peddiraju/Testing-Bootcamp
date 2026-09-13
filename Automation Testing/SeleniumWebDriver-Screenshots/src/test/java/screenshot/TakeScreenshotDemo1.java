package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotDemo1 {

    public static void main(String[] args) throws IOException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/campaign/landing.php");
        driver.manage().window().maximize();

        TakesScreenshot ts =(TakesScreenshot) driver;
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,  new File("./ScreenShots/FacebookHomepage.png"));
		System.out.println("Captured ScreenShot");
		driver.quit();
        
    }
}