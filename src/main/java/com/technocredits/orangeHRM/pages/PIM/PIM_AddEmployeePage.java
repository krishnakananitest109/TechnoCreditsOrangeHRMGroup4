package com.technocredits.orangeHRM.pages.PIM;

import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.constant.CONSTANT;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class PIM_AddEmployeePage extends PredefinedMethods{
	
	//create properties instance only one-time 
	Properties pimPageProperties;
	
	private PIM_AddEmployeePage() throws IOException{
		//whenever we call page; its properties file should be loaded:-	
		PropertyFileReader propRead = new PropertyFileReader();
		pimPageProperties = propRead.initializePropertyFile(CONSTANT.pimAddEmpPropertyFilePath);		
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
		expandMenu(pimPageProperties.getProperty("PIMtitle"));
		click(pimPageProperties.getProperty("PIMAddEmployeetitle"));
	}
	
	//call a method which passes form fields parameters and click on save
	public String addEmployee(String fName, String midName, String lName){
		
		//send the fields inputs in the form
		setText(pimPageProperties.getProperty("AddEmpFirstName"),fName);
		setText(pimPageProperties.getProperty("AddEmpMiddleName"),midName);
		setText(pimPageProperties.getProperty("AddEmpLastName"),lName);
			
		//store emp id
		String EmpID = getAttributeValue(pimPageProperties.getProperty("AddEmpEmpID"));
		
		//click on Save Button
		click(pimPageProperties.getProperty("AddEmpSaveButton"));
		
		//check whether employee has been added and we navigate to the next page
		if(getURL().contains("https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/"+EmpID)){
			//System.out.println("New Employee has been successfully added");
			//it successfully added new employee and hence will return employee id
			return EmpID;
		}
		else
			return "0";
		
	}
	
	//this method checks whether field on Add Employee Page is mandatory(*)
	public boolean verifyRequiredFieldOnAddEmpPage(String field, String inputValue){
		//fetch locator value for the given field from properties
		String locator = pimPageProperties.getProperty(field);
		setText(locator, inputValue);
		
		//set locator error : 'required'
		//String locator_error = pimPageProperties.getProperty(field+"Error")
		
		//click on save button 
		click(pimPageProperties.getProperty("AddEmpSaveButton"));
		
		//it will return that error is visible or not : displayed it means it is mandatory field
		//field_error : required's xpath is mentioned in the properties file which is present for mandatory fields
		return verifyElementToBeVisible(pimPageProperties.getProperty(field+"Error"));
		
	}
	
}
