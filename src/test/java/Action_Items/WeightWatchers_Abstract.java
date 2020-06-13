package Action_Items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WeightWatchers_Abstract extends Abstract_Class {


    @Test
    public void weightWatchers() throws InterruptedException {

        //define the string array variable
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11420");
        zipCode.add("11421");
        zipCode.add("11422");

        //define log info for navigating to the weight watcher website
        logger.log(LogStatus.INFO, "navigating to weight watchers website");

        //navigating to the weight watcher website
        driver.navigate().to("https://weightwatchers.com");

        //delay for 3 sec
        Thread.sleep(3000);

        //verify the title
        Reusable_Library_Loggers.verifyTitle(driver, "WW (weight Watchers): Weight loss & Wellness Help", logger);

        for (int i = 0; i < zipCode.size(); i++) {
            Reusable_Library_Loggers.click(driver, "(//*[contains(text(),'Find a Workshop')]) [1]", "Clicking find a workshop", logger);

            //Clicking the search box
            Reusable_Library_Loggers.click(driver, "//*[@id='meetingSearch']", "Search box", logger);

            //entering the zip code inside the box
            Reusable_Library_Loggers.userTypeAndHitEnter(driver, "//*[@id='meetingSearch']", zipCode.get(i),"input the zip code" , logger);

            //clicking the search button
            Reusable_Library_Loggers.click(driver,"//button[@class='btn spice-translated']","searcg button", logger);

            //Delay for 3 sec
            Thread.sleep(3000);

            //clicking the link
            Reusable_Library_Loggers.clickByIndex(driver, "//*[@class='location__top']", 4-i,"Clicking the link", logger);

            //Capturing the studio name and address
            Reusable_Library_Loggers.captureText(driver,"//*[@class='location']", "Studio name and address",logger );

            //Capturing the weekly schedule in the text
            Reusable_Library_Loggers.captureText(driver,"//*[contains(@class,'meeting-schedule ')]", "Weekly schedule", logger);


        }//end of the for loop


    }//end of the test method


}//end of the java class
