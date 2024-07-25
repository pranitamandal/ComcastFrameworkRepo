
package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Cell cel = row.createCell(4);
		cel.setCellType(CellType.STRING);
		cel.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testScriptdata.xlsx");
		wb.write(fos);
		System.out.println("=====Executed=====");

	}

}
