/**
 * 
 */
package illumy_ILcom.illumy.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author thambibabu.dasari
 *
 */
public class ExcelData {
	
	
		public static final String EXCELFILELOCATION="user.dir"+"./com/illumy/qa/testdata/InputSheet.xlsx";
		
		private static FileInputStream fis;
		private static XSSFWorkbook workbook;
		private static XSSFSheet sheet;
		private static XSSFRow row;
		
		
		public static void loadExcel(String sheetName) throws Exception {
			
			File file=new File(EXCELFILELOCATION);
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			fis.close();
		}
		
		public static  Map<String, Map<String, String>> getMapData(String sheetName) throws Exception {
			if(sheet==null) {
				loadExcel(sheetName);
			}
			
			Map<String, Map<String, String>> superMap=new HashMap<String, Map<String,String >>();
			HashMap<String, String> userMap=new HashMap<String, String>();
			
			 for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				 row=sheet.getRow(i);
				 
					String keyCell = row.getCell(0).getStringCellValue();
	
					int colNum = row.getLastCellNum();
					for(int j=0;j<colNum;j++) {
						
						String value=String.valueOf(row.getCell(j).getStringCellValue());
						userMap.put(keyCell, value);
				}
					superMap.put("DATA", userMap);
			 }
			return superMap;
			 
		}
		
		public static String getValue(String sheetName,String key) throws Exception {
			Map<String, String>myVal=getMapData(sheetName).get("DATA");
			String retValue=myVal.get(key);
			
			return retValue;
		
		}
		
		
	

}
