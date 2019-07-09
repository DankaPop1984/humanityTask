package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignStaffPage extends BaseTest {

    @FindBy(xpath = "//*[@id=\"stafftl_\"]/div[1]")
    WebElement employeesListedButton;

    public AssignStaffPage(){
        PageFactory.initElements(driver, this);
    }



    public void clickOnEmployeesListedButton(){
      try{
          Thread.sleep(1000);
      }
      catch(InterruptedException e){

      }
        employeesListedButton.click();
    }
}
