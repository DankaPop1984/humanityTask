package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class StaffListPage extends BaseTest {

   public ArrayList<String> employeeNames = new ArrayList<String>();

    @FindBy(id = "act_primary")
    WebElement addEmployeeButton;

    @FindBy(xpath = ".//a[@class=\"staff-employee\"]")
   public List<WebElement> namesOfEmployees;

    public StaffListPage(){
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> getNamesFromStaffList(){
        for(int i = 0; i < namesOfEmployees.size(); i++){
            String innerTextValue = namesOfEmployees.get(i).getAttribute("innerText");
            employeeNames.add(innerTextValue);
        }
        employeeNames.remove("Danka Popovic");
 //       System.out.println(employeeNames);
        return employeeNames;

    }
    public void clickOnAddEmployeeButton(){
//        wdwait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){

        }
        addEmployeeButton.click();
    }

}
