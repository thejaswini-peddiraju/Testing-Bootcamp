package com.EasyCal.TestCases;

import org.openqa.selenium.support.PageFactory;

import com.EasyCal.Pages.BaseClass;
import com.EasyCal.Pages.LoginPage;

import utility.ExcelDataReader;

public class LoginEasyCalculation extends BaseClass{
	
	public void loginApp() throws Exception {
		ExcelDataReader excel = new ExcelDataReader();
		excel.getStringData("LoginHRM", 0, 0);
		
		LoginPage loginHRM = PageFactory.initElements(driver, LoginPage.class);
		loginHRM.login_easyCal(excel.getStringData("LoginHRM", 0, 0), excel.getStringData("LoginHRM", 0, 1));
		Thread.sleep(5000);
	}

}
