package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookTest {
    private Book book;

    @Before
    public void onBefore(){
         book = generateBook();
    }

    @Test
    public void  TestBookCreation(){
        String bookName = "The Great Gatsby";
        String bookAuthor = "F. Scott Fitzgerald";
        Integer bookYearPublished = 1925;
        assertEquals(bookName, book.bookName);
        assertEquals(bookAuthor, book.bookAuthor);
        assertEquals(bookYearPublished, book.bookYearPublished);
    }

    @Test
    public void TestBookShouldMarkAsCheckout(){
        Boolean marked = book.checkout();
        assertEquals(true, marked);
        assertEquals(true, book.checkedout);
    }

    @Test
    public void TestBookShouldDefaultAsNotCheckout(){
        assertEquals(false, book.checkedout);
    }

    @Test
    public void TestCheckedOutBookCannotBeCheckoutAgain(){

        Boolean initialCheckout = book.checkout();
        Boolean repeatCheckout = book.checkout();

        assertEquals(true, initialCheckout);
        assertEquals(false, repeatCheckout);
    }


    @Test
    public void TestBookCanBeReturned(){
        book.checkout();
        Boolean wasReturned = book.giveBack();
        assertEquals(true, wasReturned);
        assertEquals(false, book.checkedout);

    }

    @Test
    public void TestReturnedBookCannotBeGivenBack(){
        Boolean giveBack = book.giveBack();
        assertEquals(false, giveBack);
    }


    private Book generateBook(){
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        return book;
    }


}
