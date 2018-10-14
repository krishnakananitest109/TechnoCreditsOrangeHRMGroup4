package com.technocredits.orangeHRM.pages;

public class LoginPage {

	private static LoginPage loginPage;

	private LoginPage() {

	}

	public static LoginPage getInstance() {
		if (loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}

	public void enterValueForLoginPage(String locator, String value) {

	}

}
