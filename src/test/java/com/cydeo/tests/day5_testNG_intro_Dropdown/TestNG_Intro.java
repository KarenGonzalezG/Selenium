package com.cydeo.tests.day5_testNG_intro_Dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUpMethod(){
        System.out.println("---> Before Class is Running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After Class is Running");
    }


    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method is Running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method is Running");
    }

    @Test // ( priority = 1) --> In case we need a structure
    public void test1(){
        System.out.println("Test 1 is running...");
        // ASSERT EQUALS: Compare 2 of the same things
        String actual = "apple";
        String expected = "apple";
       // Assert.assertEquals(actual,expected);
        Assert.assertTrue(actual.equals(expected));
    }


    @Test // ( priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");
    }

}
