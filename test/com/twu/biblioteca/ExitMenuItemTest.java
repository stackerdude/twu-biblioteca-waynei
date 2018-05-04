package com.twu.biblioteca;

import com.twu.biblioteca.menuItems.BookManagerCheckoutMenuItem;
import com.twu.biblioteca.menuItems.ExitMenuItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ExitMenuItemTest {



    private ExitMenuItem exitMenuItem;


    @Before
    public void onBefore(){
        this.exitMenuItem  = new ExitMenuItem("Exit");
    }


    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Exit", this.exitMenuItem.getMenuItemName());
    }

}
