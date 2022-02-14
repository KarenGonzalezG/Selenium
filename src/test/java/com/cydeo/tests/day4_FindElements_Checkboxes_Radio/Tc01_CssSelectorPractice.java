package com.cydeo.tests.day4_FindElements_Checkboxes_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tc01_CssSelectorPractice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice.cydeo.com/forgot_password");

                                // CssSelector Syntax No 2  a.nav-link
        WebElement home = driver.findElement(By.cssSelector("a[class='nav-link']"));
                                // CssSelector               a[href='/']
        String actual = home.getText();
        String expected= "Home";

        if (actual.equals(expected)){
            System.out.println("Verification PASSED!");
        }else{
            System.out.println("Verification FAILED!");
        }

        // Parent - Child
        WebElement headerForgotPassword = driver.findElement(By.cssSelector("div.example > h2"));

        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));

        WebElement inputBoxEmail = driver.findElement(By.xpath("//input[@name='email']"));
        // tagName[contains(@attribute,'value'] --> findElement(By.xpath(//input[contains(@pattern,'a-z0-9'))]


    }
}
/*DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible

Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
 */