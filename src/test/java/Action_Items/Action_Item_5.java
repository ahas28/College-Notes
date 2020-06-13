package Action_Items;

import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import javax.xml.transform.Result;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static jxl.Workbook.getWorkbook;

public class Action_Item_5 {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        Workbook readableFile = getWorkbook(new File("src//Resource//Express_online.xls"));
        //locate the readable  worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);
        //  Desktop.getDesktop().open(new File("src//Resource//Express_Search.xls"));

        //we need to create a writable to mimic readable file because we should not be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src//Resource//Express_online_Results.xls"), readableFile);
        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        WebDriver driver = Reusable_Library.setDriver();

        for (int i = 1; i < rows; i++) {
            driver.navigate().to("https://www.express.com/");
            //for all variables
            String Size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAdd = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String creditCardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvcCode = writableSheet.getCell(13, i).getContents();
            String ErrorMessage = writableSheet.getCell(14, i).getContents();

            //navigate to express homepage
            driver.navigate().to("https://www.express.com/");
            // give 2 seconds
            Thread.sleep(2000);

            //Hover the women icon using mouse action
            Reusable_Library.Hover(driver, "(//*[@class='_399XX MegaMenu_primaryNav__label__1s3d1']) [1]", "Hovering");
            Thread.sleep(2000);

            // using the mouse click on the women dress
            Reusable_Library.click(driver, "//*[text()='Dresses']", "Clicking on Dresses");
            Thread.sleep(4000);

            //choose the dress that comes first
            Reusable_Library.click(driver, "(//*[@class='_1-wQg']) [1]", "clicking firstDress");


            //Now choose the size
            Reusable_Library.click(driver, "//span[text()='" + Size + "']", "size");

            //Add the item in the checkout bag
            Reusable_Library.click(driver, "//*[text()='Add to Bag']", "Add to Bag");


            //Again it will hover over the shopping icon
            Reusable_Library.Hover(driver, "(//*[@class='_2CsVP svg-icon--shopping-bag']) [2]", "Hovering the mouse");
            Thread.sleep(2000);

            //Click on the bag and then checkout
            Reusable_Library.click(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ']", "clicking adding to bag");
            Thread.sleep(2000);

            Reusable_Library.dropdownByText(driver, "//*[@id='qdd-0-quantity']", quantity, "Selecting Quantity");
            Thread.sleep(2000);

            //Click on the checkout options
            Reusable_Library.click(driver, "//*[text()='Checkout']", "checkout");
            Thread.sleep(2000);

            //click on the checkout options with guest
            Reusable_Library.click( driver,"//*[text()='Continue as Guest']","click guest");

            //This will add first name
            Reusable_Library.userKeys(driver, "//*[@name='firstname']", firstName,"first Name");

            //this will add their last name
            Reusable_Library.userKeys(driver, "//*[@name='lastname']", lastName,"Last Name");

            //this will add their email
            Reusable_Library.userKeys(driver,"//input[@name='email']", email,"Email Add");

            //this will re enter their email address
            Reusable_Library.userKeys(driver, "//input[@name='confirmEmail']", email, "Confirm Email");

            //this will add their phone number
            Reusable_Library.userKeys(driver, "//*[@name='phone']", phoneNumber,"Phone Number");

            //Now with this it will click continue
            Reusable_Library.click(driver,  "//*[text()='Continue']","continuefirst");
            Thread.sleep(2000);

            //this will add the address
            Reusable_Library.userKeys(driver, "//input[@name='shipping.line1']", streetAdd, "StreetAddress");

            //this will add add the zip code
            Reusable_Library.userKeys(driver, "//*[@name='shipping.postalCode']", postalCode, "postalCode");

            //this will add the city
            Reusable_Library.userKeys(driver,"//*[@name= 'shipping.city']", city, "cityname");
            Thread.sleep(2000);

            //dropdown for state
            Reusable_Library.dropdownByText(driver, "//select[@name='shipping.state']", State, "NY");
            Thread.sleep(3000);

            //this will proceed proceed to continue
            Reusable_Library.click(driver,"//*[text()='Continue']","Second Continue");
            Thread.sleep(2000);

            Reusable_Library.click(driver,"//*[text()='Continue']", "thirdcontinue");
            Thread.sleep(2000);

            //imputing the credit card number
            Reusable_Library.userKeys(driver, "//*[@name='creditCardNumber']", creditCardNumber, "creditcarnumber");

            //imputing the expiration month on the card
            Reusable_Library.dropdownByText(driver,"//*[@name='expMonth']", expMonth,"expremonth");

            //imputing the year on the card number
            Reusable_Library.dropdownByText(driver, "//*[@name='expYear']", expYear, "expireyear");

            //imputing the cvv code on the card
            Reusable_Library.userKeys(driver, "//*[@name='cvv']", cvcCode, "cvvcode");

            //Now click submit on the order
            Reusable_Library.click(driver,"//*[text()='Place Order']","placeorder");
            Thread.sleep(2000);

            //now capture and select the text
            String errorMsg = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']", "capture text");

            //Finally print the statement
            System.out.println("The Message I captured "+ errorMsg);

            Label error= new Label(14,i,errorMsg);
            writableSheet.addCell(error);

            //delete all the cookies
            driver.manage().deleteAllCookies();

        }//end of for the loop

        writableFile.write();
        writableFile.close();
        readableFile.close();

        Thread.sleep(2000);
        //now open th writable excel to the view the test results automatically
        //use Desktop.getDesktop().open command to open desktop applications
 driver.quit();


    }//end of main method


}//end of java class
