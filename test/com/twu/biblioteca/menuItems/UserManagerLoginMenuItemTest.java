package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserManagerLoginMenuItemTest {

    private UserManagerLoginMenuItem userManagerLoginMenuItem;
    UserManager userManager = mock(UserManager.class);


    @Before
    public void onBefore(){
        this.userManagerLoginMenuItem  = new UserManagerLoginMenuItem("Login", userManager);
    }


    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Login", this.userManagerLoginMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetUserDetailsAndLogin(){
        this.userManagerLoginMenuItem.wasSelected();
        verify(this.userManager, times(1)).getUserDetailsAndLogin();
    }




}
