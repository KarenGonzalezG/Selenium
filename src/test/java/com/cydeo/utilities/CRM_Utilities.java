package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    /**
     * This method will log-in with helpdesk1 user
     * when it is called
     * @param driver
     */

    public static void crm_login(WebDriver driver){
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login_btn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.sendKeys("helpdesk1@cybertekschool.com");
        password.sendKeys("UserUser");
        login_btn.click();
    }

    public static void crm_login(WebDriver driver,String username, String password){
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login_btn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.sendKeys(username);
        inputPassword.sendKeys(password);
        login_btn.click();
    }
}
