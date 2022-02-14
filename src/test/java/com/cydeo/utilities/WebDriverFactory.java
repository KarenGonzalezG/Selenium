package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver = null;

// Method to set up the Driver Browser
    public static WebDriver getDriver(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            getDriver = new ChromeDriver(); //return = new ChromeDriver();
            getDriver.manage().window().maximize();
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            getDriver = new FirefoxDriver();
            getDriver.manage().window().maximize();
        }else{
            System.out.println("Given Browser Type doesn't exist/or is not currently supported");
            getDriver = null;
        }
        return getDriver;
    }

    



}

//// TASK: NEW METHOD CREATION
//// Method name : getDriver
//// Static method
//// Accepts String arg: browserType
////   - This arg will determine what type of browser is opened
////   - if "chrome" passed --> it will open chrome browser
////   - if "firefox" passed --> it will open firefox browser
//// RETURN TYPE: "WebDriver"
