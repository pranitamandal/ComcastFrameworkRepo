package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
  @Test(dataProvider="getData")
  public void createContactTest(String firstname,String lastname) {
	  System.out.println("FirstName:"+firstname+",LastName:"+lastname);
  }
  
  @DataProvider
  public Object[][]getData(){
	  Object[][]objArr= new Object[3][2];
	  objArr[0][0]="Deep";
	  objArr[0][1]="Hr";
	  
	  objArr[1][0]="Sam";
	  objArr[1][1]="Hd";
	  
	  objArr[2][0]="Jhon";
	  objArr[2][1]="Smith";
	  return objArr;
  }
}
