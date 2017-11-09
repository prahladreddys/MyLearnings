package com.test.automation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void readExcel(String path) throws IOException{
		FileInputStream file = new FileInputStream(new File(path));
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet1 = book.getSheetAt(0);
		Iterator<Row> it = sheet1.iterator();
		while(it.hasNext()){
			Row row = it.next();
			Iterator<Cell> cellIt = row.iterator();
			while(cellIt.hasNext()){
				Cell cell = cellIt.next();
				if(cell.getCellTypeEnum() == CellType.STRING){
					System.out.print(cell.getStringCellValue() +"  ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		readExcel("test-data/data.ods");
	}
	
}
