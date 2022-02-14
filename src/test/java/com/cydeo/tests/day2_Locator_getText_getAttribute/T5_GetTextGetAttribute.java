package com.cydeo.tests.day2_Locator_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_GetTextGetAttribute {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        WebElement headerText = driver.findElement(By.tagName("h2"));

       // Expected: Registration form
        String expectedText = "Registration form";
        String actualText = headerText.getText();

        if(actualText.equals(expectedText)){
            System.out.println("Header text Verification PASSED!");
        }else{
            System.out.println("Header text Verification FAILED!");
        }

      //  4- Locate “First name” input box
        WebElement firstNameInputBox = driver.findElement(By.name("firstname")); // Here we are locating the WebElement

        //5- Verify placeholder attribute’s value is as expected:
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInputBox.getAttribute("placeholder");

        if(expectedPlaceHolder.equals(actualPlaceHolder)){
            System.out.println("Placeholder test PASSED!");
        }else{
            System.out.println("Placeholder test FAILED!");
        }

        driver.close();


    }
}

/*TC #5: getText() and getAttribute() method practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name

 */