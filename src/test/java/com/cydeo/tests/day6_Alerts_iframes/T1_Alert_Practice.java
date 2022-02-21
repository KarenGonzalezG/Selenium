package com.cydeo.tests.day6_Alerts_iframes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alerts_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));

        String actual = resultMessage.getText();
        String expected = "You successfully clicked an alert";

        Assert.assertEquals(actual,expected,"Actual result is not as expected");
        // Assert.assertTrue(actual.isDisplayed(),"Result text is NOT displayed");
    }

    @Test
    public void test1(){

        WebElement test = driver.findElement(By.id("username"));


    }



    @AfterMethod
    public void tearDownMethod ()throws Exception{
        Thread.sleep(1000);
        driver.close();
    }


}
/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.

 TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.

TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.

 */