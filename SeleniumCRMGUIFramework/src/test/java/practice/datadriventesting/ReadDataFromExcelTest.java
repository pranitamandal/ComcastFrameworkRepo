package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1:get the Excel path location & java Object of the physical ExcelFile
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testScriptdata.xlsx");
		
		//step:2 open WorkBook in read Mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		
		//step4:get the control of the "1st" Row
		Row row = sh.getRow(1);
		
		//step5:get the control of the "2nd" shell and read the string data
		String data = row.getCell(3).getStringCellValue();
		
		System.out.println(data);
		
		//step6:close the WorkBook
		wb.close();
		

	}

}
