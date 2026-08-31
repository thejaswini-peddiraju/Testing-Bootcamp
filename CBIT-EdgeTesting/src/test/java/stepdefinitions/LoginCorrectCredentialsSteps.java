package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

import utils.DriverManager;
import utils.TestConfig;

public class LoginCorrectCredentialsSteps {

    private WebDriver driver;

    public LoginCorrectCredentialsSteps() {
        driver = DriverManager.getDriver();
    }

    // Also reused by LogoutUser.feature, since logging in is step one of logging out.
    @When("I enter the registered email address and correct password")
    public void i_enter_registered_email_and_correct_password() {
        driver.findElement(By.cssSelector("input[data-qa='login-email']"))
                .sendKeys(TestConfig.REGISTERED_EMAIL);
        driver.findElement(By.cssSelector("input[data-qa='login-password']"))
                .sendKeys(TestConfig.REGISTERED_PASSWORD);
    }
}
