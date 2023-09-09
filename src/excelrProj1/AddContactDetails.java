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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactDetails {

	public static final String filePath = "C:\\Users\\raksh\\eclipse-workspace\\SeleniumProject\\TestData\\OrangeHRMTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "Orane HRM Login";
	public static final String sheetNameEmployee = "AddEmployee";
	public static final String sheetNamePersonal = "PersonalDetails";
	public static final String sheetNameContact = "ContactDetails";

	public WebDriver driver;
	public LoginPageObject o;
	public PIMPageObject p;
	public ContactPageObjects cp;

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
		Thread.sleep(7000);
		p.addEmp.click();
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void addEmpWithoutCreateLogin() throws Exception {
		p = PageFactory.initElements(driver, PIMPageObject.class);
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
	public void addContactDetails() throws Exception {
		cp = PageFactory.initElements(driver, ContactPageObjects.class);
		cp.contactPage.click();
		Thread.sleep(5000);
		cp.street1.sendKeys(PIMResuableMethod.readDataFromExcel(3, 2,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.street2.sendKeys(PIMResuableMethod.readDataFromExcel(3, 3,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.city.sendKeys(PIMResuableMethod.readDataFromExcel(3, 4,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.state.sendKeys(PIMResuableMethod.readDataFromExcel(3, 5,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.postalCode.sendKeys(PIMResuableMethod.readDataFromExcel(3, 6,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.Countrydropdown.get(0).click();
		cp.Countrydropdown.get(0).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		cp.Countrydropdown.get(0).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		cp.Countrydropdown.get(0).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// Thread.sleep(2000);
		cp.homeno.sendKeys(PIMResuableMethod.readDataFromExcel(3, 7,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.mobileno.sendKeys(PIMResuableMethod.readDataFromExcel(3, 8,filePath, sheetNameContact));
		Thread.sleep(2000);
		cp.workno.sendKeys(PIMResuableMethod.readDataFromExcel(3, 9,filePath, sheetNameContact));
		Thread.sleep(2000);
		WebElement ele = cp.postalCode;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		int r = (int) ((Math.random() * (80 - 4)) + 4);
		cp.workemail.sendKeys(PIMResuableMethod.readDataFromExcel(3, 10,filePath, sheetNameContact) + r + "@gmail.com");
		Thread.sleep(2000);
		cp.otherEmail.sendKeys(PIMResuableMethod.readDataFromExcel(3, 11,filePath, sheetNameContact) + r + 1 + "@gmail.com");
		Thread.sleep(2000);
		cp.saveBtn1.click();
		Thread.sleep(10000);
	}

	@Test(priority = 3)
	public void addAttachment1() throws Exception {
		cp = PageFactory.initElements(driver, ContactPageObjects.class);
		cp.addBtn.click();
		Thread.sleep(2000);
		cp.browseFile.click();
		Thread.sleep(2000);
		String path = System.getProperty("user.dir");
		path = path + "\\TestData\\Dafile.txt";
		PIMResuableMethod.uploadFile(path);
		Thread.sleep(2000);
		cp.comment.sendKeys("test");
		Thread.sleep(2000);
		cp.savebtn2.click();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void addAttachment2() throws Exception {
		cp = PageFactory.initElements(driver, ContactPageObjects.class);
		cp.addBtn.click();
		Thread.sleep(2000);
		cp.browseFile.click();
		Thread.sleep(2000);
		String path = System.getProperty("user.dir");
		path = path + "\\TestData\\19MayOutput.txt";
		PIMResuableMethod.uploadFile(path);
		Thread.sleep(2000);
		cp.comment.sendKeys("test1");
		Thread.sleep(2000);
		cp.savebtn2.click();
		Thread.sleep(5000);
//		WebElement ele2 = cp.saveBtn2;
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele2);
//		Thread.sleep(3000);
	}
	
	@AfterClass
	private void afterClass() {
		driver.close();
	}

}
