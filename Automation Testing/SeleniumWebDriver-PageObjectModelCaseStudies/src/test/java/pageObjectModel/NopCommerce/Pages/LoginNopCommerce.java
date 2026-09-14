package pageObjectModel.NopCommerce.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginNopCommerce {

    WebDriver driver;

    public LoginNopCommerce(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(xpath="//button[contains(text(),'Log in')]")
    WebElement loginbtn;

    public void login_NopCommerce(String uname, String pass) {

        email.sendKeys(uname);

        password.sendKeys(pass);

        loginbtn.click();

    }

}