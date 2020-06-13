package Day4_4192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test_With_Loop {

    public static void main(String[] args) {


     //set the system chrome driver pat atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver83.exe");

        //you declare and define the web driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array for city to loop through certain value from the array

        //opening the browser automatically to go to google home page


        //wait few seconds after navigating

        //locate the search field inspecting it first and then enter a keyword let say cars
        driver.findElement(By.name("Q")) .sendKeys();

        //click on google search
        //maximize your browser
        //driver.manage() . window().maximize();
        //to capture a text from web site you need to

    //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your money
        //i prefer to use quit
        //driver.quit();


    }//end of main method


}//end of Java class
