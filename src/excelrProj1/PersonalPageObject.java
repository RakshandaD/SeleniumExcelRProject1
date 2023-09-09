package excelrProj1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPageObject {
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") WebElement nName;
	//@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]") WebElement eId;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[5]") WebElement eId;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[6]") WebElement otherId;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[7]") WebElement DLicense;
	@FindBy(xpath="//input[@placeholder='yyyy-mm-dd']")
	public List<WebElement> dateInput;
	@FindBy(xpath = "//input[@placeholder='dd-mm-yyyy']")
    public List<WebElement> date;
	//@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[8]") WebElement DExpdate;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[9]") WebElement ssnNo;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[10]") WebElement sinNo;
	 @FindBy(className = "oxd-select-text-input")
	    public List<WebElement> dropdown;
	@FindBy(xpath="(//*[@class='oxd-select-text oxd-select-text--active'])[1]") WebElement nationality;
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]") WebElement maritalStatus;
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]") WebElement doB;
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]") WebElement gMale;
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]") WebElement gFemale;
	@FindBy(className = "oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input")
    public List<WebElement> radiobtn;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[10]") WebElement miltarySer;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[1]") WebElement smoker;
	@FindBy(xpath="(//button[text()=' Save '])[1]") WebElement saveBtn;
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]") WebElement bType;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[11]") WebElement test;
	@FindBy(xpath="(//button[text()=' Save '])[2]") WebElement saveBtn2;
	@FindBy(xpath="//button[text()=' Add ']") WebElement addBtn;
	@FindBy(xpath="//div[text()='Browse']") WebElement browseFile;
	@FindBy(xpath="//textarea[@placeholder='Type comment here']") WebElement comment;
	@FindBy(xpath="(//button[text()=' Save '])[3]") WebElement saveBtn3;
	@FindBy(xpath="//button[text()=' Cancel ']") WebElement cancelBtn;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]") WebElement headerChkBox;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[3]") WebElement chkBox1;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[4]") WebElement chkBox2;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]") WebElement edit1;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]") WebElement delete1;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]") WebElement download1;
	@FindBy(xpath="//button[text()=' Delete Selected ']") WebElement deleteAll;
	@FindBy(xpath="//button[text()=' Yes, Delete ']") WebElement confDel;
	@FindBy(xpath="//button[text()=' No, Cancel ']") WebElement confCancel;
}
