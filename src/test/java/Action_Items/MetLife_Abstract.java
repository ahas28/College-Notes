package Action_Items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_Abstract extends Abstract_Class {

    @Test
    public void metLife() throws InterruptedException {
        //define array for the zip codes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11420");
        zipCodes.add("11421");
        zipCodes.add("11422");

        //define array for the referral code
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("1420");
        referralCode.add("1421");
        referralCode.add("1422");

        //define array for the dental program
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        //defining the log info for navigating to the metLife
        logger.log(LogStatus.INFO, "navigating to metLife website");

        //navigating to the url
        driver.navigate().to("https://www.metlife.com/");

        //delay for 3sec
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //verify the title
        Reusable_Library_Loggers.verifyTitle(driver, "Insurance and Employee Benefits | MetLife", logger);

        Thread.sleep(2500);

        //clicking solution button
        //Reusable_Library_Loggers.mouseHover(driver, "//*[contains(text(),'SOLUTION')]", "Solution", logger);
        Reusable_Library_Loggers.mouseHover(driver, "//*[contains(text(),'SOLUTIONS')]", "Solution", logger);

        //delaying for 2.5 sec
        Thread.sleep(2000);

        //Clicking the metLife takeAlong dental from drop down
        Reusable_Library_Loggers.click(driver, "//*[contains(text(),'MetLife TakeAlong Dental')]", "Dental", logger);

        //delaying for 2.5 sec
        Thread.sleep(2000);

        for (int i = 0; i < zipCodes.size(); i++) {

            //clicking the enroll now button
            Reusable_Library_Loggers.click(driver, "//*[contains(text(),'Enroll Now')]", "Enroll Now", logger);

            //delaying for 2.5 sec
            Thread.sleep(2000);

            //Creating Array for the parent- child tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            //Switching to the new tab
            driver.switchTo().window(tabs.get(1));

            //delaying for 3 sec
            Thread.sleep(3000);

            //verifying the title of the new page
            Reusable_Library_Loggers.verifyTitle(driver, "MetLife TakeAlong Dental – Dental Insurance", logger);

            //Entering the zipCode into the search box and hit enter
            Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//*[@class='form-control']", zipCodes.get(i), "Entering zipcode and enter", logger);

            //delaying for 3 sec
            Thread.sleep(5000);

            //Selecting the checkbox for desired dental program
            Reusable_Library_Loggers.click(driver, "//*[@class='" + dentalProgram.get(i) + "']", "Dental program", logger);

            //delaying for 3 sec
            Thread.sleep(3000);

            //Clicking the enroll in program now
            Reusable_Library_Loggers.click(driver, "//a[@id='topenrolltab']", "Enroll in program", logger);

            //delaying for 3 sec
            Thread.sleep(3000);
            Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//input[@id='txtBxPromocode']", referralCode.get(i), "Referral Code", logger);

            Thread.sleep(3000);
            //Clicking the go button
            // Reusable_Library_Loggers.click(driver, "//button[@id='enrollgobtn']", "Clicking Go", logger);

            //Capturing the error message
            Reusable_Library_Loggers.captureText(driver, "//span[contains(text(),'Referral Code was not recognized')]", "error message", logger);

            //Clicking enroll without promo code
            Reusable_Library_Loggers.click(driver, "//a[@class='btn btn-primaryborder']", "Enroll without referral code", logger);

            //delay for 3sec
            Thread.sleep(3000);

            //Capturing the the text inside of a string variable
            String programPage= Reusable_Library_Loggers.captureText(driver, "//div[@class='col-sm-8']", "capturing the search result", logger);

            //splitting the  result
            String [] finaldentalResult= programPage.split(" ");

            //printing the searched dental program
            System.out.println("The search result is "+finaldentalResult[3]);

            //define the log info for the searched dental program
            logger.log(LogStatus.INFO,"The search result is "+finaldentalResult[3]);


            //closing the current window
            driver.close();

            //switching back to the parent window
            driver.switchTo().window(tabs.get(0));

        }//end of the for loop

    }//end of the test method
}//end of the java class
