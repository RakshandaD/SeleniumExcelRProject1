package excelrProj1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestFile {

	public static final String filePath = "C:\\Users\\raksh\\eclipse-workspace\\SeleniumProject\\TestData\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameLogin = "Orane HRM Login";
	public WebDriver driver;
	public LoginPageObject o;
 
	@BeforeTest
	public void beforeMethod() throws Exception {
		String path=System.getProperty("user.dir");
		path=path +"\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", path);
	    driver = new EdgeDriver();
		driver.get(PIMResuableMethod.readDataFromExcel(1, 1,filePath, sheetName));
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void validCred() throws Exception {
	    o=PageFactory.initElements(driver, LoginPageObject.class);
		o.uname.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.pwd.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 1)
	private void emptyCred() throws Exception {
	    o=PageFactory.initElements(driver, LoginPageObject.class);
		o.uname.sendKeys("");
		Thread.sleep(1000);
		o.pwd.sendKeys("");
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	private void invalidPassword() throws Exception {
		o=PageFactory.initElements(driver, LoginPageObject.class);
		o.uname.sendKeys(PIMResuableMethod.readDataFromExcel(4, 2,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.pwd.sendKeys(PIMResuableMethod.readDataFromExcel(4, 3,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 3)
	public void invalidCred() throws Exception {
		o=PageFactory.initElements(driver, LoginPageObject.class);
		o.uname.sendKeys(PIMResuableMethod.readDataFromExcel(6, 2,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.pwd.sendKeys(PIMResuableMethod.readDataFromExcel(6, 3,filePath, sheetNameLogin));
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
	}
	
	@AfterTest
	private void afterMethod() {
		driver.close();
	}
}
