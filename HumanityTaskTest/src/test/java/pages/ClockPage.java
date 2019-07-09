package pages;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ClockPage extends BaseTest {
    @FindBy(id = "tc_tl_ci")
    public WebElement clockInButton;

    @FindBy(id = "tc_tl_co")
    public WebElement clockOutButton;

    @FindBy(id = "tc_tl_br_s")
    public WebElement breakTimeStart;

    @FindBy(id = "tc_tl_br_e")
    public WebElement continueShiftButton;

    @FindBy(xpath = ".//li[@class=\"clockedIn\"]/div")
    public WebElement clockedInText;

    public ClockPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnClockInButton(){
       wdwait.until(ExpectedConditions.elementToBeClickable(clockInButton));
           JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", clockInButton);
    }

    public void clickOnClockOutButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(clockOutButton));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", clockOutButton);
    }

    public void clickOnStartBreakButton() {
        wdwait.until(ExpectedConditions.elementToBeClickable(breakTimeStart));
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("arguments[0].click();", breakTimeStart);
    }

    public void clickOnContinueShiftButton() {
        wdwait.until(ExpectedConditions.elementToBeClickable(continueShiftButton));
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("arguments[0].click();", continueShiftButton);
    }

    public String getClockedInText(){
        wdwait.until(ExpectedConditions.visibilityOf(clockedInText));
        return clockedInText.getText();
    }

    public boolean assertClockedInText(){
        if(getClockedInText().contains("Clocked in.")){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isClockInButtonDisplayedAfterClockingOut(){
        if(clockInButton.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
}
