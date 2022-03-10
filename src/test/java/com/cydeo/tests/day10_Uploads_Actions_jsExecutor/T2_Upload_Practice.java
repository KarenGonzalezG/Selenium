package com.cydeo.tests.day10_Uploads_Actions_jsExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        String path ="/Users/karengonzalez/Documents/Cybertek/HTML Class/FastFood.jpeg";

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFile.sendKeys(path);

        WebElement upload = Driver.getDriver().findElement(By.id("file-submit"));
        upload.click();

        WebElement uploadMessage = Driver.getDriver().findElement(By.tagName("h3"));
        String actualMessage = uploadMessage.getText();
        Assert.assertEquals(actualMessage,"File Uploaded!","Uploaded message doesn't match");

    }
}

/*TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */
