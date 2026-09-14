package pageObjectModel.HIOX.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginHIOX {

    WebDriver driver;

    public LoginHIOX(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(id="log_email")
    WebElement email;

    @FindBy(name="log_password")
    WebElement password;

    @FindBy(xpath="//input[@value='Login']")
    WebElement loginbtn;

    public void login_HIOX(String uname, String pass) {

        email.sendKeys(uname);

        password.sendKeys(pass);

        loginbtn.click();

    }

}