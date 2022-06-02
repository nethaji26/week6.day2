package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	@Test
	
	public static String[][] readDataFromExcel(String excelfileName)  throws IOException
	{
		//open the excel
		//XSSFWorkbook workbook = new XSSFWorkbook("./data/tc001.xlsx");
		XSSFWorkbook book = new XSSFWorkbook("./data/" + excelfileName + ".xlsx"); //efficient way of giving path
		//go to first sheet of excel
		XSSFSheet sheet = book.getSheetAt(0);
		//getting last row num
		int rowcount = sheet.getLastRowNum();
		System.out.println("The last row number is " + rowcount);
		 XSSFRow headerrow = sheet.getRow(0);
		 int colcount = headerrow.getLastCellNum();
		 System.out.println("The column count is " + colcount);
		 
		// For storing and sending data to dataProvider, creating 2D array
			String[][] data = new String[rowcount][colcount];
			
		 for (int i = 1; i <= rowcount; i++) 
		 {
			 
			 XSSFRow eachrow = sheet.getRow(i);
			 
			 for (int j = 0; j < colcount; j++)
			 {
				 
				 XSSFCell eachcell = eachrow.getCell(j);
				 String datafromeachcell = eachcell.getStringCellValue();
				System.out.println(datafromeachcell);
				data[i-1][j] = datafromeachcell;
			}
			
		}
		return data;
		
		
		
	}
	
	
	

}
