package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Item_2 {
    public static void  main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","Source//Resource//chromedriver83.exe");

        //define the driver
        WebDriver driver = new ChromeDriver();


        String[]Bank = new String[5];
        Bank[0]= "Chase";
        Bank[1]= "TD Bank";
        Bank[2]= "HSBC";
        Bank[3]= "Citi";
        Bank[4]= "BofA";

        for(int i=0; i<Bank.length;i++) {
            //opening the browser automatically to go to bing home page
            driver.navigate().to( "https://www.bing.com");

            //wait for 2 seconds

            //maximize the browser
            driver.manage().window().maximize();

            //wait for 2 seconds
            Thread.sleep(2000);

            //locate the search field and enter all the "keywords"
            driver.findElement(By.name("q")).sendKeys(Bank[i]);

            driver.findElement(By.name("search")).submit();

            //wait for 2 seconds
            Thread.sleep(2000);

            //this will capture the text element
            String message = driver.findElement(By.id("b_tween")).getText();
            //this will extract the specific information
            String[] arrayResults = message.split(" ");
            System.out.println("my favorite Bank is "+ Bank [i] + "and my search number is " + arrayResults[0]);



        }//end of for loop

        //this will quit the browser
        driver.quit();




    }//end of main method

    public static class Action_Item3 {

        public static void main(String[] args) throws InterruptedException {
            String[] zipCode = new String[3];
            zipCode[0] = "11416";
            zipCode[1] = "11417";
            zipCode[2] = "11418";

            //set the chrome path
            System.setProperty("webdriver.chrome.driver","Source//Resource//chromedriver83.exe");
            //set some pre condition using ChromeOptions
            ChromeOptions options = new ChromeOptions();
            //set the argument you want for the driver
            options.addArguments("incognito");
            //now simply define your chrome driver
            WebDriver driver = new ChromeDriver(options);
            //navigate to wieghtwatchers.com
            driver.navigate().to("https://weightwatchers.com");
            Thread.sleep(2000);

            //use full screen command
            driver.manage().window().maximize();
            //set your actual title than compare it with expected title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("WW (weight Watchers): Weight loss & Wellness Help")) {
                System.out.println("Title mathces with expected");
            } else {
                System.out.println("Title doesn't match" + actualTitle);
            }//end of else

            for (int i = 0; i < zipCode.length; i++) {
                driver.findElement(By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//input[@id='meetingSearch']")).sendKeys(zipCode[i]);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@class='btn spice-translated']")).click();
                Thread.sleep(2000);
                if (i == 0) {
                    driver.findElements(By.xpath("//*[@class='location__top']")).get(2).click();
                    Thread.sleep(2000);

                }
                if (i == 1) {
                    driver.findElements(By.xpath("//*[@class='location__top']")).get(3).click();
                    Thread.sleep(3000);

                }
                if (i == 2) {
                    driver.findElements(By.xpath("//*[@class='location__top']")).get(1).click();
                    Thread.sleep(2000);

                }

                String location = driver.findElement(By.xpath("//*[@class='location']")).getText();
                Thread.sleep(2000);
                System.out.println("the address for studio workshop is "+location);
                Thread.sleep(2000);
                String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-detail-bottom-top']")).getText();
                Thread.sleep(2000);
                System.out.println("the schedule of the selected studio is "+schedule);
                Thread.sleep(2000);

            }//end of the for loop

            //click on find studio

            driver.quit();

        }//end of main method



            }//end of Java class
}//end of java class
