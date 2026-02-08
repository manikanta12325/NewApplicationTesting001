package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandlingClass {
	
	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	private DataFormatter formatter;
	
	public ExcelHandlingClass(String filePath,String sheetName)
	{
		formatter = new DataFormatter();
		
		try(FileInputStream file = new FileInputStream(filePath))
		{
			workbook = new XSSFWorkbook(file);
			
		    sheet = workbook.getSheet(sheetName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
			System.out.println("File not found"+e.getMessage());
			
			throw new RuntimeException("File not present the location"+filePath);
		}
	}
	
	public int getNumberOfRows()
	{
		if(sheet == null)
		{
			return 0;
		}
		
		return sheet.getLastRowNum()+1;
	}
	
	public int getNumberOfCells()
	{
		if(sheet ==null) return 0;
		
		XSSFRow row = sheet.getRow(0);
		
		if(row==null) return 0;
		
		return row.getLastCellNum();
	}
	public String getCellData(int rowNumber,int cellNum)
	{
        if(sheet ==null) return null;
		
		XSSFRow row = sheet.getRow(rowNumber);
		
		if(row==null) return null;
		
		XSSFCell cell = row.getCell(cellNum);
		
		if(cell == null) return null;
		
		return formatter.formatCellValue(cell);
	}

}
