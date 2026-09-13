package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {
	
	public static void CapturedSCreenShot(WebDriver driver, String ScreenShotName) {
		try {
	           TakesScreenshot ts =(TakesScreenshot) driver;
	           File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	           FileUtils.copyFile(source,  new File("./ScreenShots/"+ ScreenShotName+".png"));
	           System.out.println("Captured ScreenShot - By Selenium Webdriver");
		} catch (Exception e) {
			System.out.println("Exception While Taking Screen Shot " + e.getMessage());
		}
	
	}
}
