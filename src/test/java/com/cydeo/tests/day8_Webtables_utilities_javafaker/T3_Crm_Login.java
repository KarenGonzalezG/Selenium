package com.cydeo.tests.day8_Webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_Crm_Login {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://login1.nextbasecrm.com/");
    }

    @Test
    public void crm_login_test(){
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login_btn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.sendKeys("helpdesk1@cybertekschool.com");
        password.sendKeys("UserUser");
        login_btn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void crm_login_test2(){
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login_btn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.sendKeys("helpdesk2@cybertekschool.com");
        password.sendKeys("UserUser");
        login_btn.click();

        BrowserUtils.verifyTitle(driver,"Portal");

    }

    @Test
    public void crm_login_test3(){
      //  CRM_Utilities.crm_login(driver);
        CRM_Utilities.crm_login(driver,"helpdesk2@cyberteckschool.com","UserUser");
        BrowserUtils.verifyTitle(driver,"(2) Portal");
    }

    @AfterMethod
    public void tearDownMethod()throws Exception{
        Thread.sleep(1000);
        driver.close();
    }


}
/*TC #3: Login scenario
 1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
Expected: Portal
USERNAME  PASSWORD
helpdesk1@cybertekschool.com  UserUser
Helpdesk2@cybertekschool.com  UserUser

 */