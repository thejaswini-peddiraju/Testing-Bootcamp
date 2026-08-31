package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // Runs before every scenario: launches Chrome and opens the site.
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() {
        // Runs after every scenario, pass or fail: closes the browser.
        DriverManager.quitDriver();
    }
}
