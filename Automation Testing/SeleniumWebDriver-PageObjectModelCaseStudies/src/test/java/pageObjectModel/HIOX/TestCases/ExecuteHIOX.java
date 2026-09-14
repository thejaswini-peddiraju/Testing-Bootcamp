package pageObjectModel.HIOX.TestCases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import pageObjectModel.HIOX.Pages.LoginHIOX;

import pageObjectModel.helper.BrowserFactory;

public class ExecuteHIOX {

    @Test
    public void TestValidLogin() {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "Chrome",
                "https://www.login.hiox.com/login?referrer=easycalculation.com");

        LoginHIOX loginPageHIOX =
                PageFactory.initElements(driver, LoginHIOX.class);

        loginPageHIOX.login_HIOX(
                "8074315435",
                "kkirthi@gmail.com");

        //driver.quit();
    }
}