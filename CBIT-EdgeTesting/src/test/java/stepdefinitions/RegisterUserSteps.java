package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import utils.DriverManager;

public class RegisterUserSteps {

    private WebDriver driver;

    // ====================== CONFIGURATION ======================
    // A fresh, unique email is generated every run (timestamp-based) so this
    // test can be re-run repeatedly without an "email already exists" error.
    // This is a throwaway account that the scenario deletes at the end.
    // =============================================================
    private static final String NEW_USER_NAME = "Test User";
    private static final String NEW_USER_PASSWORD = "Test@1234";

    public RegisterUserSteps() {
        driver = DriverManager.getDriver();
    }

    @When("I enter a unique name and email address")
    public void i_enter_unique_name_and_email() {
        String uniqueEmail = "testuser" + System.currentTimeMillis() + "@example.com";
        driver.findElement(By.name("name")).sendKeys(NEW_USER_NAME);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(uniqueEmail);
    }

    @When("I fill in the account information details")
    public void i_fill_in_account_information_details() {
        driver.findElement(By.id("id_gender1")).click(); // "Mr" title
        driver.findElement(By.cssSelector("input[data-qa='password']")).sendKeys(NEW_USER_PASSWORD);

        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("May");
        new Select(driver.findElement(By.id("years"))).selectByValue("1995");
    }

    @And("I check the {string} checkbox")
    public void i_check_the_checkbox(String checkboxLabel) {
        if (checkboxLabel.equals("Sign up for our newsletter!")) {
            driver.findElement(By.id("newsletter")).click();
        } else if (checkboxLabel.equals("Receive special offers from our partners!")) {
            driver.findElement(By.id("optin")).click();
        }
    }

    @And("I fill in the address information details")
    public void i_fill_in_address_information_details() {
        driver.findElement(By.cssSelector("input[data-qa='first_name']")).sendKeys("Test");
        driver.findElement(By.cssSelector("input[data-qa='last_name']")).sendKeys("User");
        driver.findElement(By.cssSelector("input[data-qa='company']")).sendKeys("CBIT");
        driver.findElement(By.cssSelector("input[data-qa='address']")).sendKeys("123 Test Street");
        driver.findElement(By.cssSelector("input[data-qa='address2']")).sendKeys("Near Test Landmark");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
        driver.findElement(By.cssSelector("input[data-qa='state']")).sendKeys("Telangana");
        driver.findElement(By.cssSelector("input[data-qa='city']")).sendKeys("Hyderabad");
        driver.findElement(By.cssSelector("input[data-qa='zipcode']")).sendKeys("500001");
        driver.findElement(By.cssSelector("input[data-qa='mobile_number']")).sendKeys("9999999999");
    }
}
