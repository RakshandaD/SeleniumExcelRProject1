package excelrProj1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPageObject {
	@FindBy(xpath ="//span[text()='PIM']") WebElement pim;
	@FindBy(xpath ="//a[text()='Add Employee']") WebElement addEmp;
	@FindBy(name="firstName") WebElement fName;
	@FindBy(name="middleName") WebElement mName;
	@FindBy(name="lastName") WebElement lName;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") WebElement eId;
	@FindBy(xpath ="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']") WebElement profilebtn;
	@FindBy(xpath ="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']") WebElement createlogintoggle;
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']") WebElement cancelbtn;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") WebElement saveBtn;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]") WebElement username;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]") WebElement password;
	@FindBy(xpath = "(//input[@type='password'])[2]") WebElement conPass;
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]") WebElement enabled;
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]") WebElement disabled;
	@FindBy(xpath="//img[@class='employee-image']") WebElement profilepic;
}
