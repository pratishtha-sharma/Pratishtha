package Library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {

	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public ExcelDataConfig(String excelPath)
	{
		try {
			File src = new File(excelPath);

			FileInputStream fis = new FileInputStream(src);
			
			//workbook object
			wb = new HSSFWorkbook(fis);
			
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public String getData(int sheetNumber, int row, int column)
	{
		//sheet object
		sheet = wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	
	
	
	
}
