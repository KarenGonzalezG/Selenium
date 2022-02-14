package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC004_GetAttribute_CssSelector {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement resetButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        String expectedMessage = "Reset password";
        //String actualMessage = resetButton.getAttribute("value");
        String actualMessage = resetButton.getText();
        System.out.println(actualMessage);

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
/*TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */