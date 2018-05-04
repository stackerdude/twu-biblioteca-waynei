package com.twu.biblioteca.menuItems;
import com.twu.biblioteca.menuItems.BookManagerCheckoutMenuItem;
import com.twu.biblioteca.modelManagers.BookManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.contrib.java.lang.system.SystemOutRule;


public class BookManagerCheckoutMenuListTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private BookManagerCheckoutMenuItem bookManagerCheckoutMenuItem;
    private BookManager bookManager;



    @Before
    public void onBefore(){
        this.bookManager = mock(BookManager.class);
        this.bookManagerCheckoutMenuItem  = new BookManagerCheckoutMenuItem("Checkout Book", bookManager);

    }

    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Checkout Book", this.bookManagerCheckoutMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetBookDetailsForCheckout(){
        this.bookManagerCheckoutMenuItem.wasSelected();
        verify(bookManager, times(1)).getBookDetailsAndCheckout();
    }


}
