package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExitMenuItemTest {



    private ExitMenuItem exitMenuItem;
    UserManager userManager;


    @Before
    public void onBefore(){
        this.exitMenuItem  = new ExitMenuItem("Exit", userManager);
    }


    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Exit", this.exitMenuItem.getMenuItemName());
    }

}
