package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    // Path is relative to the project root, where FeaturesFiles/ lives.
    features = "FeaturesFiles",
    // Package(s) Cucumber should scan for step definitions and hooks.
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
