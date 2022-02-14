package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC002_NextBaseCRM_getAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://login1.nextbasecrm.com");

        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String actualText = rememberMe.getText();
        String expectedText = "Remember me on this computer";

        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        actualText = forgotPassword.getText(); // The text we get from the Website is in UpperCase
        expectedText = "forgot your password?";

        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

       //5- Verify “forgot password” href attribute’s value contains expected:

        String expectedInHrf = "forgot_password=yes";
        String actualInHrf = forgotPassword.getAttribute("href");

        if(actualInHrf.contains(expectedInHrf)){
            System.out.println("Successful!");
        }else{
            System.out.println("Failed :( ");
        }



    }
}
/*TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/
        3- Verify “remember me” label text is as expected:
        Expected: Remember me on this computer
        4- Verify “forgot password” link text is as expected:
        Expected: Forgot your password?
        5- Verify “forgot password” href attribute’s value contains expected:
        Expected: forgot_password=yes

        PS: Inspect and decide which locator you should be using to locate web
        elements.
 */