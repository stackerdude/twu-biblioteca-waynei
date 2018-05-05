package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserManagerLogoutMenuItemTest {

    private UserManagerLogoutMenuItem userManagerLogoutMenuItem;
    UserManager userManager = mock(UserManager.class);


    @Before
    public void onBefore(){
        this.userManagerLogoutMenuItem  = new UserManagerLogoutMenuItem("Logout", userManager);
    }


    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Logout", this.userManagerLogoutMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallLogOut(){
        this.userManagerLogoutMenuItem.wasSelected();
        verify(this.userManager, times(1)).setLoggedIn(false);
    }


}
