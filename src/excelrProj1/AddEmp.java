package excelrProj1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmp {

	public static final String filePath = "C:\\Users\\raksh\\eclipse-workspace\\SeleniumProject\\TestData\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	public static final String sheetNamePersonal = "PersonalDetails";
	
	public WebDriver driver;
	public LoginPageObject o;
	public PIMPageObject p;
	public PersonalPageObject pd;  
    
	@BeforeClass
	public void beforeClass() throws Exception {
	    String path=System.getProperty("user.dir");
		path=path +"\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", path);
		driver = new EdgeDriver();
		driver.get(PIMResuableMethod.readDataFromExcel(1, 1,filePath, sheetName));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		o = PageFactory.initElements(driver, LoginPageObject.class);
		p = PageFactory.initElements(driver, PIMPageObject.class);
		o.uname.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2,filePath, sheetNameTest));
		Thread.sleep(1000);
		o.pwd.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3,filePath, sheetNameTest));
		Thread.sleep(1000);
		o.login.click();
		Thread.sleep(10000);
		p.pim.click();
		Thread.sleep(3000);
		p.addEmp.click();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void addEmpWithoutCreateLogin() throws Exception {
		p = PageFactory.initElements(driver, PIMPageObject.class);
		Thread.sleep(5000);
		p.fName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2,filePath, sheetNameEmployee));
		Thread.sleep(1000);
		p.mName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3,filePath, sheetNameEmployee));
		Thread.sleep(1000);
		p.lName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 4,filePath, sheetNameEmployee));
		Thread.sleep(2000);
		p.eId.clear();
		Thread.sleep(2000);
		p.eId.sendKeys("096");
		Thread.sleep(2000);
		p.saveBtn.click();
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void addPersonalDetails() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.nName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 5,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		pd.eId.sendKeys(PIMResuableMethod.readDataFromExcel(3, 6,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		pd.otherId.sendKeys(PIMResuableMethod.readDataFromExcel(3, 7,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		WebElement ele1 = pd.nName;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		pd.DLicense.sendKeys(PIMResuableMethod.readDataFromExcel(3, 7,filePath, sheetNamePersonal));
		Thread.sleep(2000);	
		//pd.dateInput.get(0).sendKeys("11-09-2023");
		Thread.sleep(5000);
		WebElement ele = pd.otherId;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		pd.ssnNo.sendKeys(PIMResuableMethod.readDataFromExcel(3, 10,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		pd.sinNo.sendKeys(PIMResuableMethod.readDataFromExcel(3, 11,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		pd.dropdown.get(0).click();
		pd.dropdown.get(0).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(1).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(1).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		pd.dropdown.get(1).click();
		pd.dropdown.get(1).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(1).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(1).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//pd.dateInput.get(0).sendKeys("17-10-1996");
		Thread.sleep(2000);
		pd.gFemale.click();
		Thread.sleep(2000);
		pd.miltarySer.sendKeys(PIMResuableMethod.readDataFromExcel(3, 12,filePath, sheetNamePersonal));
		Thread.sleep(2000);
		pd.smoker.click();
		Thread.sleep(2000);
		pd.saveBtn.click();
		Thread.sleep(5000);
		pd.dropdown.get(2).click();
		pd.dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		pd.dropdown.get(2).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		pd.saveBtn2.click();
		Thread.sleep(5000);
		WebElement ele2 = pd.saveBtn2;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void addAttachment1() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.addBtn.click();
		Thread.sleep(2000);
		pd.browseFile.click();
    	Thread.sleep(2000);
        String path=System.getProperty("user.dir");
    	path=path + "\\TestData\\Dafile.txt";
    	PIMResuableMethod.uploadFile(path);
    	Thread.sleep(2000);
		pd.comment.sendKeys("test");
		Thread.sleep(2000);
		pd.saveBtn3.click();
		Thread.sleep(20000);
	}
	
	@Test(priority = 4)
	public void addAttachment2() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.addBtn.click();
		Thread.sleep(2000);
		pd.browseFile.click();
    	Thread.sleep(2000);
        String path=System.getProperty("user.dir");
    	path=path +"\\TestData\\19MayOutput.txt";
    	PIMResuableMethod.uploadFile(path);
    	Thread.sleep(2000);
		pd.comment.sendKeys("test");
		Thread.sleep(2000);
		pd.saveBtn3.click();
		Thread.sleep(5000);
		WebElement ele2 = pd.saveBtn2;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(20000);
	}
	
	@Test(priority = 6)
	public void editAttachment() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		Thread.sleep(20000);
		pd.edit1.click();
		Thread.sleep(2000);
		pd.browseFile.click();
    	Thread.sleep(2000);
        String path=System.getProperty("user.dir");
    	path=path +"\\TestData\\OutputData.txt";
    	PIMResuableMethod.uploadFile(path);
        Thread.sleep(5000);
		pd.comment.sendKeys("replace");
		Thread.sleep(2000);
		pd.saveBtn3.click();
		Thread.sleep(20000);		
	}
	
	@Test(priority = 5)
	public void downloadAttachment() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.download1.click();
		Thread.sleep(30000);
	}

	@Test(priority = 7)
	public void deleteAttachment() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.delete1.click();
		Thread.sleep(5000);
		pd.confDel.click();
		Thread.sleep(20000);
	}
	
	@Test(priority = 8)
	public void deleteAllAttachment() throws Exception {
		pd = PageFactory.initElements(driver, PersonalPageObject.class);
		pd.headerChkBox.click();
		Thread.sleep(5000);
		pd.deleteAll.click();
		Thread.sleep(5000);
		pd.confDel.click();
		Thread.sleep(20000);
	}

	@Test(priority = 9)
	public void addEmpWithCreateLogin() throws Exception {
		p=PageFactory.initElements(driver, PIMPageObject.class);
		p.pim.click();
		Thread.sleep(10000);
		p.addEmp.click();
		Thread.sleep(10000);
		p.fName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2,filePath, sheetNameEmployee));
		Thread.sleep(1000);
		p.mName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3,filePath, sheetNameEmployee));
		Thread.sleep(1000);
		p.lName.sendKeys(PIMResuableMethod.readDataFromExcel(3, 4,filePath, sheetNameEmployee));
		Thread.sleep(1000);
		p.eId.clear();
		Thread.sleep(2000);
		int r = (int) ((Math.random() * (500 - 2)) + 4);
		p.eId.sendKeys(r+"08");
		Thread.sleep(2000);
		p.createlogintoggle.click();
		Thread.sleep(2000);
		p.username.sendKeys("UsEr"+r);
		Thread.sleep(2000);
		p.disabled.click();
		Thread.sleep(2000);
		p.enabled.click();
		Thread.sleep(2000);
		WebElement ele=p.eId;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(10000);
		p.password.sendKeys(PIMResuableMethod.readDataFromExcel(3, 6,filePath, sheetNameEmployee));
		Thread.sleep(2000);
		p.conPass.sendKeys(PIMResuableMethod.readDataFromExcel(3, 7,filePath, sheetNameEmployee));
		Thread.sleep(2000);
		p.saveBtn.click();
		Thread.sleep(20000);
	}

	@AfterClass
	private void afterClass() {
		driver.close();
	}
}
