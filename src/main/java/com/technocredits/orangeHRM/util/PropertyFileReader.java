package com.technocredits.orangeHRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.technocredits.orangeHRM.constant.CONSTANT;

public class PropertyFileReader {

	public Properties initializePropertyFile(String propFileName) {
			// File file = new File(propFileName.)
			File file = new File(CONSTANT.PROPERTIES + File.separator + propFileName + ".properties");
			Properties prop = null;
			try {
				FileInputStream input = new FileInputStream(file);
				prop = new Properties();
				prop.load(input);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop;
		}
	
	
	

}
