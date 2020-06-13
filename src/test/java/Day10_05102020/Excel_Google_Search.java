package Day10_05102020;

import Reusable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

import static jxl.Workbook.getWorkbook;


class Google_practice_excel {


    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //Step 1:
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//main//resource//Google_Search.xls"));
        //Step 2
         //locate the readable  worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3
        //we need to create a writable to mimic readable file because we should not be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("Source//Resource//Google_search_Results.xls"),readableFile);
        //create writable sheet
        WritableSheet writableFileSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableFileSheet.getRows();

        //define the web driver using reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i = 1; i < rows; i++){

            //Step 4
            //Store the cars column values as String variable
            //column are always hard coded whereas the rows are dynamic based on your i
            String cars = writableFileSheet.getCell(0,i).getContents();

            //navigate to google page
            driver.navigate().to("https://www.google.com/");
            //timeout
            Thread.sleep(2500);

         //reusable library to enter car values on search field
            Reusable_Library.userKeys(driver,"//*[@name='q']",cars,"Search Field");
            Reusable_Library.submit(driver,"//*[@name='q']","enter");

        //timeout
            Thread.sleep(2500);

            String result = Reusable_Library.captureText(driver, "//*[@id='results-stats']","Search Results");
            String[] resultArray = result.split(" ");
            System.out.println("My search number is "+ resultArray[1]);

            //Step 5:
            //Write the search number result back to writable sheet
            Label label = new Label(1,i,resultArray[1] + " " + resultArray[3] + " " + resultArray[4]);
            //adding back to writable cell
            writableFileSheet.addCell(label);

        }//end of loop

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.write();
        writableFile.write();

        //quit the driver
        driver.quit();

}// end of main method
}//end of java class

