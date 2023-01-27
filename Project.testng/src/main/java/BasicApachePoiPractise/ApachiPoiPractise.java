package BasicApachePoiPractise;

import java.util.Arrays;

import com.shams.excel.reader.utilty.Xlsx_Reeader_EAL;

public class ApachiPoiPractise {

	public static void main(String[] args) {
		 
		String ExcelFilePath ="C:\\Users\\malih\\git\\repository3\\Project.testng\\TestData\\testdata.xlsx";
		
		Xlsx_Reeader_EAL reader = new Xlsx_Reeader_EAL(ExcelFilePath);
		
		// how many row
	   int rowcount =	reader.getRowCount("register");
		System.out.println(rowcount);
		
		//how many column
	  int coloumncount =	reader.getColumnCount("register");
	  System.out.println(coloumncount);
	  
	  //get all data 
	Object data[][] =  reader.getSheetData("register");
	System.out.println(Arrays.deepToString(data));
		
	}

}
