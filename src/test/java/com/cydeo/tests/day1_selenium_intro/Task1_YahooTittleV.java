package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
/* TC01 -- Yahoo Tittle Verification
1. Open Chrome Browser
2. Go to https://www.yahoo.com
3. Verify Tittle
4. Expected Yahoo
*/

public class Task1_YahooTittleV {
    WebDriver driver= null;
    @Test
    public void testCaseForHeaderNav(){

    // Set up Chrome Driver
        WebDriverManager.chromedriver().setup();

    // Open Chrome Driver
     driver = new ChromeDriver();
    //Make our page fullScreen
        driver.manage().window().maximize();

    // Go to Yahoo
//        driver.get("https://www.yahoo.com");
//        // Getting the tittle from the Website
//        String expectedTittle= "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
//        String actualTittle = driver.getTitle();
//
//
//        if(actualTittle.equals(expectedTittle)){
//            System.out.println("Verification PASSED");
//        }else{
//            System.out.println("Verification FAILED");
//        }

        driver.get("https://www.uscis.gov");

    assertEquals(driver.getTitle(),"Home | USCIS");
    List<WebElement> list = SeleniumUtil.findElementsByXpath(driver,"//div[@class='region region-navigation']/nav/ul/li");
    ArrayList<String> expected = new ArrayList<>(Arrays.asList("Topics", "Forms", "Newsroom", "Citizenship", "Green Card", "Laws", "Tools"));
    int index = 0;
        for(
    WebElement we:list)

    {
        System.out.println(we.getText());
        SeleniumUtil.verify(we.getText(), expected.get(index++), "failed and actual is " + we.getText());
    }

        driver.close();

}

    @Test
    public void testCase2(){
// Set up Chrome Driver
        WebDriverManager.firefoxdriver().setup();

        // Open Chrome Driver
         driver = new FirefoxDriver();
        //Make our page fullScreen
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.tesla.com");
        driver.navigate().to("https://www.twitter.com");
        assertTrue(true);
        driver.close();
    }
    @Test
    public void testCase3(){
// Set up Chrome Driver
        WebDriverManager.safaridriver().setup();

        // Open Chrome Driver
         driver = new SafariDriver();
        //Make our page fullScreen
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.tesla.com");
        driver.navigate().to("https://www.twitter.com");
//        assertTrue(true);
        driver.close();
    }
}
