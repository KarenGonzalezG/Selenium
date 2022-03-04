package com.cydeo.tests.day8_Webtables_utilities_javafaker;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        // 1- Create the object of properties
        Properties properties = new Properties();

        //2- We need to open the file in Java memory
        FileInputStream file = new FileInputStream("configuration.properties");

        // 3- Load the properties Object using FileInputStream object
        properties.load(file);

        // 4- Use "properties" object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }
}
