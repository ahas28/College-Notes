package Day14_053120;

import Reusable_Classes.Reusable_Library;
import javafx.scene.control.Tab;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static jxl.Workbook.getWorkbook;

public class Kayak_Driven_Class {


    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;

    private String Date;


    @BeforeSuite
    public void callDriver() throws IOException, BiffException {
        //define the path of readable file
        readableFile = getWorkbook(new File("src//main//resources//Kayak_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Kayak_Search_Result.xls"), readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod


    @Test
    public void KayakSearch() throws InterruptedException, WriteException {
        int row = wSheet.getRows();
        for (int i = 1; i < row; i++) {
            String cars = wSheet.getCell(0, i).getContents();

            //for all variables
            String airports = wSheet.getCell(0, i).getContents();
            String startDate = wSheet.getCell(1, i).getContents();
            String startTime = wSheet.getCell(2, i).getContents();
            String endDate = wSheet.getCell(3, i).getContents();
            String endTime = wSheet.getCell(4, i).getContents();
            String vechileSize = wSheet.getCell(5, i).getContents();
            String vechileInfo = wSheet.getCell(6, i).getContents();

            //navigate to Kayak website
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            // give 2 seconds

            //click on the search field
            Reusable_Library.click(driver, "//div[@data-placeholder='Enter an airport or city']", "Clicking on Search field");

            //entering airPortName
            Reusable_Library.userTypeAndHitEnter(driver, "//*[@name='pickup']", airports, "Putting airports name");
            Thread.sleep(2000);

            //entering the start date calender
            Reusable_Library.click(driver, "(//*[@class='_isu _iad _iaf _iEc _iaa _iPK _iam _j0E _j0F _iai']) [2]", "Start Date");
            Thread.sleep(2000);

            //select and entering the end date
            Reusable_Library.userTypeAndHitEnter(driver, "(//div[@aria-label='Drop-off date']) [2]", endDate, "Selecting End Date");
            Thread.sleep(3000);

            //click on the end time
            Reusable_Library.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [2]", "Clicking end time");
            Thread.sleep(2000);

            //scrolling down to the time
            Reusable_Library.scrollDown(driver, "//*[@class='handle']", 0, 10, "Scroll down");
            Thread.sleep(2000);

            //entering the end time
            Reusable_Library.click(driver, "(//*[contains(text(),'" + endTime + "')]) [2]", "End time");
            Thread.sleep(3000);

            //click on start date
            Reusable_Library.click(driver, "(//*[@class='_iQh']) [1]", "clicking start date");
            //Delaying for 3 sec
            Thread.sleep(3000);

            //Enter the pick up date date
            Reusable_Library.userKeys(driver, "(//div[@aria-label='Pick-up date']) [2]", startDate, "Pickup date");

            //Hitting Enter
            Reusable_Library.KeyEnter(driver, "(//div[@aria-label='Pick-up date']) [2]", "Hitting Enter");
            Thread.sleep(1000);

            //clicking outside
            Reusable_Library.click(driver, "//*[@class='title dark']", "clicking outside");

            //continuing with clicking outside
            Reusable_Library.click(driver, "//*[@class='title dark']", "clicking outside");

            //click on start date
            Reusable_Library.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [1]", "Clicking start date");
            Thread.sleep(2000);

            //continue to scroll down to the time
            Reusable_Library.scrollDown(driver, "//*[@class='handle']", 0, 10, "Scroll down");

            //click on the end time
            Reusable_Library.click(driver, "(//*[contains(text(),'"+startTime+"')]) [1]", "End time");
            Thread.sleep(2500);

            //now click on the search button
            Reusable_Library.click(driver, "//*[@title='Search cars']", "clicking search button");
            Thread.sleep(6000);

            //selecting the checkbox
            Reusable_Library.click(driver, "//div[@id='cars-topFilter-"+vechileSize+"-checkbox_icon']", "checkbox");
            Thread.sleep(6000);
            //Delay for 5 sec

            //now viewing the deal
            Reusable_Library.click(driver, "(//*[contains(text(),'View Deal')]) [2]", "view deal");
            Thread.sleep(5000);

            ArrayList<String> Tabs= new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(Tabs.get(1));
            if(i==1) {
                String carInfo = Reusable_Library.captureText(driver, "(//div[@class='card-body p-2']) [12]", "Car info");
                String estimatedCost = Reusable_Library.captureText(driver, "//*[@class='mb-0 font-weight-bolder']", "estimated cost");
                Label cell61= new Label(6,1,carInfo);
                wSheet.addCell(cell61);
                Label cell71= new Label(7,1,estimatedCost);
                wSheet.addCell(cell71);
            }
            if(i==2){
                String locatorInfo2="(//*[@class='Checkout-Common-Uicore-NormalText resetColor']) [1]";
                //Capturing the booking info in a string variable
                String bookingInfo2 = Reusable_Library.captureText(driver,locatorInfo2, "Booking info");
                //Capturing the estimated price in a string variable
                String estimatedPrice2 = driver.findElement(By.xpath("(//*[@class='fpiCell']) [22]")).getText();
                Label cell61= new Label(6,2,bookingInfo2);
                wSheet.addCell(cell61);
                Label cell71= new Label(7,2,estimatedPrice2);
                wSheet.addCell(cell71);
            }
            if(i==3){
                String locatorInfo3="(//*[@class='Checkout-Common-Uicore-NormalText resetColor']) [1]";
                //Capturing the booking info in a string variable
                String bookingInfo3 = Reusable_Library.captureText(driver,locatorInfo3, "Booking info");
                //Capturing the estimated price in a string variable
                String estimatedPrice3 = driver.findElement(By.xpath("(//*[@class='fpiCell']) [22]")).getText();
                Label cell61= new Label(6,3,bookingInfo3);
                wSheet.addCell(cell61);
                Label cell71= new Label(7,3,estimatedPrice3);
                wSheet.addCell(cell71);
            }


            driver.close();
            driver.switchTo().window(Tabs.get(0));
            driver.manage().deleteAllCookies();


        }//end of for loop
    }//end of kayak search

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of Aftermethod


}//end of java class













