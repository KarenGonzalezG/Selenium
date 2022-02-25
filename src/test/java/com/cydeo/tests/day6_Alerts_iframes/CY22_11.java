package com.cydeo.tests.day6_Alerts_iframes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CY22_11 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }


    @Test
    public void test1(){

        WebElement username = driver.findElement(By.xpath("//input[@class='login-inp' and @type='text']"));
        WebElement password = driver.findElement(By.xpath("//input[@class='login-inp' and @type='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn' and @type='submit' ]"));

        username.sendKeys("helpdesk66@cydeo.com");
        password.sendKeys("UserUser");
        loginBtn.click();

        WebElement userAvatar = driver.findElement(By.id("user-block"));
        userAvatar.click();
        WebElement myProfile = driver.findElement(By.linkText("My Profile"));
        myProfile.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://login2.nextbasecrm.com/company/personal/user/"),"current URL doesnt contain the expected URL");
        List<WebElement> actualList = driver.findElements(By.xpath(""));
        List<String> expectedList = new ArrayList<String>();
        expectedList.addAll(Arrays.asList("General","Drive","Tasks","Calendar","Conversations"));

    }



    @AfterMethod
    public void tearDownMethod ()throws Exception{
        Thread.sleep(1000);
        driver.close();
    }


}
