package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DashBoardPage extends BaseTest {
    @FindBy(id = "sn_staff")
    WebElement staffNavBarCategory;

    @FindBy(id = "sn_timeclock")
    WebElement timeClockNavBarCategory;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickOnStaffCategory(){
//        wdwait.until(ExpectedConditions.elementToBeClickable(staffNavBarCategory));
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){

        }
        staffNavBarCategory.click();
    }

    public void clickOnTimeClockCategory(){
        wdwait.until(ExpectedConditions.elementToBeClickable(timeClockNavBarCategory));
        timeClockNavBarCategory.click();
    }
}
