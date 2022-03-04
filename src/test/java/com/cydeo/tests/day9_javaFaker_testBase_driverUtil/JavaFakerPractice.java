package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

import com.github.javafaker.Faker;
// Generate Fake Data
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        // Creating Faker object to reach methods
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.numerify = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify = " + faker.numerify("312-###-####"));
        System.out.println("faker.letterify = " + faker.letterify("??????")); // It will return random letters when we pass Question Marks
        System.out.println("faker.bothify = " + faker.bothify("##??-##??-##")); // ## -> Will give number / ? -> Will give letter
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
    }
}
