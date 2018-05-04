package com.twu.biblioteca;
import com.twu.biblioteca.menuItems.BookManagerListMenuItem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;



public class BookManagerListMenuItemTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    private BookManagerListMenuItem bookManagerMenuItem;
    private BookManager bookManager;

    @Before
    public void onBefore(){
        this.bookManager = mock(BookManager.class);
        this.bookManagerMenuItem = new BookManagerListMenuItem("List Books", this.bookManager);

    }

    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("List Books", this.bookManagerMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallListInBookManager(){
        this.bookManagerMenuItem.wasSelected();
        verify(this.bookManager, times(1)).listBooks();
    }
}
