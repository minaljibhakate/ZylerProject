package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
		
	//Constructor
	public ExcelUtils(String excelPath, String sheetName)
	{
		try {
			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("getMessage"+ e.getMessage());
			System.out.println("getCause" + e.getCause());
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}*/

	public static void getRowCount()
	{
		int rowcnt= sheet.getPhysicalNumberOfRows();
		System.out.println("row count : "+ rowcnt);
	}
	public String getCellDataString(int rowNum, int colNum) 
	{
		String cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println("username cell data : " + cellData);
		return cellData;
	}
	public String getCellDataNumber(int rowNum, int colNum) 
	{
			//getting integer test data into variable 
			int cellDataInteger= (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//converting integer data to string value
			String cellData = String.valueOf(cellDataInteger);
			return cellData;
			//System.out.println("password cell data : " + cellData);
			//return cellDataInteger;
			
	}
}
