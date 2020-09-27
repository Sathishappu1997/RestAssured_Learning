package DataProvider;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData{
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ReadExcelData(String xlFilePath) throws Exception {
		
		file = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(file);
		file.close();
		
	}
	
	public String getCellData(String sheetname, int colnumber, int rownumber) {
		
		try {
			
			sheet = workbook.getSheet(sheetname);
			row = sheet.getRow(rownumber);
			cell = row.getCell(colnumber);
			
			if(cell.getCellType()==CellType.STRING) {
				
				return cell.getStringCellValue();
				
			}else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA) {
				
				String cellvalue = String.valueOf(cell.getNumericCellValue());
				
				if(DateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
					Date date = cell.getDateCellValue();
					cellvalue = dt.format(date);
				}
				
				return cellvalue;
				
			}else if(cell.getCellType()==CellType.BLANK) {
				
				return "";
				
			}else {
				
				return String.valueOf(cell.getBooleanCellValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "No Match Found";
		}
		
	}
	
	public int getRowCount(String sheetname) {
		
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
		
	}
	
	public int getColumnCount(String sheetname) {
		
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
		
	}

}
