package com.cydeo.tests.day7_WebTables_Properties;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void WebTableOrderVerify(){
//2. Verify Bob’s name is listed as expected.
        WebElement nameListed = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        String expectedNameListed = "Bob Martin";
        String actualNameListed = nameListed.getText();

        Assert.assertEquals(expectedNameListed,actualNameListed);

        WebElement bobDateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDateCell = "12/31/2021";
        String actualDateCell = bobDateCell.getText();

        Assert.assertEquals(expectedDateCell,actualDateCell);

    }

    // We use the utility method that we created
    @Test
    public void WebTableOrderVerify2(){

        String customerExpectedDate = "01/16/2021";
        String customerOrderDate = WebTableUtils.returnOrderDate(driver,"Bart Fisher");

        Assert.assertEquals(customerExpectedDate,customerOrderDate);
    }

    @Test
    public void WebTableOrderVerify3(){
        WebTableUtils.orderVerify(driver,"Bart Fisher","01/16/2021");
    }

    @AfterMethod
    public void turDown() throws Exception{
        Thread.sleep(1000);
        driver.close();
    }


}

/*TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021

 */