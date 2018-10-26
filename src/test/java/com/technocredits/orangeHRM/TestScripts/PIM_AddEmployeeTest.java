package com.technocredits.orangeHRM.TestScripts;

import java.io.IOException;
import org.testng.annotations.Test;

import com.technocredits.orangeHRM.pages.PIM.PIM_AddEmployeePage;

import junit.framework.Assert;

public class PIM_AddEmployeeTest extends CommonTest{

	@Test
	public void clickPIM() throws IOException{
		login("Admin","admin123");
		System.out.println("Admin successfully Logged in");
		
		//navigate menu
		PIM_AddEmployeePage pimAddEmpPageInstance = goto_PIM_addEmployee();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		String actualUrl = pimAddEmpPageInstance.getURL();
		Assert.assertEquals(expectedUrl, actualUrl);
		
	}
}
