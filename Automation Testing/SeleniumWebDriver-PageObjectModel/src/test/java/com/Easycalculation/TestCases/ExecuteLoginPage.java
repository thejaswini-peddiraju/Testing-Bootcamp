package com.Easycalculation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Easycalculation.pages.LoginEasyCal;

import Helper.BrowserFactory;

public class ExecuteLoginPage {
	@Test
	public void TestValidLogin() {
		WebDriver driver=BrowserFactory.startBrowser("Chrome",
				"https://www.login.hiox.com/login?referrer=easycalculation.com");
		LoginEasyCal loginPageEasyCal = PageFactory.initElements(driver,LoginEasyCal.class);
		loginPageEasyCal.login_EasyCal("8074315435", "kkirthi@gmail.com");
		//driver.quit();
	}

}
