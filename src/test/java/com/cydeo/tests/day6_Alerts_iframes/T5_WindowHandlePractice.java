package com.cydeo.tests.day6_Alerts_iframes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowHandlePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows ");
    }

    @Test
    public void multipleWindowTest(){

        // Storing the main pages window handle is good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle);
        // CDwindow-F4755BDACF9B3E87A812004491DFF39D

        //Assert title is "Windows"
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        System.out.println("Title before click: " +actualTitle);

        // Click to: "Click Here" link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        // Switch to new Window
        for(String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

        // Assert: Title is "New Window"
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);
        System.out.println("Title after Click: " + actualTitle);

        //If we want to go back to mai page, we can use already stored main handle
        // driver.switchTo().window(mainHandle)

    }

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(1000);
        driver.quit();
    }
}
/*TC #5: Window Handle practice

1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */