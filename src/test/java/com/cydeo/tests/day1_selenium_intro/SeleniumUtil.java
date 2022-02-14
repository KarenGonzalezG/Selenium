package com.cydeo.tests.day1_selenium_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SeleniumUtil {


    /**
     *
     * this method accepts the xpath as String
     * and driver as WebElement
     * and returns the List
     *
     * @author karen.gonzalez@test.com
     * @param driver
     * @param xpath
     * @return List
     */
    public static List<WebElement> findElementsByXpath(WebDriver driver,String xpath){
        return driver.findElements(By.xpath(xpath));
    }

    /**
     * @author karen.gonzalez@test.com
     * @param driver
     * @param id
     * @return List
     */
    public static List<WebElement> findElementsById(WebDriver driver,String id){
        return driver.findElements(By.id(id));
    }

    public static List<WebElement> findElementsByLocator(WebDriver driver,String locatorType,String locatorAsString){
        if (locatorType.equals("xpath")){
            return driver.findElements(By.xpath(locatorAsString));
        }
        if (locatorType.equals("id")){
            return driver.findElements(By.id(locatorAsString));
        }
        if (locatorType.equals("tagName")){
            return driver.findElements(By.tagName(locatorAsString));
        }


        return driver.findElements(By.id(locatorAsString));
    }

    /**
     *
     * @param actual
     * @param expected
     * @param message
     */
    public static void verify(String actual, String expected,String message){
        assertEquals(actual,expected);
    }
}
