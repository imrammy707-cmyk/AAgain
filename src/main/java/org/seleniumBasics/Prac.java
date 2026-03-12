package org.seleniumBasics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Prac {
    private static final Logger logger = LogManager.getLogger(Prac.class);
    static WebDriver driver;

    @BeforeMethod
    public void startUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        logger.info("Driver setup done");
        driver.get("https://www.flipkart.com/");
        logger.info("Site opened");
    }

    @Test
    public void test1() throws IOException {
        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//img[@class='_2puWtW _3a3qyb' and @alt='Electronics']"));
        actions.moveToElement(element).perform();
        logger.info("Moved to 1st element");
        String name="aditya";
        WebElement element1=driver.findElement(By.xpath("//div[@class='_16rZTH']/object/a[3]"));
        actions.moveToElement(element1).perform();
        logger.info("Moved to 2nd element {}{}",name,name);
        WebElement element2=driver.findElement(By.linkText("DSLR & Mirrorless"));
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        actions.moveToElement(element2).click().build().perform();
        WebElement element3=driver.findElement(By.xpath("//img[@alt='Canon EOS R50 V Mirrorless Camera Body withRF-S14-30mm F4-6.3IS STMPZ Lens' and @loading='eager']"));
        if (element3.isDisplayed())
        {
            FileHandler.copy(screenshotFile,new File(".//screenshots//ss.jpg"));
        }
        System.out.println("Hello bro");
        System.out.println(driver);


        System.out.println("Please create a pull reuest resource 1");


        System.out.println("morning update from resource 1 in console");


        System.out.println("Before lunch changes");


        System.out.println("Final update before EOD in console");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
