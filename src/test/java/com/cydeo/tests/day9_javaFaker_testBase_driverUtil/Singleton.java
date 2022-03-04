package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

public class Singleton {

    // 1- Create private constructor
    private Singleton(){}

    // 2 - Create private static String --> Prevent access and provide a getter method
    private static String word;

    // 3- This utility method will return the "word" in the way we want to return
    public static String getWord(){
        if(word == null){
            System.out.println("First time call. Word Object is null. Assigning value to it now");
            word = "Something";
        }else{
            System.out.println("Word already has value");
        }
        return word;
    }


}
