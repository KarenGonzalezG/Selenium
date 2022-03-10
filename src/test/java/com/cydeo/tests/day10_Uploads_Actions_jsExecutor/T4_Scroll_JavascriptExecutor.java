package com.cydeo.tests.day10_Uploads_Actions_jsExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T4_Scroll_JavascriptExecutor {

    @Test 
    public void scroll_Test(){
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        // Downcast version
        // ((JavascriptExecutor)Driver.getDriver()).executeScript();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //  X and Y(Up positive numbers, down Negative Numbers) Axis
        for(int i = 0 ; i< 10 ; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }

        BrowserUtils.sleep(1);

        for(int i = 0 ; i< 10 ; i++) {
            js.executeScript("window.scrollBy(0,-750)");
        }

    }
}

/*TC #6: Scroll using JavascriptExecutor
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times
JavaScript method to use : window.scrollBy(0,0)
 */