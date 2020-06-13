package Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

    public class Yahoo_Homepage extends Abstract_Class {

        ExtentTest logger;

        //we need to create a constructor method that defines
        //driver and logger to be reuse locally to this page
        public Yahoo_Homepage(WebDriver driver){
            super();
            PageFactory.initElements(driver,this);
            //local page logger gets set to abstract class logger when you use it in page object concept
            this.logger = super.logger;


        }//end of main method


        //method for SearchField
        public Yahoo_Homepage searchField(String userValue){
            Reusable_Library_Loggers.userKeys(driver,"//*[@id='header-search-input']",userValue,"Search Field",logger);
            //instead of userValue you can enter or put anything else as u wish it could be your values cars and cars.get(i)
            return new Yahoo_Homepage(driver);

        }//end of searchField

        //method for search icon
        public Yahoo_Homepage searchIcon(){
            Reusable_Library_Loggers.click(driver,"//*[@id='header-desktop-search-button']","Search Icon",logger);
            return new Yahoo_Homepage(driver);

    }//end of searchIcon method





}//end of java class