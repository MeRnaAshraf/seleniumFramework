package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;
	
	public FileInputStream getfFileInputStream()
	{
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.xls";
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating process !! : Check file path of TestData");
			System.exit(0);
		}
		return fis;
		
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getfFileInputStream();
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int TotalNumberOfRows = (sheet.getFirstRowNum()+1);
		int TotalNumberOfCols = 4;
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];
		
		for(int i = 0; i < TotalNumberOfRows; i++)
		{
			for(int j = 0; j < TotalNumberOfCols; j++)
			{
				HSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
