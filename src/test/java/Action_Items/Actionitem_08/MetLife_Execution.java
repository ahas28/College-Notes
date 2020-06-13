package Action_Items.Actionitem_08;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MetLife_Execution extends Abstract_Class {

    @Test
    public void exution() throws IOException, BiffException, InterruptedException {

        Workbook readableFile;
        Sheet readableSheet;

        //Defining the excel path
        readableFile = Workbook.getWorkbook(new File("src/main/java/Excel/MetLife.xls"));
        //Defining the Excel sheet
        readableSheet = readableFile.getSheet(0);

        //printing the extent report message
        logger.log(LogStatus.INFO, "Navigating to the MetLife website");

        //Navigating to MetLife website
        driver.navigate().to("https://www.metlife.com");
        //Delaying for 2.5 sec
        Thread.sleep(3000);
        driver.manage().window().maximize();

        MetLife_Base_Class.metLife_homepage().verifyTitle();
        Thread.sleep(2000);

        // Reusable_Library_Loggers.mouseHover(driver,"(//*[contains(text(),'SOLUTION')]) [1]", "mouse hover",logger);
        MetLife_Base_Class.metLife_homepage().mouseHover();
        Thread.sleep(3000);
        MetLife_Base_Class.metLife_homepage().clickDental();
        Thread.sleep(2500);
        for (int i = 1; i < 4; i++) {
            MetLife_Base_Class.metLife_enroll_page().clickEnroll();
            Thread.sleep(6000);
            MetLife_Base_Class.metLife_switchTabs().switchTab(1);
            Thread.sleep(2000);
            System.out.println(driver.getTitle());

            String zipCode = readableSheet.getCell(0, i).getContents();
            MetLife_Base_Class.metLife_zipCode_page().zipCode(zipCode);
            Thread.sleep(5000);
            String dentalProgram = readableSheet.getCell(1, i).getContents();

            MetLife_Base_Class.metLife_dentalProgram_page().selectDental(dentalProgram);

            MetLife_Base_Class.metLife_dentalProgram_page().enrollProgram();
            Thread.sleep(2000);
            String referralCode = readableSheet.getCell(2, i).getContents();
            MetLife_Base_Class.metLife_dentalProgram_page().referralCodeInput(referralCode);
            MetLife_Base_Class.metLife_dentalProgram_page().errorMessage();
            MetLife_Base_Class.metLife_dentalProgram_page().withoutReferralCode();
            Thread.sleep(2000);
            MetLife_Base_Class.metLife_confirmation_page().confirmation_page();
            MetLife_Base_Class.metLife_confirmation_page().screenShot();





            driver.close();
            MetLife_Base_Class.metLife_switchTabs().switchTab(0);



        }//end of the for loop

    }


}//end of java class
