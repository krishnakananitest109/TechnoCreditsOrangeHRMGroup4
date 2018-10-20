package com.technocredits.orangeHRM.pages;

import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class LoginPage extends PredefinedMethods {
	static LoginPage loginpageInstance;
	Properties loginPageProperties;

	// private static LoginPage loginPage = null;

	private LoginPage() {
		initializeBrowser();
		PropertyFileReader propReader = new PropertyFileReader();
		loginPageProperties = propReader.initializePropertyFile("LoginPageProperties");
	}

	public static LoginPage getInstance() {
		if (loginpageInstance == null)
			loginpageInstance = new LoginPage();
		return loginpageInstance;
	}

	public void enterValueForLoginPage(String locator, String value) {
		setText(loginPageProperties.getProperty(locator),value);
	}

	public void clickOnLoginPage(String locator) throws Exception {
		click(loginPageProperties.getProperty("loginbutton"));
	}
}
