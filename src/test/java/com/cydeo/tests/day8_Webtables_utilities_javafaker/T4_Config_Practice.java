package com.cydeo.tests.day8_Webtables_utilities_javafaker;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T4_Config_Practice {

//    public WebDriver driver;
//
//    @BeforeMethod
//    public void setUpMethod(){
//        String browserType = ConfigurationReader.getProperty("browser");
//        // driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser")); --> We don't have to create a VAR
//        driver = WebDriverFactory.getDriver(browserType);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//    }

    @Test
    public void google_search_Box(){
        Driver.getDriver().get("https://www.google.com");
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception{
        Thread.sleep(1000);
        Driver.getDriver().close();
    }
}
