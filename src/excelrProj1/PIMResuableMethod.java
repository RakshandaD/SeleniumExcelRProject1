package excelrProj1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PIMResuableMethod {
	
	public static final String filePath = "C:\\Users\\raksh\\Downloads\\orangehrm-master\\orangehrm-master\\ExcelRSeleniumProject\\src\\test\\java\\testdata\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	
	public static void uploadFile(String fPath) throws Exception {
		Robot rb = new Robot();
    	StringSelection str = new StringSelection(fPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
     // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static String readDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname)
    {
        String data = null;
        try
        {
            FileInputStream input= new FileInputStream(filepath);
            @SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(input);
            XSSFSheet sh=wb.getSheet(Sheetname);
            XSSFRow row=sh.getRow(rowcount);
            DataFormatter df = new DataFormatter();
            data = df.formatCellValue(row.getCell(columncount));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
     }
	

}
