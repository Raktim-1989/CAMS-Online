package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] readExcel() throws IOException
	{
		Object[][] readData = new Object[2][2] ;
		String dir = System.getProperty("user.dir");
		String path = dir + File.separator + "CamsData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		for(int i = 0;i <2;i++)
		{
			XSSFRow row = sh.getRow(i);
			for(int j = 0;j<2;j++)
			{
				XSSFCell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
			 readData[i][j] = df.formatCellValue(cell);
			 System.out.println(readData[i][j]);
			}
		}
		
		return readData;
				
	}

}
