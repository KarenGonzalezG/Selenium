package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC001_NextBase {
    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        //Go to: https://login1.nextbasecrm.com/
//        driver.get("https://login1.nextbasecrm.com");

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://login1.nextbasecrm.com");
        //Enter incorrect username: “incorrect”
        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("Incorrect");

        //Enter incorrect password: “incorrect”
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("Incorrect");

        // Click to log in button.
        driver.findElement(By.className("login-btn")).click();

        //Verify error message text is as expected:
        WebElement errorText = driver.findElement(By.className("errortext"));

        String actualErrorText = errorText.getText();
        String expectedErrorText = "Incorrect login or password";

        if(actualErrorText.equals(expectedErrorText)){
            System.out.println("Error Text Verification PASSED");
        }else{
            System.out.println("Error Text Verification FAILED");
        }

    }
}
/*TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
PS: Inspect and decide which locator you should be using to locate web elements.
 */