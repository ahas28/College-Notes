package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Confirmation_Page extends Abstract_Class {

    ExtentTest logger;
    public MetLife_Confirmation_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger= super.logger;
    }//end of the constructor

    public MetLife_Confirmation_Page confirmation_page() {
        //Capturing the confirmation message
        String confirmation=Reusable_Library_Loggers.captureText(driver,"//div[@class='col-sm-8']","Capture confirmation message",logger);
        //Splitting the confirmation message
        String []confirmedDentalProgram=confirmation.split(" ");
        //printing the desired dental program
        System.out.println("The search result is " + confirmedDentalProgram[3]);

        return new MetLife_Confirmation_Page(driver);
    }

    public MetLife_Confirmation_Page screenShot() {
        Reusable_Library_Loggers.getScreenShot(driver,logger,"Picture of confirmation");
        return new MetLife_Confirmation_Page(driver);
    }


}//end of java class
