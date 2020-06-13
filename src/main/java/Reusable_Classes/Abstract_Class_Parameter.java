package Reusable_Classes;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_Parameter {

    //to be used on your @Test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;


    //define before suite to set a static driver
    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library_Loggers.setDriver();
        //define the report path as usual
        reports = new ExtentReports("src//main//java/HTML_Report//TestReport.html",true);


    }//end of before suite

    //before method will be used to capture a unique @test name that you gave
    //on your test class
    @Parameters("Browser")
    @BeforeMethod
    public void getMethodName(Method testName,String Browser) throws IOException,InterruptedException{
        if(Browser.equalsIgnoreCase("Chrome")){
            driver = Reusable_Library_Loggers.setDriver();
        }else if (Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src//main//resources//geckodriver32.exe");
            driver = new FirefoxDriver();
            //driver.manage().window().maximize();
        }//end of conditional statement
        //start the logger here to capture specific @Test method name
        logger = reports.startTest(testName.getName() + "-" + Browser);
    }//end of before method

    //after method will end each test
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);

    }//end of after method

    @AfterSuite
    public void classInfo(){
        driver.quit();
        //or
        reports.flush();
    }//end of afterSuite



}//end of java class