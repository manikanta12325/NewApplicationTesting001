package UtilityPackage;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {
	
	private static final String filePath = System.getProperty("user.dir")+"/TestData/TestDataOrangeHRM.xlsx";
	
	private static final String sheetName = "Sheet1";
	
	@DataProvider(name = "login data")
	public Object[][] assignData()
	{
		ExcelHandlingClass excel = new ExcelHandlingClass(filePath,sheetName);
		
		int totalRows = excel.getNumberOfRows();
		
		int totalCells = excel.getNumberOfCells();
		
		int totalArray = totalRows-1;
		
		Object arr[][] = new Object[totalArray][totalCells];
		
		for(int i=1;i<=totalArray;i++)
		{
			for(int j=0;j<totalCells;j++)
			{
				arr[i-1][j] = excel.getCellData(i, j);
			}
		}
		
		return arr;
	}

}
