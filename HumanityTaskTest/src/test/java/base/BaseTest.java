package base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdwait;

    @Before
    public void SetUp(){
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("https://www.humanity.com/");


    }

//    @After
//    public void TearDown(){
//        driver.close();
//    }
}
