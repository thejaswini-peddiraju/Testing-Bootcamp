package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    // ThreadLocal keeps a separate WebDriver per thread - harmless for a
    // single test run, and keeps this safe if you ever run tests in parallel.
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Returns the current WebDriver, launching Chrome the first time it's called.
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            // Selenium Manager (built into Selenium 4.6+) automatically finds/
            // downloads the matching chromedriver binary - nothing to install.
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    // Closes the browser and clears it so the next scenario starts fresh.
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
