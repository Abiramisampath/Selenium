package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] excelData(String fileName) throws IOException {
		// TODO Auto-generated method stub
		
		//Set up the workbook path
		XSSFWorkbook wb= new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//Get into the worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum(); 	//excluding the first row
		System.out.println(rowCount);
		
		int cellCount  = ws.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			
			for(int j=0;j<cellCount;j++) {
				
				String cellValue =  ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellValue);
				data[i-1][j] = cellValue;
			}
		}
		
		wb.close();
		
		return data;

	}

}
