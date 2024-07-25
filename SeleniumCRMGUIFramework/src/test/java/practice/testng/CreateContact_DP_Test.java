package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
  @Test(dataProvider="getData")
  public void createContactTest(String firstname, String lastname, long phoneNum) {
	  System.out.println("FirstName:"+firstname+",LastName:"+lastname+",PhoneNum:"+phoneNum);
  }
  
  @DataProvider
  public Object[][]getData(){
	  Object[][]objArr= new Object[3][3];
	  objArr[0][0]="Deep";
	  objArr[0][1]="Hr";
	  objArr[0][2]=1234567890l;
	  
	  
	  objArr[1][0]="Sam";
	  objArr[1][1]="Hd";
	  objArr[1][2]=2345678901l;
	  
	  objArr[2][0]="Jhon";
	  objArr[2][1]="Smith";
	  objArr[2][2]=3456789012l;
	  
	  return objArr;
  }
}
