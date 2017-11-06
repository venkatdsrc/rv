package com.dsrc.seleniumtest.framework.dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider extends AbstractDataProvider{

	XSSFWorkbook wb;
	XSSFSheet ws;
	public ExcelDataProvider() {
		System.out.println("Excel DataProvider is created..");
	}
	
	
	
public static Object[][] readTestData(String strFileName) {
		
		Object [][]data =null;
		String sAbsPath = 	System.getProperty("user.dir");
		try {
		System.out.println("excel path : " + sAbsPath);
		File readExcel = new File (sAbsPath + strFileName);
		System.out.println("Test data path is : " + readExcel);
		
	    FileInputStream fis = new FileInputStream(readExcel);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet ws = wb.getSheetAt(0);
	    int rowCount = ws.getLastRowNum();
	    int colCount = ws.getRow(0).getLastCellNum();
	    data = new Object[rowCount][colCount];
	    System.out.println("Row and column counts : " + rowCount+" "+colCount);
	    for (int i=1; i<=rowCount; i++){
	        XSSFRow row = ws.getRow(i);
	            for (int j=0; j<colCount; j++){
	                XSSFCell cell = row.getCell(j);
	                int cellType = cell.getCellType();
	                if(cellType==0) {
	                	data[i-1][j] = cell.getNumericCellValue();
	                }
	                
	                if(cellType==1) {
	                	data[i-1][j] = cell.getStringCellValue();
	                }
	                System.out.println("Data is : " +data[i-1][j]);
	            }
	       }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
		
		}
		return data;
			
		}
}
