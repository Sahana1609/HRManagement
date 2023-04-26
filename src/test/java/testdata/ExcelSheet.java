package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {

	public static Workbook book;
	public static Sheet sheet;
	private static Object[][] data;

	public static Object[][] readdata(String Sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\SHEGDE\\SAHANA\\CourseQA\\HRManagement\\src\\test\\java\\testdata\\Details.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file); // HSSF XSSF
			sheet = book.getSheet(Sheetname);
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			int cellcount = sheet.getRow(0).getLastCellNum();
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < cellcount; j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} 
		catch (IOException a) {
			a.printStackTrace();
		}
		return data;
	}
}
