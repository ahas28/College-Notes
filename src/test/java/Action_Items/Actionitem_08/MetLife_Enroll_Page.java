package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MetLife_Enroll_Page extends Abstract_Class {

    ExtentTest logger;
    public MetLife_Enroll_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger= super.logger;
    }//end of the constructor


    public MetLife_Homepage clickEnroll() {
        Reusable_Library_Loggers.click(driver,"//*[contains(text(),'Enroll Now')]","Enroll Now", logger);
        return new MetLife_Homepage(driver);
    }



}//end of java class
