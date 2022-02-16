package com.cydeo.tests.day5_testNG_intro_Dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws Exception{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(2000);

        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete Button is displayed after clicking");
        }else{
            System.out.println("Delete Button is NOT displayed after clicking");
        }
        Thread.sleep(2000);

        deleteButton.click();
        try{
            System.out.println(deleteButton.isDisplayed());
        }catch(StaleElementReferenceException e){
            e.printStackTrace();
        }


        Thread.sleep(2000);
        driver.close();

    }
}

/*TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
 */