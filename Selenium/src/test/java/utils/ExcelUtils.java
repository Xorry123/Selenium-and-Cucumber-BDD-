package utils;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {


	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	
	//Constructor to initialize variables during runtime
	public ExcelUtils(String path,String sheetname){
		
		try {
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//************************************************************************************
	// GetRowCount Method
	
	public static int getRowCount() {
		int rowCount =0;
		try {		

			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("Row Count :- " + rowCount);

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		return rowCount;

	}
	
	//************************************************************************************
		// GetColumnCount Method
		
		public static int getColumnCount() {
			int colCount=0;
			try {		

				colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				//System.out.println("Column Count :- " + colCount);

			} catch (Exception e) {
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
			return colCount;

		}
	
//************************************************************************************
	public static String getCellData(int row ,int col) {

		String cellData = null;
		cellData =  sheet.getRow(row).getCell(col).getStringCellValue();
		//System.out.println(cellData);
		return cellData;

	}



}
