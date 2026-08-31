package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;

import utils.DriverManager;

public class LogoutUserSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutUserSteps() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("I should be navigated to the login page")
    public void i_should_be_navigated_to_login_page() {
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Expected to be redirected to the login page after logout");
    }
}
