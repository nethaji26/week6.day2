package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataForEditLead {

	@Test

	public static String[][] readExcelforEditLead(String filename) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheet = wb.getSheet("EL");
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		System.out.println("The row count is " + rowcount);
		System.out.println("The column count is " + columncount);
		// declaring an array to store the excel values
		String[][] exceldata = new String[rowcount][columncount];
		for (int i = 1; i <= rowcount; i++) {
			// traverse in to each row of excel
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columncount; j++) {
				// traverse in to each column /each cell of excel
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				System.out.println("The excel contents are " + stringCellValue);
				exceldata[i - 1][j] = stringCellValue;
			}
		}

		return exceldata;

	}

}
