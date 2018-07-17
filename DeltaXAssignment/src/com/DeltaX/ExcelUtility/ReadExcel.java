package com.DeltaX.ExcelUtility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static XSSFWorkbook wb;

	public static Object[][] readExcel(String filePath) {
		DataFormatter df = new DataFormatter();
		 String[][] dataArray = null;
		 int i=0;
		try {
			File inputFile = new File(filePath);	
			wb = new XSSFWorkbook(new FileInputStream(inputFile));
			XSSFSheet sheet = wb.getSheet("TestData");
			int rowCount=sheet.getLastRowNum();
					int columnCount=sheet.getRow(0).getLastCellNum();		
					Cell cell1;
			
			 
					dataArray=new String[rowCount][columnCount];
		
			  for(int row=1;row<=rowCount;row++) {
			
		   	    for(int cell=0;cell<columnCount;cell++) {
					cell1 = sheet.getRow(row).getCell(cell);
				    String value = df.formatCellValue(cell1);
				    dataArray[i][cell]=value;
						
					}
				i++;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
      return dataArray;
}


}
