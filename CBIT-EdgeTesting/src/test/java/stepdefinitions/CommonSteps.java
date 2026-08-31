package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.DriverManager;

// Steps shared by ALL five feature files live here so each is defined only
// once. (Cucumber throws a "duplicate step definition" error if the exact
// same step text is matched by methods in two different classes.)
public class CommonSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonSteps() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the Automation Exercise home page")
    public void i_am_on_the_home_page() {
        // Hooks.setUp() already navigated here before this scenario started.
    }

    @Then("the home page should be visible successfully")
    public void the_home_page_should_be_visible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[@alt='Website for automation practice']")));
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),
                "Home page title did not contain 'Automation Exercise'");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        switch (buttonName) {
            case "Signup / Login":
                driver.findElement(By.linkText("Signup / Login")).click();
                break;
            case "Signup":
                driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
                break;
            case "Login":
                driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
                break;
            case "Create Account":
                driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
                break;
            case "Continue":
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a[data-qa='continue-button']"))).click();
                break;
            case "Delete Account":
                driver.findElement(By.linkText("Delete Account")).click();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkName) {
        driver.findElement(By.linkText(linkName)).click();
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedText) {
        By locator = By.xpath("//*[contains(normalize-space(text()),'" + expectedText + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertTrue(driver.findElements(locator).size() > 0,
                "Expected text not found on page: " + expectedText);
    }
}
