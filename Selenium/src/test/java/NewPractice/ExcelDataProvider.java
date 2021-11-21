package NewPractice;

import org.apache.commons.collections4.Get;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class ExcelDataProvider {

	static String projectPath = System.getProperty("user.dir")+ "\\excel\\Data.xlsx";;
	
	
	@Test(dataProvider = "Sample")	
	public void test(String empID,String name,String company) {
		System.out.println(empID + " " + name + " " + company);
		
		
	}
	
	@DataProvider(name = "Sample")
	public static Object[][] getData() {
		Object [][] data = testData(projectPath, "Login");
		return data;
	}
	
	
	public static Object[][] testData(String path,String sheetname) {
		ExcelUtils excel = new ExcelUtils(path, sheetname);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		
		Object [][] data = new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				
				String cellData = excel.getCellData(i, j);
				//System.out.println(cellData);
				data[i-1][j] = cellData;
					
			}
			//System.out.println("*****************************");
		}
		return data;
	}
	
	
}
