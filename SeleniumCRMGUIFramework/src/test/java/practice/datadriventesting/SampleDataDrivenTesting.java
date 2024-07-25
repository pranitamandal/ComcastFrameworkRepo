package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		// step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Bijay\\Desktop\\commomdata.properties");
		//step2:using properties class,load all the keys
		Properties pobj= new Properties();
		pobj.load(fis);
		
		//step3:get the value based on key
		System.out.println(pobj.getProperty("password"));

	}

}
