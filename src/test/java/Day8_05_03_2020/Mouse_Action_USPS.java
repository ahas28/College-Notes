package Day8_05_03_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Action_USPS {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","Source//Resource//chromedriver83.exe");
    ChromeOptions options =new ChromeOptions();
    options.addArguments("incognito");
    WebDriver driver = new ChromeDriver(options);
    //driver.manage().window().maximize();
        // navigate to USPS
    driver.navigate().to("https:usps.com");
    Thread.sleep(2500);
    //call your Mouse Actions
    Actions mouse = new Actions(driver);
    //hover to Mail & Ship tab

    try{
        WebElement mailAndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
        //call your Actions command to move to the element
        mouse.moveToElement(mailAndShip).perform();
    }catch (Exception e){
            System.out.println("Unable to locate mail & Ship "+ e);
            Thread.sleep(2000);
        //Click on Click-N-Ship using Actions
}//end of Mail & Ship Exception

        try{
            //by using absolute xpath along with the parent
            //WebElement clickAndShip = driver.find element(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
    WebElement ClickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a"));
    //child to parent is preceding ::
        //call your Actions command to move to the element
         mouse.moveToElement(ClickAndShip).click().perform();
        }catch (Exception e){
        System.out.println("unable to locate Click-N-Ship " +e);

}//end of Click-N-Ship Exception




        }//end of main the main method
}//end of the java class

