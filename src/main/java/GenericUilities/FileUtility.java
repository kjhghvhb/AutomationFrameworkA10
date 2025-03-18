package GenericUilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to File
 * @author Lavanya.M
 * 
 */

public class FileUtility 
{
	/**
	 * This method read Data from property file and return the values
	 * caller
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	public String  readDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;	
		
	}
	
	/**
	 * * This method read Data from Excel file and return the values to
	 * caller
	 * @param sheet
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws IOException
	 */
	public String  readDataFromExcelFile(String sheet,int rowNumber,int cellNumber) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	    return value;
	}
	
	
}
