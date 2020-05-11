/**
 * 
 */
package com.illumy.qa.util;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileNotFoundException;

/**
 * @author thambibabu.dasari
 *
 */
public class ExcelFileUtil {

Workbook wb;
	
	//constructor to get the excel sheet
	public ExcelFileUtil() throws Throwable
	{
		FileInputStream fis=new FileInputStream("D:\\Gmail Test Cases\\Gmail Scripts\\Gmail Test Cases\\test-input\\Input Sheet.xlsx");
		
		wb=WorkbookFactory.create(fis);
	}
	
	//method for to get row count
	public int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	//method for to get column count
	public int colCount(String sheetName,int rowNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
	}
	
	//method for to get data from excel 
	public String getData(String sheetName,int rowNum,int colNum)
	{
		String data=" ";
		
		if(wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType()==CellType.NUMERIC)
		{
			int celldata=(int)wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		
		if(wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType()==CellType.STRING)
		{
			data=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		 
		if(wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType()==CellType.BLANK) {
			return "";
		}
		
	return data;
	}
}
