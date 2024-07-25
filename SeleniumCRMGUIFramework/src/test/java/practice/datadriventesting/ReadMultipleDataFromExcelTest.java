package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		//step1:get the Excel path location & java Object of the physical ExcelFile
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testScriptdata.xlsx");
		
		//step:2 open WorkBook in read Mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("Sheet1");
	int rowcount=sh.getLastRowNum();
		for(int i=1; i<=rowcount;i++){
		Row row = sh.getRow(i);
		String column1data = row.getCell(0).toString();
		String column2data = row.getCell(1).toString();
		
		//stem.out.println(column1data);
		//stem.out.println(column2data);
		System.out.println(column1data +"\t"+column2data);
		}
		wb.close();
		
		
		

	}

}
