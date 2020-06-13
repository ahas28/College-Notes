package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_Class {


    public MetLife_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);

    }//end of the constructor

    public static MetLife_Homepage metLife_homepage() {
        MetLife_Homepage metLife_homepage = new MetLife_Homepage(driver);
        return metLife_homepage;
    }//end of the MetLife home page

    public static MetLife_Enroll_Page metLife_enroll_page() {

        MetLife_Enroll_Page metLife_enroll_page = new MetLife_Enroll_Page(driver);
        return metLife_enroll_page;
    }//end of the enroll page

    public static MetLife_ZipCode_Page metLife_zipCode_page() {
        MetLife_ZipCode_Page metLife_zipCode_page = new MetLife_ZipCode_Page(driver);
        return metLife_zipCode_page;
    }//end  of the zipCode page

    public static MetLife_DentalProgram_Page metLife_dentalProgram_page() {
        MetLife_DentalProgram_Page metLife_dentalProgram_page = new MetLife_DentalProgram_Page(driver);
        return metLife_dentalProgram_page;
    }//end of the dental program method

    public static MetLife_Confirmation_Page metLife_confirmation_page() {
        MetLife_Confirmation_Page metLife_confirmation_page = new MetLife_Confirmation_Page(driver);
        return metLife_confirmation_page;
    }
    public static MetLife_SwitchTabs metLife_switchTabs(){
        MetLife_SwitchTabs metLife_switchTabs= new MetLife_SwitchTabs(driver);
        return metLife_switchTabs;
    }


}//end of java class
