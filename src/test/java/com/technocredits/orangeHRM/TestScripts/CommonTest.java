package com.technocredits.orangeHRM.TestScripts;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.pages.LoginPage;

public class CommonTest extends PredefinedMethods {
	public void login(String username, String password) throws Exception {
		LoginPage loginpageInstance = LoginPage.getInstance();
		loginpageInstance.enterValueForLoginPage("UserName", username);
		loginpageInstance.enterValueForLoginPage("Password", password);
		loginpageInstance.clickOnLoginPage("loginbutton");
	}

}
