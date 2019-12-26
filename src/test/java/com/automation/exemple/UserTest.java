package com.automation.exemple;

import com.automation.exemple.User;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class UserTest {

    private User user;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
        user = new User("Bob", 30);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After class");
        user = null;
    }

    @Test
    public void userNameTest(){
        assertEquals(user.getName(), "Bob");
    }

    @Test
    public void userAgeTest(){
        assertEquals(user.getAge(), 30);
    }

}
