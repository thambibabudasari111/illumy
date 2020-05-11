/**
 * 
 */
package com.illumy.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author thambibabu.dasari
 *
 */
public class ExcelReader {

	public static String EXCELFILETPATH=System.getProperty("user.dir")+"/src/main/java/com/illumy/qa/testdata/InputSheet.xlsx";
	
	public static FileInputStream fis;
	private static XSSFWorkbook workbook;		
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void loadExcel(String sheetName) throws Exception {
		File file=new File(EXCELFILETPATH);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		fis.close();
	}
	
	public static Map<String, Map<String,String>> getDataMap(String sheetName) throws Exception{
		if(sheet==null) {
			loadExcel(sheetName);
		}
		
		Map<String, Map<String,String>>superMap=new HashMap<String, Map<String, String>>();
		Map<String, String>myMap=new HashMap<String, String>();
		
		for(int i=1;i<sheet.getLastRowNum();i++) {
			row=sheet.getRow(i);
			String keyVal=row.getCell(0).getStringCellValue();
			//System.out.println("key value" + keyVal);
			
			
			int colNum=row.getLastCellNum();
			row.getCell(colNum);
			for(int j=1;j<colNum;j++) {
				
				//if(row.getCell(j)!=null && !row.getCell(j).toString().trim().equals("")) {
				//System.out.println("row " +row.getCell(j));
				//System.out.println("row value "+ row.getCell(j).getStringCellValue());
				String value=row.getCell(j).getStringCellValue();
				myMap.put(keyVal, value);
				}
			
			superMap.put("Data", myMap);
		}
		
		return superMap;
	}
	
	public static String getValue(String sheetName,String key) throws Exception{
		
		Map<String,String>myVal=getDataMap(sheetName).get("Data");
		//System.out.println("Result key value"+ myVal.get(key));
		String retValue= myVal.get(key);
		return retValue;
	}
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
