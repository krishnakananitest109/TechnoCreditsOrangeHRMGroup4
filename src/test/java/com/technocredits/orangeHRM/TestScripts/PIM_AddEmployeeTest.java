package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangeHRM.pages.PIM.PIM_AddEmployeePage;
import com.technocredits.orangeHRM.pages.PIM.PIM_viewPersonalDetails;

public class PIM_AddEmployeeTest extends CommonTest{
	
	@Test
	//this method clicks on PIM - Add Employee
	public void clickPIM() throws IOException{
		//click on login
		login("Admin","admin123");
		System.out.println("Admin successfully Logged in");
		
		//Navigate to PIM_Add_Employee_Page 
		PIM_AddEmployeePage pimAddEmpPageInstance = goto_PIM_addEmployee();
		
		//check whether we have re-directed to the page 
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		String actualUrl = pimAddEmpPageInstance.getURL();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Navigated to PIM - Add Employee Page!");
	}
	
	//@Test
	@Test(dependsOnMethods= { "clickPIM" })
	//this method checks whether field is mandatory of Add Employee From
	public void verifyRequiredField() throws IOException{
	
		//navigate to PIM_
		PIM_AddEmployeePage pimAddEmpPageInstance = goto_PIM_addEmployee();
		
		SoftAssert softAssert = new SoftAssert();
		
		boolean flag = pimAddEmpPageInstance.verifyRequiredFieldOnAddEmpPage("AddEmpFirstName", "");
		//for first name, expected 'Required' should be visible i.e. true for blank 
		//thus used assertTrue
		softAssert.assertTrue(flag);
		
		flag = pimAddEmpPageInstance.verifyRequiredFieldOnAddEmpPage("AddEmpFirstName", "Aakanksha");
		//for first name, expected 'Required' should be visible i.e. true for blank 
		//thus used assertTrue
		softAssert.assertTrue(flag);
	}
	
	@Test(dependsOnMethods= { "clickPIM" })
	//this method provide inputs and add employee
	public void addEmployee() throws IOException{
		
		//Navigate to PIM_Add_Employee_Page 
		PIM_AddEmployeePage pimAddEmpPageInstance = goto_PIM_addEmployee();

		//enter the input fields and click on save to add employee
		//this method returns employee id if the employee gets added in the database
		String generatedEmpID = pimAddEmpPageInstance.addEmployee("Aakanksha", "D", "Deshpande");
		
		//System.out.println("New Employee ID ="+generatedEmpID);
		Assert.assertTrue(generatedEmpID!="0");
		System.out.println("Employee has been added successfully!");
	
		verifyAddedEmpDetails(generatedEmpID);
	}
	
	//after adding employee in the list, this method verified added emp's personal details
	public void verifyAddedEmpDetails(String generatedEmpID) throws IOException{
		//navigate to Personal Details Page
		PIM_viewPersonalDetails pimPerDetailsInstance = goto_PIM_empPerDetails();
		
		//call method to validate next page i.e. Employee personal details
		boolean flag = pimPerDetailsInstance.validatePersonalDetails("Aakanksha", "D", "Deshpande", generatedEmpID);
		Assert.assertTrue(flag);		
		
		System.out.println("Verified the Employee details on Personal Details Page successfully");
	}
	
}