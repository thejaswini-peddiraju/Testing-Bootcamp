package pageObjectModel.JotForm.TestCases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import pageObjectModel.JotForm.Pages.LoginJotForm;

import pageObjectModel.helper.BrowserFactory;

public class ExecuteJotForm {

    @Test
    public void TestValidLogin() {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "Chrome",
                "https://www.jotform.com/login/");

        LoginJotForm loginPageJotForm =
                PageFactory.initElements(driver, LoginJotForm.class);

        loginPageJotForm.login_JotForm(
                "testuser@gmail.com",
                "testpassword");

        //driver.quit();

    }

}