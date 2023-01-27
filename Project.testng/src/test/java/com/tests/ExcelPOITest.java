package com.tests;

import java.util.Arrays;

import com.shams.excel.reader.utilty.Xlsx_Reeader_EAL;

public class ExcelPOITest {

	public static void main(String[] args) {

		
		Xlsx_Reeader_EAL reader = new Xlsx_Reeader_EAL("testdata.xlsx");
		int col = reader.getColumnCount("register");
		System.out.println(col);
		
		String cell = reader.getCellData("register", "firstname", 2);
		System.out.println(cell);
		
		/*reader.addSheet("shams"); 
		you can use it in the similar way with data provider concept . you just have to 
		change sheet name's data accordingly*/
		
		Object data[][] = reader.getSheetData("register");
		System.out.println(Arrays.deepToString(data));
		
		
//		return data;  ( data provider method should return this data) 
	
	}

}
