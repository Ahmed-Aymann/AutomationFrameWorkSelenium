package Tests;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
  protected  WebDriver driver;
    DriverManager driverManager;
    @BeforeMethod
    public void setup(){
        driverManager = new DriverManager();
        driverManager.initDriver("chrome");
        driver = driverManager.getDriver();

    }

    @AfterMethod
    public void terminateDriver(){
        driverManager.quitDriver();
    }
}
