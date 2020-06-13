package Day5_04252020;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_Xpath {

    public static void main(String[] args) throws InterruptedException {
        //line below store your search field xpath as a string variable
        String searchPath ="//*[@name='field-keywords']";
       // line below store your Search image Icon xpath as string variable
        String serachIconPath = "//*[@value='Go']";
        //line below store your image icon explain xpath as a string variable
        String imagePath = //img[contains9=(@class,'s-image')]";


        //define your property
        System.setProperty("webdriver.chrome.driver","sre/Resource//chromedriver83.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to ("https://www.amazon.com");


        //maximize your driver window
        driver.manage().window().maximize();
        //wait few seconds
        Thread.sleep(2000);

        //enter a keyword laptop on amazon search field by using xpath
        driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("laptop");
        //click on search icon
        driver.findElement(By.xpath("//*[@type='submit' and @value='Go']")).click();
        Thread.sleep(2500);

        // click on second image item of the same elements within that page using index numbers
        driver.findElements (By.xpath("//img[contains(@class,'s-image')]")).get(4).click();
        //renavigate back to homepage
        driver.navigate().to ("https://www.amazon.com");



}//end of main

}//end of java class


