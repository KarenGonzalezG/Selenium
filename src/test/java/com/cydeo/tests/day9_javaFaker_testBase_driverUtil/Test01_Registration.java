package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01_Registration {

    @Test
    public void registration_form_confirmation(){
        // Driver.getDriver() --> It will return a Driver instance
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.letterify("????##??");
        String fakePhone = faker.numerify("###-###-####");

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(fakeName);

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@placeholder='last name']"));
        lastName.sendKeys(fakeLastName);

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@placeholder='username']"));
        username.sendKeys(fakeName+fakeLastName);

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@placeholder='email@email.com']"));
        email.sendKeys(fakeEmail);

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='password']"));
        password.sendKeys(fakePassword);

        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='phone']"));
        phoneNumber.sendKeys(fakePhone);

        WebElement gender = Driver.getDriver().findElement(By.xpath("//div[@class='radio']//input[@value='male']"));
        gender.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='birthday']"));
        dateOfBirth.sendKeys("09/05/1990");

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText("MCR");

        Select select2 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        select2.selectByIndex(3);

        WebElement progLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        progLanguage.click();

        WebElement btn = Driver.getDriver().findElement(By.id("wooden_spoon"));
        btn.click();

        WebElement wellDone = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']//p"));
        String actualMessage = wellDone.getText();

        Assert.assertEquals(actualMessage,"You've successfully completed registration!","Message doesnt match");

    }
}
/*TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.

Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */