package excelrProj1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageObjects {
	@FindBy(xpath="//a[text()='Contact Details']") WebElement contactPage;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[1]") WebElement street1;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[2]") WebElement street2;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[3]") WebElement city;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[4]") WebElement state;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[5]") WebElement postalCode;
	@FindBy(className = "oxd-select-text-input")
    public List<WebElement> Countrydropdown;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[6]") WebElement homeno;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[7]") WebElement mobileno;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[8]") WebElement workno;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[9]") WebElement workemail;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[10]") WebElement otherEmail;
	@FindBy(xpath="(//button[text()=' Save '])[1]") WebElement saveBtn1;
	@FindBy(xpath="(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[11]") WebElement personalEmail;
	@FindBy(xpath="(//button[text()=' Save '])[2]") WebElement savebtn2;
	@FindBy(xpath="//button[text()=' Add ']") WebElement addBtn;
	@FindBy(xpath="//div[text()='Browse']") WebElement browseFile;
	@FindBy(xpath="//textarea[@placeholder='Type comment here']") WebElement comment;
	@FindBy(xpath="(//button[text()=' Save '])[3]") WebElement saveBtn3;
	@FindBy(xpath="//button[text()=' Cancel ']") WebElement cancelBtn;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[1]") WebElement headerChkBox;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]") WebElement chkBox1;
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[3]") WebElement chkBox2;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]") WebElement edit1;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]") WebElement delete1;
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]") WebElement download1;
}
