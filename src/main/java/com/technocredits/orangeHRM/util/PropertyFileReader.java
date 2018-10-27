package com.technocredits.orangeHRM.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	Properties prop = null;
	
	public Properties initializePropertyFile(String propFileName) throws IOException{
		FileInputStream fis = new FileInputStream(new File(propFileName+".properties"));
		prop = new Properties();
		prop.load(fis);
		
		return prop;
	}
	
}
