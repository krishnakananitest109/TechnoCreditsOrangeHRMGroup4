package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import com.technocredits.orangeHRM.pages.LoginPage;

//Login, Logout ,navigationMenu are common functionalities needed to all so kept in commonTest

public class CommonTest {

	public void login(String username, String password) throws IOException{
		LoginPage loginInstance = LoginPage.getInstance();
		loginInstance.enterValueForLoginPage("usernameTextfield", username);
		loginInstance.enterValueForLoginPage("passwordTextfield", password);
		loginInstance.clickOnLoginPage("loginButton");
	}
	
	
	
}
