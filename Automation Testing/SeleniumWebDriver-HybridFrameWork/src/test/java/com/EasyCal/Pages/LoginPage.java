package com.EasyCal.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "log_email")
    WebElement email;

    @FindBy(id = "log_password")
    WebElement password;

    @FindBy(xpath = "//input[contains(@name,'log_submit')]")
    WebElement loginbtn;

    public void login_easyCal(String uname, String pass) {
        email.sendKeys(uname);
        password.sendKeys(pass);
        loginbtn.click();
    }

    public void tearDown() {
        driver.quit();
    }
}