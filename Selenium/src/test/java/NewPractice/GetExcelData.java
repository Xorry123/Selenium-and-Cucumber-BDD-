package NewPractice;

import utils.ExcelUtils;

public class GetExcelData {

	
	static String projectPath = System.getProperty("user.dir");
	
	
	public static void main(String[] args) {

		ExcelUtils reader = new ExcelUtils(projectPath + "\\excel\\Data.xlsx", "Login");
		reader.getColumnCount();

	}
	
}
