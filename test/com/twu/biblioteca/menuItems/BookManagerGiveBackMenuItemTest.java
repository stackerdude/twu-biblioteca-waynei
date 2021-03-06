package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;
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
    UserManager userManager;




    @Before
    public void onBefore(){
        this.bookManager = mock(BookManager.class);
        this.bookManagerGiveBackMenuItem  = new BookManagerGiveBackMenuItem("Give Back Book", bookManager, userManager);

    }

    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Give Back Book", this.bookManagerGiveBackMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetBookDetailsForGiveback(){
        this.bookManagerGiveBackMenuItem.wasSelected();
        verify(bookManager, times(1)).getBookDetails();
    }




}
