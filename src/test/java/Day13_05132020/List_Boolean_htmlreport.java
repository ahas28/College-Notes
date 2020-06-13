package Day13_05132020;

import Reusable_Classes.Reusable_Library;
import com.google.inject.internal.FailableCache;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class List_Boolean_htmlreport {
    //declare the driver outside
    WebDriver driver;
    //declare the report variable outside
    ExtentReports reports;
    //declare the logger (extent test)
    ExtentTest logger;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();

        //define  the report path here as a before suite
        reports = new ExtentReports("src//main/java//HTML_Report//AutomationReport.html",true);
    }//end of before method


    @Test
    public void yahoo_verification() throws InterruptedException{
        //define and start the test
        logger = reports.startTest("Yahoo verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"Navigating to yahoo home page");
        driver.navigate().to("https://www.yahoo.com");
        //3 to 4 seconds for page to load
        Thread.sleep(3500);
        //I want tp count all the links in yahoo home page and print it
        logger.log(LogStatus.INFO, "Getting the list for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if the lickCount returns you 12 links
        if (linkCount.size() == 12){
            System.out.println("MY yahoo page link count matches and it it " + linkCount.size());
        }else {
            System.out.println("MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
           logger.log(LogStatus.FAIL,"My yahoo home page link count doesn't matches and actual is " + linkCount.size());
        }//end of it else

        //click on Sign in Link
        Reusable_Library.click(driver, "//*[@id='header-signin-link']", "Sign In");
        //wait few seconds
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement (By.xpath("//*[@id='persistent']")).isSelected();
        if(checkboxState == true){
            System.out.println("Checkbox is selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected default");
        } else{
            System.out.println("Checkbox is selected by default");
        }//end of if else

        //end the test for specific @test
        reports.endTest(logger);
    }//end of test method

    @AfterSuite
    public void closeSession(){
       // driver.quit();
        //flushing = writing the logs (loggers) back to your automation report that you defined
        reports.flush();
    }//end of after suits





}//end of java class

