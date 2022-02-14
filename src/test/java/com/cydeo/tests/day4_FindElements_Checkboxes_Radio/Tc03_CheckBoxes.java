package com.cydeo.tests.day4_FindElements_Checkboxes_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Tc03_CheckBoxes {
    public static void main(String[] args) throws Exception {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        System.out.println("Is the first CheckBox Selected? " + checkBox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("Is the second CheckBox Selected by Default? " + checkBox2.isSelected());

        //4. Click checkbox #1 to select it -  Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();

        // 6. Confirm checkbox #1 is SELECTED --> Confirm checkbox #2 is NOT selected.
        System.out.println("Is the first CheckBox Selected after clicking it? " + checkBox1.isSelected());
        System.out.println("Is the second CheckBox Selected after clicking it? " + checkBox2.isSelected());

        Thread.sleep(2000);
        driver.close();
    }
}
/*Practice: Checkboxes
1. Go to https://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.


 */
