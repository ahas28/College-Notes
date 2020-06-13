package Day15_06062020;

import Reusable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;


public class Yahoo_Page_Object_Search_Results extends Abstract_Class {

    @Test
    public void Yahoo_Search_Result() throws  InterruptedException {

        logger.log(LogStatus.INFO,"navigating to Yahoo Home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_homepage().searchField("Cars");
        //click on search icon
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2500);
        //scroll to the bottom of the page
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //getting search number
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

}//end of test method

}//end of java class
