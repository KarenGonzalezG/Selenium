package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class SeleniumTest {
    public static void main(String[] args){
        // 1- Setting up the web driver manager
        // We create our browser driver
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.fireFoxDriver().setup();

        //2- create instance of the chrome driver
        WebDriver driver = new ChromeDriver(); //new FirefoxDriver();
        // --> This line will Open the Browser that we selected

        // 3 - Test if driver is working as expected

        driver.get("http://127.0.0.1:5500/Webstaurant.html"); // -->get is a method from WebDriver

        driver.findElement(By.id("burger")).click();
        driver.findElement(By.xpath("//div[@class='options']/input[@id='salad']")).click();
        driver.findElement(By.tagName("textarea")).sendKeys("this is a cool website. thank you Karen!!");
        System.out.println(driver.findElement(By.xpath("//strong[contains(.,'Let us know how you want your food!! ')]")).getText());
        assertTrue(driver.findElement(By.xpath("//strong[contains(.,'Let us know how you want your food!! ')]")).getText().contains("Let us know how you want your food!"));

        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByIndex(1);
        dropdown.selectByValue("mild");
        dropdown.selectByVisibleText("Pepper");
        driver.close();




    }
}
