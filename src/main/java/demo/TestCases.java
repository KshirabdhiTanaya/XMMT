package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    // public  void testCase01(){
    //     System.out.println("Start Test case: testCase01");
    //     driver.get("https://www.google.com");
    //     System.out.println("end Test case: testCase02");
    // }
    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("makemytrip")) {
            System.out.println("URL verification passed: " + currentUrl);
        } else {
            System.out.println("URL verification failed: " + currentUrl);
        }
        System.out.println("End Test case: testCase01");
    }
    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/ ");
        Thread.sleep(3000);

        driver.findElement(By.id("fromCity")).click();
        WebElement departureLocation = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departureLocation.click();
        departureLocation.sendKeys("blr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='calc60']")).click();
        Thread.sleep(2000);

        WebElement arrivalLocation = driver.findElement(By.id("toCity"));
        arrivalLocation.sendKeys("DEL");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='calc60']")).click();
        Thread.sleep(2000);

        WebElement depatureDate = driver.findElement(By.xpath("(//p[text()='29'])[2]/parent::div"));
        depatureDate.click();
        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')]"));
        searchButton.click();

        WebElement flightDetails = driver.findElement(By.xpath("(//div[@class='makeFlex'])[2]"));
        String flightDetailsData = flightDetails.getText();
        System.out.print("Flight details : " + flightDetailsData + " ");

        WebElement flightPrice = driver.findElement(By.xpath("//div[contains(@class,'clusterViewPrice')]"));
        String flightPriceAdult = flightPrice.getText();
        System.out.println("Flight Price:" + flightPriceAdult);

    }
    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/ ");
        Thread.sleep(3000);
        driver.findElement(By.className("menu_Trains")).click();

        driver.findElement(By.id("fromCity")).click();
        WebElement departureLocation = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departureLocation.click();
        departureLocation.sendKeys("ypr");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='makeFlex']")).click();
        Thread.sleep(2000);

        WebElement arrivalLocation = driver.findElement(By.xpath("//input[@placeholder='To']"));
        arrivalLocation.sendKeys("ndls");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='makeFlex']")).click();
        Thread.sleep(2000);

        WebElement depatureDate = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        depatureDate.click();

        driver.findElement(By.xpath("//li[@data-cy='3A']")).click();

        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')]"));
        searchButton.click();

        WebElement trainDetails = driver.findElement(By.xpath("//div[@class='flex train-info']"));
        String trainDetailsData = trainDetails.getText();
        System.out.println("Train details : " + trainDetailsData + " ");

        WebElement trainPrice = driver.findElement(By.xpath("//div[contains(@class,'ticket-price')]"));
        String price = trainPrice.getText();
        System.out.println("3AC train Price:" + price);

    }
    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/ ");
        Thread.sleep(3000);
        driver.findElement(By.className("menu_Buses")).click();

        driver.findElement(By.id("fromCity")).click();
        WebElement departureLocation = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departureLocation.click();
        departureLocation.sendKeys("bangl");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='makeFlex column']")).click();
        Thread.sleep(2000);

        WebElement arrivalLocation = driver.findElement(By.xpath("//input[@placeholder='To']"));
        arrivalLocation.sendKeys("del");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='makeFlex column']")).click();
        Thread.sleep(2000);

        WebElement depatureDate = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        depatureDate.click();

        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();
         
        WebElement error = driver.findElement(By.xpath("//span[@class='error-title']"));
        String errorMessage = error.getText();
        if(errorMessage.equals("No buses found for 29 Mar")){
            System.out.println("TestCase pass");

        }else{
            System.out.println("TestCase Fail");
        }
    }
}
  

