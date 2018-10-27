package com.technocredits.orangeHRM.pages.PIM;

import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.constant.CONSTANT;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class PIM_AddEmployeePage extends PredefinedMethods{
	
	//create properties instance only one-time 
	Properties loginProperties;
	
	private PIM_AddEmployeePage() throws IOException{
		//whenever we call page; its properties file should be loaded:-	
		PropertyFileReader propRead = new PropertyFileReader();
		loginProperties = propRead.initializePropertyFile(CONSTANT.pimAddEmpPropertyFilePath);		
	}
	private static PIM_AddEmployeePage pimInstance;
	
	//method to get instance of PIM Add employee page
	//implemented singleton pattern here
	public static PIM_AddEmployeePage getPIMInstance() throws IOException{
		if(pimInstance == null)
			pimInstance  = new PIM_AddEmployeePage();
		return pimInstance;
	}
	
	//method to return navigate page's URL to verify whether we navigated to correct page
	public String navigateTo_PIM_addEmployee(){
		return getURL();
	}
	
	public void goto_PIM_addEmployee(){
		//click on PIM Add employee page
		expandMenu(loginProperties.getProperty("PIMtitle"));
		click(loginProperties.getProperty("PIMAddEmployeetitle"));
	}
}
