package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		
		FileInputStream fis= new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
public int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis= new FileInputStream("./testdata/testScriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
}

public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data ) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("./testdata/testScriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
	
	FileOutputStream fos=new FileOutputStream("./testdata/testScriptdata.xlsx");
	wb.write(fos);
	wb.close();
	
}
}
