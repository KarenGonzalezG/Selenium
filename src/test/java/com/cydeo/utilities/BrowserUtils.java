package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /**
     * This method will execute Thread.Sleep for the given duration
     * @param second
     * @Author:Karen
     */

    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     *  This method will switch between windows and verify expectedUrl and expectedTitle
     * @param driver
     * @param expectedInUrl
     * @param expectedInTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl,String expectedInTitle){
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for(String each : allWindowsHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    /**
     * This method will accept a String "ExpectedTitle" and verify if it is true
     * @param driver
     * @param expectedTitle
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

}
