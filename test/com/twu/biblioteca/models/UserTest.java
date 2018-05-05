package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class UserTest
{

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();



    private User user;

    @Before
    public void onBefore(){
        user = new User("123-4567","Wayne Irwin", "wayne@gmail.com", "99999999", "hunter42");
    }

    @Test
    public void TestUserCreation(){
        String libraryNumber = "123-4567";
        String name = "Wayne Irwin";
        String email = "wayne@gmail.com";
        String phoneNumber = "99999999";
        String password = "hunter42";

        assertEquals(libraryNumber, user.getLibraryNumber());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(phoneNumber, user.getPhoneNumber());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void TestShouldAuthWithCorrectDetails(){
        String libraryNumber = "123-4567";
        String password = "hunter42";
        assertTrue(user.authenticate(libraryNumber, password));
    }

    @Test
    public void TestShouldNotAuthWithIncorrectDetails(){
        String libraryNumber = "123-4567";
        String password = "badPassword";
        assertFalse(user.authenticate(libraryNumber, password));
    }


    @Test
    public void TestUserCanPrintDetails(){
        this.user.printDetails();
        assertTrue(systemOutRule.getLog().contains("Wayne Irwin     wayne@gmail.com     99999999"));


    }


}
