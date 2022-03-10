package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

//Singleton
public class Driver {
    /*
    Creating a private constructor, so we are closing access to the object of this class
    from outside the class.
    */

    private Driver(){}; // --> Private Constructor

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method
     */

    private static WebDriver driver;
    /*
    Creates a re-usable utility method which will return same driver instance when calling it
    */
    public static WebDriver getDriver() {
        if (driver == null) {
            /*
            We read our BrowserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");
    /*
    Depending
    */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
/*
  This method will make sure our driver values is always null after using quit()method
 */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); //This line will terminate the existing session.Value will not even be null
            driver = null;
        }
    }
}
