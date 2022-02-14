package com.cydeo.tests.day2_Locator_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com"); // we can also use driver.navigate().to(""https://practice.cydeo.com"")
        String expectedURL ="cydeo";
        String actualURL= driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL Verification PASSED!");
        }else{
            System.out.println("URL Verification FAILED!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Tittle verification PASSED!");
        }else{
            System.out.println("Tittle Verification FAILED!");
        }
        Thread.sleep(3000);



        driver.close();


    }
}
