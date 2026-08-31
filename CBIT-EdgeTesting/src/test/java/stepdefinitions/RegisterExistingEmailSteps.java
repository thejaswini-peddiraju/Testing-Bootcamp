package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

import utils.DriverManager;
import utils.TestConfig;

public class RegisterExistingEmailSteps {

    private WebDriver driver;

    public RegisterExistingEmailSteps() {
        driver = DriverManager.getDriver();
    }

    @When("I enter the already-registered name and email address")
    public void i_enter_already_registered_name_and_email() {
        driver.findElement(By.name("name")).sendKeys(TestConfig.REGISTERED_NAME);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys(TestConfig.REGISTERED_EMAIL);
    }
}
