package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseTest {

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p")
    WebElement loginButton;

    public LandingPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
