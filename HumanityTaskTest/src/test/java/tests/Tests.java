package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.ArrayList;

public class Tests extends BaseTest{
    LandingPage landingPage;
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    StaffListPage staffListPage;
    StaffAddPage staffAddPage;
    ClockPage clockPage;
    AssignStaffPage assignStaffPage;

    @Before
    public void SetUpLandingPage(){
        landingPage = new LandingPage();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        staffListPage = new StaffListPage();
        staffAddPage = new StaffAddPage();
        clockPage = new ClockPage();
        assignStaffPage = new AssignStaffPage();


//        logging-in
        landingPage.clickOnLoginButton();
        loginPage.fillEmailField("dankapop1984@gmail.com");
        loginPage.fillPasswordField("tralala275");
        loginPage.clickOnBlueLoginButton();
    }

    @Test
    public void addNewEmployees(){
        dashBoardPage.clickOnStaffCategory();
        staffListPage.clickOnAddEmployeeButton();
        staffAddPage.enterFirstName(5); /*broj je opcioni*/
        staffAddPage.enterLastName(5);
//        staffAddPage.enterEmailAddress(3);
        staffAddPage.clickOnSaveEmployeeButton();
        ArrayList<String> savedEmployees = staffAddPage.getFullName();
        assignStaffPage.clickOnEmployeesListedButton();
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//a[@class=\"staff-employee\"]")));
        ArrayList<String> allTheNames = staffListPage.getNamesFromStaffList();

        if(allTheNames.containsAll(savedEmployees)) {
            Assert.assertTrue(true);
        }



    }

    @Test
    public void clockInWhenNotClockedIn(){
        dashBoardPage.clickOnTimeClockCategory();
        try {Thread.sleep(5000);
        }
        catch(InterruptedException e){}
        if(clockPage.clockInButton.isDisplayed()){
            clockPage.clickOnClockInButton();
            Assert.assertTrue(clockPage.assertClockedInText());

//            clockPage.clickOnStartBreakButton();
//            clockPage.clickOnContinueShiftButton();
               //clockPage.clickOnClockOutButton();
        }


    }

    @Test
    public void clockOutWhenClockedIn() {
        dashBoardPage.clickOnTimeClockCategory();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        if (clockPage.clockOutButton.isDisplayed()) {
//            clockPage.clickOnStartBreakButton();
//            clockPage.clickOnContinueShiftButton();
            clockPage.clickOnClockOutButton();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            Assert.assertTrue(clockPage.isClockInButtonDisplayedAfterClockingOut());
        }


    }
}

