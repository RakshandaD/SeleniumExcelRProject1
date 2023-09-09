package excelrProj1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {

	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(xpath="//button[text()=' Login ']") WebElement login;
}
