package com.Ajio.generic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtil {


	/**
	 * This method is used to fetch the value of the cell.
	 * @param filePath
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */

	public String readDataFromExcel(String filePath,String sheetName ,int rownum ,int cellnum) throws IOException
	{

		File file = new File(filePath);
		String filepath = file.getAbsolutePath();
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		String celldata = sheet.getRow(rownum).getCell(cellnum).toString();
		return celldata;
	}
	
	
	public void WriteDataFromExcel(List<String> headers ,String jeanspage, List <WebElement> webeleone, List <WebElement> webeletwo) throws FileNotFoundException, IOException
	{
		File file = new File(jeanspage+"jeans.xlsx");

		try (XSSFWorkbook  workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet("Sheet1");

			// Write headers
			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.size(); i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers.get(i));
			}	
			for(int i=1; i<webeleone.size();i++)
			{
				WebElement cellvalueone = webeleone.get(i);
				WebElement cellvaluetwo = webeletwo.get(i);
				XSSFRow row=sheet.createRow(i);
				row.createCell(0).setCellValue(cellvalueone.getText());
				row.createCell(1).setCellValue(cellvaluetwo.getText());
				
			}
			
			
			try (FileOutputStream fileOut = new FileOutputStream(file)) {
				workbook.write(fileOut);
			//	Data written to Excel successfully
			}
		}}

		}
	
