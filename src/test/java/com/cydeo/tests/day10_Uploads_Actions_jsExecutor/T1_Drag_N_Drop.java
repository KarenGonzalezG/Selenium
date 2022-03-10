package com.cydeo.tests.day10_Uploads_Actions_jsExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Drag_N_Drop {

    @Test
    public void Circle_Test1(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookies = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).perform();
         actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        String BigCircleText = bigCircle.getText();
        String expectedBigCircle = "You did great!";

        Assert.assertEquals(expectedBigCircle,BigCircleText,"Expected and actual text didn't match");

        Driver.closeDriver();
    }
}
/*TC #: Drag and drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */