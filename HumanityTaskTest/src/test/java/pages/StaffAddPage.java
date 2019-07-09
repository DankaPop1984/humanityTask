package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.ArrayList;
import java.util.List;


public class StaffAddPage extends BaseTest {
    ArrayList<String> firstNames = new ArrayList<String>();
    ArrayList<String> lastNames = new ArrayList<String>();
   public ArrayList<String> fullNames = new ArrayList<String>();

    @FindBy(id = "_asf1")
    public WebElement firstFirstNameField;

    @FindBy(className = "_ns_fname")
    List<WebElement> firstNameField;

    @FindBy(className = "_ns_lname")
    List<WebElement> lastNameField;

    @FindBy(className = "_ns_email")
    List<WebElement> emailAddressField;


    @FindBy(id = "_as_save_multiple")
    WebElement saveEmployeeButton;

    public StaffAddPage() {
        PageFactory.initElements(driver, this);
    }

    public String generateString() {
        int n = 5;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public void enterFirstName(int j) {
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("_ns_fname")));
        for (int i = 0; i < j; i++) {
            String generated = generateString();
            String first_name = generated.substring(0,1).toUpperCase() + generated.substring(1);
            firstNameField.get(i).sendKeys(first_name);
            firstNames.add(first_name);
        }
    }

    public void enterLastName(int k) {
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("_ns_lname")));
        for (int i = 0; i < k; i++) {
            String last_name = generateString();
            lastNameField.get(i).sendKeys(last_name);
            lastNames.add(last_name);
        }
    }

    public ArrayList<String> getFullName() {
        for (int i = 0; i < firstNames.size(); i++) {
            fullNames.add(firstNames.get(i) + " " + lastNames.get(i));
        }
        return fullNames;
    }
    public void enterEmailAddress(int l) {
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("_ns_email")));
        for (int i = 0; i < l; i++) {
            String email_address = generateString();
            emailAddressField.get(i).sendKeys(email_address);
        }
    }

    public void clickOnSaveEmployeeButton(){
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("arguments[0].scrollIntoView();", saveEmployeeButton);
        js5.executeScript("arguments[0].click();", saveEmployeeButton);
    }
}