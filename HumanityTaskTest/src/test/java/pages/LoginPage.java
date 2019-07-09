package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = ".btn.btn-blue.btn-full")
    WebElement logInBlueButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void fillEmailField(String emailaddress){
        emailField.clear();
        emailField.sendKeys(emailaddress);
    }

    public void fillPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnBlueLoginButton(){
        logInBlueButton.click();
    }
}
