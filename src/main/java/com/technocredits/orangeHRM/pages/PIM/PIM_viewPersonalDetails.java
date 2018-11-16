package com.technocredits.orangeHRM.pages.PIM;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.google.common.base.Verify;
import com.technocredits.orangeHRM.base.PredefinedMethods;
import com.technocredits.orangeHRM.constant.CONSTANT;
import com.technocredits.orangeHRM.util.PropertyFileReader;

public class PIM_viewPersonalDetails extends PredefinedMethods{
	
	Properties personalDetailsPageProperties;
	
	//private constructor
	private PIM_viewPersonalDetails() throws IOException{
		//whenever we call page; its properties file should be loaded:-	
		PropertyFileReader propRead = new PropertyFileReader();
		personalDetailsPageProperties = propRead.initializePropertyFile(CONSTANT.pimPersonalDetailsropertyFilePath);
	};
	
	//private instance
	private static PIM_viewPersonalDetails personalDetailsInstance;
	
	//method which returns this page instance
	public static PIM_viewPersonalDetails getPerDetailsInstance() throws IOException{
		if(personalDetailsInstance == null)
			personalDetailsInstance = new PIM_viewPersonalDetails();
		return personalDetailsInstance;
	}
	
	
	//verify the personal details entered after adding employee
	public boolean validatePersonalDetails(String fName, String mName, String lName, String expectedEmpid){
		String addedEmpFName = getAttributeValue(personalDetailsPageProperties.getProperty("PersonalDetailsFName"));
		String addedEmpMName = getAttributeValue(personalDetailsPageProperties.getProperty("PersonalDetailsMName"));
		String addedEmpLName = getAttributeValue(personalDetailsPageProperties.getProperty("PersonalDetailsLName"));
		String addedEmpEmpId = getAttributeValue(personalDetailsPageProperties.getProperty("PersonalDetailsEmpId"));
		
		if(addedEmpFName.equals(fName))
			if(addedEmpMName.equals(mName))
				if(addedEmpLName.equals(lName))
					//return true;
					if(addedEmpEmpId.equals(expectedEmpid))
						return true;
					else{
						System.out.println("Emp ID is not as expected");
						return false;
					}
				else{
					System.out.println("Employee Last Name is not as expected");
					return false;
				}
			else{
				System.out.println("Emp Middle Name is not as expected.");
				return false;
			}
		else{
			System.out.println("Emp Last Name is not as expected.");
			return false;
		}
	}
	
	
}
