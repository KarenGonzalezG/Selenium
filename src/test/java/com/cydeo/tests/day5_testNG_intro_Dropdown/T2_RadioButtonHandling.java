package com.cydeo.tests.day5_testNG_intro_Dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButtonHandling {
    public static void main(String[] args) throws Exception{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons ");

        Thread.sleep(2000);

        //                                     Contains method --> //label[contains(.,'ckey')]
        WebElement hockeyRadioButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioButton.click();
        if(hockeyRadioButton.isSelected()){
            System.out.println("Hockey Radio Button is selected. Verification PASSED!");
        }else{
            System.out.println("Hockey Radio Button is not selected. Verification FAILED!");
        }

    Thread.sleep(2000);
        driver.close();


    }
}
/*TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */