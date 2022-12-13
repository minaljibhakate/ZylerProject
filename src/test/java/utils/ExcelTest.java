package utils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelTest {
	
	public static void main(String[] args) {
		
		//String dataExcelPath = System.getProperty("user.dir");
		
		//ExcelUtils excel = new ExcelUtils(dataExcelPath+"/TestDataExcel/TestData.xlsx", "Customer");
		
		//excel.getRowCount();
		//excel.getCellDataNumber(1, 1);
		//excel.getCellDataString(0, 0);
		
//		int cellDataInteger= 1000;
//		//converting integer data to string value
//		String cellData = String.valueOf(cellDataInteger);
//		System.out.println("string value of cellDataInteger: " + cellData);
		
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("MMMM dd, yyyy");
		String stringDate= DateFor.format(date);
		System.out.println(stringDate);

		String expSuccessMSg="Successfully Applied";
		String actaulmsg="Successfully Applied 0.5 days Leave for";

		System.out.println("msg:"+actaulmsg.contains(expSuccessMSg));
		System.out.println("=========================================");
		
        
        
        for(int i=0 ; i<5; i++)
        	System.out.println(i);
	}
}
