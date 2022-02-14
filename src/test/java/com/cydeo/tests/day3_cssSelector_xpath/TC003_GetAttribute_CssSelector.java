package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC003_GetAttribute_CssSelector {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://login1.nextbasecrm.com");

        // CSS LOCATOR
        // tagName[attribute='value']
        //WebElement logInButton = driver.findElement(By.Class"login-btn");
        WebElement LogInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String expectedText = "Log In";
        // Getting the value of the attribute
        String actualText = LogInButton.getAttribute("value");
        System.out.println(actualText);

        if(actualText.equals(expectedText)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }

        driver.close();
    }
}
/*TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */