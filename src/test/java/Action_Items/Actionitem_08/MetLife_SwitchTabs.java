package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MetLife_SwitchTabs extends Abstract_Class {

    ExtentTest logger;
    public MetLife_SwitchTabs(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger= super.logger;
    }//end of the constructor

    public MetLife_SwitchTabs switchTab(int index) {
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return new MetLife_SwitchTabs(driver);
    }

}//end of java class
