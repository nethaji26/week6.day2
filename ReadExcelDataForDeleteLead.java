package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataForDeleteLead {
	@Test
	
	public static String[][] readDataFromExcelForDeleteLead() throws IOException
	{
		
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/tc002 - Deletelead.xlsx");
		 XSSFSheet sheet = wb.getSheetAt(0);
		 int rowcount = sheet.getLastRowNum();
		 short columncount = sheet.getRow(0).getLastCellNum();
		System.out.println(" The row and column counts are : " +rowcount +" and " + columncount);
		
		String[][] data123 = new String[rowcount][columncount];
		for (int i = 1; i <= rowcount; i++) 
		{
			XSSFRow eachrow = sheet.getRow(i);
			for (int j = 0; j < columncount; j++)
			{
				XSSFCell eachcell = eachrow.getCell(j);
				String stringCellValue = eachcell.getStringCellValue();
				System.out.println("The excel contents are " + stringCellValue);
				data123[i-1][j] =  stringCellValue;
			}
		}
		
		return data123;
	}
}
		
		
		
		
		
		
		
		
		
		
		/*//open the excel
		XSSFWorkbook workbook = new XSSFWorkbook("./data/tc001.xlsx");
		//XSSFWorkbook book = new XSSFWorkbook("./testData/" + excelFileName + ".xlsx"); efficient way of giving path
		//go to first sheet of excel
		XSSFSheet sheet = workbook.getSheetAt(0);
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
			}*/
			
		/*}
		return data;
		
		
		
	}
	
	
	

}
*/