package Action_Items;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Google_search_Abstract extends Abstract_Class {

    @Test
    public void googleSearch() throws InterruptedException{

        //define the array list for country
        ArrayList<String > country= new ArrayList<>();
        country.add("America");
        country.add("Mexico");
        country.add("Canada");

        //define the log information for the browser
        logger.log(LogStatus.INFO,"Navigating to google browser");

        //navigate to google browser
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);

        for(int i=0; i<country.size();i++){
            //entering the value inside the search box and hit submit
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@name='q']",country.get(i),"insert variable and hit enter",logger);

            //Delay for 25 sec
            Thread.sleep(2500);

            //defining the variable for capturing the search result
            String searchResult=  Reusable_Library_Loggers.captureText(driver,"//*[@id='result-stats']","Searh result", logger);

            //Splitting the search result
            String[] actualNumber= searchResult.split(" ");

            //printing  the desired search result
            System.out.println("The search result of "+country.get(i)+"is "+actualNumber[1]);

            //define the log information for the output
            logger.log(LogStatus.INFO,"The search result of "+country.get(i)+"is "+actualNumber[1]);

        }//end of the for loop

    }//end of the test method

}//end of the java class
