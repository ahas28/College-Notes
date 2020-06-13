package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_ZipCode_Page extends Abstract_Class {

    ExtentTest logger;
    public MetLife_ZipCode_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger= super.logger;
    }//end of the constructor


    public MetLife_Homepage zipCode(String userInput) {
        Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@id='txtZipCode']",userInput,"zipCode", logger);
        return new MetLife_Homepage(driver);
    }

}//end of java class
