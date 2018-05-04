package com.twu.biblioteca;

import com.twu.biblioteca.menuItems.BookManagerCheckoutMenuItem;
import com.twu.biblioteca.BookManager;
import com.twu.biblioteca.menuItems.BookManagerGiveBackMenuItem;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookManagerGiveBackMenuItemTest {



    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private BookManagerGiveBackMenuItem bookManagerGiveBackMenuItem;
    private BookManager bookManager;



    @Before
    public void onBefore(){
        this.bookManager = mock(BookManager.class);
        this.bookManagerGiveBackMenuItem  = new BookManagerGiveBackMenuItem("Give Back Book", bookManager);

    }

    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Give Back Book", this.bookManagerGiveBackMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetBookDetailsForGiveback(){
        this.bookManagerGiveBackMenuItem.wasSelected();
        verify(bookManager, times(1)).getBookDetailsAndGiveBack();
    }




}
