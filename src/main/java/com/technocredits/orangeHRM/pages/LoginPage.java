package com.technocredits.orangeHRM.pages;

import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.constant.CONSTANT;
import com.technocredits.orangeHRM.util.PropertyFileReader;

//For 1 Page, one java file:For login: having loginpage.java
//All pages will extend predefinedmethods class to perform selenium activities make sure single object is getting created
//achieved singleton design pattern to 

public class LoginPage extends PredefinedMethods{

	//create properties instance only one-time 
	Properties loginProperties;

	//private constructor: to not to create its object from outside
	private LoginPage() throws IOException{
		//whenever we do login; first our browser will be opened with specified URL
		initialization();
		//whenever we call page; its properties file should be loaded:-	
		PropertyFileReader propRead = new PropertyFileReader();
		loginProperties = propRead.initializePropertyFile(CONSTANT.loginpagePropertyFilePath);
	}
	
	//Private instance : no one can outside access Classname.instanceName.method
	//static : to call it in getInstance Method
	private static LoginPage loginInstance;	
	
	//synchronised: if methods/tests running parallely, multiple objects can be created: to avoid this can add synchronized keyword with method
	public static LoginPage getInstance() throws IOException{
		if(loginInstance == null)
			loginInstance = new LoginPage();
		return loginInstance;
	}
	
	public void enterValueForLoginPage(String locator, String value){
		setText(loginProperties.getProperty(locator), value);
	}
	public void clickOnLoginPage(String locator){
		click(loginProperties.getProperty(locator));
	}
	
}
