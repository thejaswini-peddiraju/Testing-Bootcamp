package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

import utils.DriverManager;
import utils.TestConfig;

public class LoginIncorrectCredentialsSteps {

    private WebDriver driver;

    public LoginIncorrectCredentialsSteps() {
        driver = DriverManager.getDriver();
    }

    @When("I enter an incorrect email address and password")
    public void i_enter_incorrect_email_and_password() {
        driver.findElement(By.cssSelector("input[data-qa='login-email']"))
                .sendKeys(TestConfig.INVALID_EMAIL);
        driver.findElement(By.cssSelector("input[data-qa='login-password']"))
                .sendKeys(TestConfig.INVALID_PASSWORD);
    }
}
