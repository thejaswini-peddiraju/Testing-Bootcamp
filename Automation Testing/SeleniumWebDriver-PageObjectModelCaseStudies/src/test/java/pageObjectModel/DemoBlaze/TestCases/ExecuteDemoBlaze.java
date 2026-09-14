package pageObjectModel.DemoBlaze.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectModel.DemoBlaze.Pages.LoginDemoBlaze;
import pageObjectModel.helper.BrowserFactory;

public class ExecuteDemoBlaze {

    @Test
    public void CheckValidUser() throws Exception {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "chrome",
                "https://www.demoblaze.com/index.html"
        );

        LoginDemoBlaze loginPage =
                PageFactory.initElements(driver, LoginDemoBlaze.class);

        loginPage.login_DemoBlaze("testuser", "testpassword");
    }
}