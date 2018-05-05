package com.twu.biblioteca.modelMangers;

import com.twu.biblioteca.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserManagerTest {

    private com.twu.biblioteca.modelManagers.UserManager userManager;
    private User user;

    @Before
    public void onBefore(){
        user = new User("123-4567","Wayne Irwin", "wayne@gmail.com", "99999999", "hunter42");
        ArrayList <User> users = new ArrayList<User>();
        users.add(user);
        userManager = new com.twu.biblioteca.modelManagers.UserManager(users);
    }

    @Test
    public void TestUserManagerReturnsOneUser(){

        assertEquals(1, userManager.users.size());
        assertEquals(user, userManager.users.get(0));

    }

    @Test
    public void TestAuththenticateDetailsReturnUser(){
        User user = userManager.authenticateDetails("123-4567","hunter42");
        assertNotNull(user);
    }

    @Test
    public void TestAuththenticateDetailsReturnNull(){
        User user = userManager.authenticateDetails("123-4567","badPass");
        assertNull(user);
    }


}
