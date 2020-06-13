package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item_4 {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","Source//Resource//chromedriver83.exe");
        //set some pre condition using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the argument you want for the driver
        options.addArguments("incognito");
        //open chrome web
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> dentalProgram =new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        ArrayList<String> zipCode= new ArrayList<>();
        zipCode.add("11416");
        zipCode.add("11417");
        zipCode.add("11418");

        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("4562");
        referralCode.add("6752");
        referralCode.add("8765");



            driver.navigate().to("https://metlife.com/");
            Thread.sleep(3000);
            driver.manage().window().maximize();
            // verify title
       Thread.sleep(3000);
        String actualTitle = driver.getTitle();
            if (actualTitle.equals("Insurance and Employee Benefits MetLife")) {
                System.out.println("Title match expected and the title is "+actualTitle);
            } else {
                System.out.println("Title doesn't match and the title is" + actualTitle);
            }//end of title
        Thread.sleep(2500);
         //Clicking solution
            try {
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
              } catch (Exception e) {
            System.out.println("Unable to click on SOLUTIONS");
             }//end of MetLife Dental

            Thread.sleep(2000);
           //Clicking the metlife takeAlong Dental
            try {
                driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on MetLife Dental");
            }//end of MetLife Dental
            Thread.sleep(1500);

            //Now Verify the Title
            String title1 = driver.getTitle();
            if (title1.equals("MetLife TakeAlong Dental MetLife")) {
                System.out.println("Title matches and the Title is "+title1 );
            } else {
                System.out.println("Title doesn't match and the Title is " + title1);
            } // end of if and and else condition


            for (int i = 0; i < zipCode.size(); i++) {
            //clicking the enroll now button
            try {
                driver.findElement(By.xpath("//a[contains(@class,'2nd table')]")).click();
            } catch (Exception e) {
                System.out.println("Not able click on enroll now");
            }//end of try and catch enroll now
            Thread.sleep(3000);
            //switching to child page
            //noe define the arrayList to handle all current windows tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //Clearing the previous input
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCode']")).clear();
            } catch (Exception e) {
                System.out.println("Not able clear previous input "+ e);
            }//end of try and catch enroll now
            Thread.sleep(3000);

            //putting zipCode inside the box
            try {
                WebElement zip = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
                zip.clear();
                zip.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("not able to enter ZipCode" + e);
            }//end of try and catch zipCode
            //clicking the go button
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
            } catch (Exception e) {
                System.out.println("not able to click on go" + e);
            } //end of try and catch go

            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//*[@class='"+dentalProgram.get(i)+"']")).click();
            } catch (Exception e) {
                System.out.println(("Not Able to do anything " + e));
            } //end of try and catch PPO !

            try {
                driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();
            } catch (Exception e) {
                System.out.println(("Not Able to click on enroll in program now " + e));
            } //end of try and catch enroll in program now

            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys(referralCode.get(i));
            } catch (Exception e) {
                System.out.println(("Not Able to type referralcodes " + e));
            } //end of try and catch referral codes
            Thread.sleep(3000);

            try {
                driver.findElement(By.xpath("//*[@id='enrollgobtn']")).click();
            } catch (Exception e) {
                System.out.println(("Not Able  to click on Go button " + e));
            } //end of try and try and catch go buttons

            Thread.sleep(1000);
            //Printing the error message
            try {
                String message = driver.findElement(By.xpath("//*[@id='lblRefCodeError']")).getText();
                System.out.println(message);
            } catch (Exception e) {
                System.out.println("Not able to print " + e);
            }//end of try and catch print error
            //proceeding without referral code
            try {
                driver.findElement(By.xpath("//*[contains(@class,'primaryborder')]")).click();
            } catch (Exception e) {
                System.out.println(" Not able to click on enroll and now without referral code" + e);
            }//end of try and not able to click on enroll and now without referral code

            Thread.sleep(6000);
            //comparing the dental program with array
            try {
                String ppo = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();
                if (ppo.contains(dentalProgram.get(i))) {
                    System.out.println("print has a match " + ppo);
                } else {
                    System.out.println("print doesn't match" + ppo);
                } //end of try and catch for print PPO

            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.close();

            driver.switchTo().window(tabs.get(0));

            Thread.sleep(2000);
        }//end of the for loop
        driver.quit();
            }//end of main method

        }//end of java class
