package com.dsrc.seleniumtest.framework.reports;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class XlReporter {

	public String testCaseName=null;
	public String testCaseDescription=null;
	public String testCaseCategory=null;
	public String testCaseAuthor=null;

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wbk =new XSSFWorkbook();
		XSSFSheet sheet = wbk.createSheet("Sheet1");
		XSSFRow header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("Test Case #");
		header.createCell(1).setCellValue("Test Step ");
		header.createCell(2).setCellValue("Test Status ");
		header.createCell(3).setCellValue("Snap");
		
		FileOutputStream fos= new FileOutputStream(new File("./reports/excel/TestCase1.xlsx"));
		wbk.write(fos);
	}
}


