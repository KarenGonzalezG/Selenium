package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException{

        //1--> Set Up a Browser Driver
        WebDriverManager.chromedriver().setup();

        //2--> Create Instance of the Selenium WebDriver
        WebDriver driver = new ChromeDriver(); // --> This is the line opening an empty browser

        driver.manage().window().maximize(); // --> This line will maximize the browser size
        Thread.sleep(2000);
        driver.manage().window().fullscreen();

        //3--> Go to tesla.com
        driver.get("https://www.tesla.com");
        String currentTittle = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentTittle = " + currentTittle + "\ncurrentURL = " + currentURL);

        // Stop code Execution for 3 seconds

        Thread.sleep(3000);

        //4--> Use Selenium to Navigate Back (In this case to an Empty page)
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh(); // --> Refresh the website
        Thread.sleep(3000);

        // Use Navigate().to()
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        currentTittle= driver.getTitle();
        System.out.println("currentTittle = " + currentTittle);

        //--> Get current URL using selenium
        currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        driver.close(); // --> This will close the currently opened window
        // driver.quit(); //--> This will close all the opened windows
        // After using quit(), we can't execute any more line of codes. W will get "NoSuchSessionException".

    }
}
