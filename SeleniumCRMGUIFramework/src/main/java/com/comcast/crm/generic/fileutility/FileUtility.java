package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\SeleniumCRMGUIFramework\\configAppData\\commomdata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		
		return data;
		
		
		
	}

}
