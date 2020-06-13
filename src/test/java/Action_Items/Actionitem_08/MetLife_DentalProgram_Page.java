package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_DentalProgram_Page extends Abstract_Class {

    ExtentTest logger;
    public MetLife_DentalProgram_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger= super.logger;
    }//end of the constructor


    public MetLife_DentalProgram_Page selectDental(String userInput) {
        Reusable_Library_Loggers.click(driver,"//*[@class='"+userInput+"']","clicking checkbox", logger);
        return new MetLife_DentalProgram_Page(driver);
    }

    public MetLife_DentalProgram_Page enrollProgram() {
        Reusable_Library_Loggers.click(driver,"(//*[@class='btn btn-success']) [1]","enrolling", logger);
        return new MetLife_DentalProgram_Page(driver);
    }



    public MetLife_Homepage referralCodeInput(String userInput) {
        Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@id='txtBxPromocode']",userInput,"Applying referral code", logger);
        return new MetLife_Homepage(driver);
    }


    public MetLife_DentalProgram_Page errorMessage() {
        Reusable_Library_Loggers.captureText(driver,"//span[contains(text(),'Referral Code was not recognized')]","error message", logger);
        return new MetLife_DentalProgram_Page(driver);
    }

    public MetLife_DentalProgram_Page withoutReferralCode() {
        Reusable_Library_Loggers.click(driver,"//a[@class='btn btn-primaryborder']","Enroll without referral code", logger);
        return new MetLife_DentalProgram_Page(driver);
    }



}//end of java class
