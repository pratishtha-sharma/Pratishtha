package dataExcelDriven;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class dataDriven {
	
	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("C://Users//admin//Documents//Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int noOfSheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<noOfSheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testData")) { //sheetname
				XSSFSheet sheet = workbook.getSheetAt(i);
				//first iterate in row then iterate in cell
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next(); //comes to the first row of sheet
				Iterator<Cell> cell = firstRow.cellIterator(); //this will give the cell value by iterating via each cell
				
				int count = 0;
				int colmVal = 0;
				while(cell.hasNext()) { //to check if next is present
					Cell value1 = cell.next();
					
					if(value1.getStringCellValue().equalsIgnoreCase("TestCase")) {
						//if value found then grab that
						colmVal = count;
					}
					count++;
				}
				System.out.println(colmVal);
				
				//once column is identified then we will scan the entire column to identify purchase testcase row
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(colmVal).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						//get all the cell values for that row
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							Cell value2 = cv.next();
							
							if(value2.getCellType()== CellType.STRING) {
								a.add(value2.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(value2.getNumericCellValue()));
								
							}
							
							
							
						}
					}
				}

			}
		}
		
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		


	}

}
