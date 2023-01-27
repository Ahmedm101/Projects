package FacebookTestNG;

import org.testng.annotations.Test;

import com.shams.excel.reader.utilty.Xlsx_Reeader_EAL;

import FacebookPOM.FacebookHomepage;
import Utilities_pack.Utilities;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class FacebookSignInTest extends Utilities{
  @Test(dataProvider = "Signup")                             // same like groups, priority we can use with comma
  public void FbSignUp(String email , String password) throws InterruptedException {
	  
	  FacebookHomepage ob=new FacebookHomepage(driver);
	  ob.email(email);
	  ob.pass(password);
	  ob.loginbtnclick();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(4000);
	 
  }

  @DataProvider(name="Signup")
  public Object[][] SignUpData() {     //object is the return type, dp is the method name 
	  String UD = System.getProperty("user.dir");
   String ExcelFilePath =UD+"\\TestData\\testdata.xlsx";
   
   Xlsx_Reeader_EAL reader = new Xlsx_Reeader_EAL(ExcelFilePath);
  
   int RowCount = reader.getRowCount("fb");
  System.out.println(RowCount);
  
  int ColumnCount = reader.getColumnCount("fb");
  System.out.println(ColumnCount);
  
  Object[][] data= reader.getSheetData("fb");
  System.err.println(Arrays.deepToString(data));
  return data;
   
  }
}
