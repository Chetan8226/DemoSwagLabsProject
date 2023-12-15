package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readPropertiesFile(String Value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("E:\\Software Testing\\Jarfile\\Eclipse Program\\Selenium_Framework\\TestData\\config.Properties");
		prop.load(file);
		return prop.getProperty(Value);
	}
	public static String readexcel(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("E:\\Software Testing\\Jarfile\\Eclipse Program\\Selenium_Framework\\TestData\\Book1.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
	    String value = es.getRow(rowNum).getCell(colNum).getStringCellValue();
	    return value;
		
		
		
	}

}
