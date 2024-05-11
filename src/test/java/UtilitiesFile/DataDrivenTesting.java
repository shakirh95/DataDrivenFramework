package UtilitiesFile;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting 
{
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public  static FileInputStream fileInputStream;

	public static  int getRowCount(String filename, String Sheetname) throws Exception 
	{
	fileInputStream = new FileInputStream(filename);
	workbook = new XSSFWorkbook(fileInputStream);
	worksheet = workbook.getSheet(Sheetname);
	int totalRow = worksheet.getLastRowNum()+1;
	return totalRow;
	}
	public static  int getColumnCount(String filename, String Sheetname) throws Exception 
	{
	fileInputStream = new FileInputStream(filename);
	workbook = new XSSFWorkbook(fileInputStream);
	worksheet = workbook.getSheet(Sheetname);
	int totalColumn = worksheet.getRow(0).getLastCellNum();
	return totalColumn;
	}
	public static  String getCellValue(String filename, String Sheetname, int row, int column) throws Exception 
	{
	fileInputStream = new FileInputStream(filename);
	workbook = new XSSFWorkbook(fileInputStream);
	worksheet = workbook.getSheet(Sheetname);
	cell = workbook.getSheet(Sheetname).getRow(row).getCell(column);
	return cell.getStringCellValue();
	
	}

}