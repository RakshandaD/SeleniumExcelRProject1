package excelrProj1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileImage {

	public static final String filePath = "C:\\Users\\raksh\\eclipse-workspace\\SeleniumProject\\TestData\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	
	public WebDriver driver;
	public LoginPageObject o;
	public PIMPageObject p;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String path = System.getProperty("user.dir");
		path = path + "\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", path);
		driver = new EdgeDriver();
		driver.get(PIMResuableMethod.readDataFromExcel(1, 1, filePath, sheetName));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		o = PageFactory.initElements(driver, LoginPageObject.class);
		p = PageFactory.initElements(driver, PIMPageObject.class);
		o.uname.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2, filePath, sheetNameTest));
		Thread.sleep(1000);
		o.pwd.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3, filePath, sheetNameTest));
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
		p.pim.click();
		Thread.sleep(3000);
		p.addEmp.click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 1)
	public void uploadJpgImg() throws Exception {
		p = PageFactory.initElements(driver, PIMPageObject.class);
		p.profilepic.click();
		Thread.sleep(2000);
		String path=System.getProperty("user.dir");
    	path=path +"\\TestData\\pexels-photo-14553290.jpeg";
		PIMResuableMethod.uploadFile(path);
        Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void uploadPNGImg() throws Exception {
		p = PageFactory.initElements(driver, PIMPageObject.class);
		p.profilepic.click();
		Thread.sleep(2000);
		String path=System.getProperty("user.dir");
    	path=path +"\\TestData\\free-photo-of-mercedes-glb-200.png";
		PIMResuableMethod.uploadFile(path);    	
        Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void uploadGIFImg() throws Exception {
		p = PageFactory.initElements(driver, PIMPageObject.class);
		p.profilepic.click();
		Thread.sleep(2000);
		String path=System.getProperty("user.dir");
    	path=path +"\\TestData\\pexels-photo-13643632.gif";
		PIMResuableMethod.uploadFile(path);
        Thread.sleep(5000);
	}
	
	@AfterClass
	private void afterClass() {
		driver.close();
	}
}
