package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Homepage extends Abstract_Class {

    ExtentTest logger;

    public MetLife_Homepage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of the constructor

    public MetLife_Homepage verifyTitle() {
        Reusable_Library_Loggers.verifyTitle(driver,"Insurance and Employee Benefits | MetLife",logger);

        return new MetLife_Homepage(driver);
    }

    public MetLife_Homepage mouseHover() {
Reusable_Library_Loggers.mouseHover(driver,"(//*[contains(text(),'SOLUTION')]) [1]","Clicking solution",logger);
        return new MetLife_Homepage(driver);
    }

    public MetLife_Homepage clickDental() {
Reusable_Library_Loggers.click(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","clicking Dental", logger);
        return new MetLife_Homepage(driver);
    }


}//end of the java class
