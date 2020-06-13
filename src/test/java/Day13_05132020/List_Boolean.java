package Day13_05132020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean {
    //declare the driver outside
    WebDriver driver;

    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
    }//end of before method


    @Test
    public void yahoo_verification() throws InterruptedException{
        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(4000);
        //i want tp count all the links in yahoo home page and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if the lickCount returns you 12 licks
        if (linkCount.size() == 12){
            System.out.println("MY yahoo page link count matches and it it " + linkCount.size());
        }else {
            System.out.println("MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
        }//end of it else
        //click on Sign in Link
        Reusable_Library.click(driver, "//*[@id='header-signin-link']", "Sign In");
        //wait few seconds
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement (By.xpath("//*[@id='persistent']")).isSelected();
        if(checkboxState == true){
            System.out.println("Checkbox is selected by default");
        } else{
            System.out.println("Checkbox is selected by default");
        }//end of if else
    }//end of test method

    @AfterSuite
    public void closeSession(){
        driver.quit();
    }//end of after suits





}//end of java class

