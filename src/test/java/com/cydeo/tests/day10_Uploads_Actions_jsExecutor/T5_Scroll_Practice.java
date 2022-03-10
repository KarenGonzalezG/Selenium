package com.cydeo.tests.day10_Uploads_Actions_jsExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T5_Scroll_Practice {

    @Test
    public void task_4_and_5_test(){
        Driver.getDriver().get("https://practice.cydeo.com/");

        Actions moveToPowered = new Actions(Driver.getDriver());

        WebElement poweredByCydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));

        moveToPowered.moveToElement(poweredByCydeo).perform();

        moveToPowered.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        Driver.closeDriver();
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }
}
/*TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method

TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */
