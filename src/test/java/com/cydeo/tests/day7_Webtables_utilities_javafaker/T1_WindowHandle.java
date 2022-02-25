package com.cydeo.tests.day7_Webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandle {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void window_Handling_Test(){
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //Set<String> allWindowHandles = driver.getWindowHandles();
//                          : allWindowHandles --> It is the same Logic
        for(String eachTab : driver.getWindowHandles()){
            driver.switchTo().window(eachTab);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        String actualTitle = driver.getTitle();
        String expectedInTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(1000);
        driver.quit();
    }
}

/*TC #1: Window Handle practice
1. Create new test and make set-ups
2. Go to : https://www.amazon.com
3. Copy and paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”

Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
 */
