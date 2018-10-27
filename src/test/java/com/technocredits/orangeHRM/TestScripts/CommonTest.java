package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.pages.LoginPage;
import com.technocredits.orangeHRM.pages.PIM.PIM_AddEmployeePage;

//Login, Logout ,navigationMenu are common functionalities needed to all so kept in commonTest

public class CommonTest extends PredefinedMethods{

	public void login(String username, String password) throws IOException{
		//calling login page instance
		LoginPage loginInstance = LoginPage.getInstance();
		//passing username value from properties file
		loginInstance.enterValueForLoginPage("usernameTextfield", username);
		//passing password value from properties file
		loginInstance.enterValueForLoginPage("passwordTextfield", password);
		//clicking on login button using xpath from properties file
		loginInstance.clickOnLoginPage("loginButton");
	}
	
	public PIM_AddEmployeePage goto_PIM_addEmployee() throws IOException{
		//calling add employee page instance 
		PIM_AddEmployeePage addEmployeeinstance = PIM_AddEmployeePage.getPIMInstance();
		//navigating to PIM Add employee page
		addEmployeeinstance.goto_PIM_addEmployee();
		return addEmployeeinstance;
	}
	
}
