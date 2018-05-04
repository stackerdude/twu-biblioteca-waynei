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
        assertEquals(bookName, book.getBookName());
        assertEquals(bookAuthor, book.getBookAuthor());
        assertEquals(bookYearPublished, book.getBookYearPublished());
    }

    @Test
    public void TestBookShouldMarkAsCheckout(){
        String marked = book.checkout();
        assertEquals("Thank you! Enjoy the book.", marked);
        assertEquals(true, book.isCheckedout());
    }

    @Test
    public void TestBookShouldDefaultAsNotCheckout(){
        assertEquals(false, book.isCheckedout());
    }

    @Test
    public void TestCheckedOutBookCannotBeCheckoutAgain(){

        String initialCheckout = book.checkout();
        String repeatCheckout = book.checkout();

        assertEquals("Thank you! Enjoy the book.", initialCheckout);
        assertEquals("That book is not available.", repeatCheckout);
    }


    @Test
    public void TestBookCanBeReturned(){
        book.checkout();
        String wasReturned = book.giveBack();
        assertEquals("Thank you for returning the book.", wasReturned);
        assertFalse(book.isCheckedout());

    }

    @Test
    public void TestReturnedBookCannotBeGivenBack(){
        String giveBack = book.giveBack();
        assertEquals("That is not a valid book to return.", giveBack);
    }

    @Test
    public void TestBookIsBook(){
        Book book1 = generateBook();
        Book book2 = generateBook();
        assertEquals(book1, book1.is(book2));
    }

    @Test
    public void TestBookIsNotBook(){
        Book book1 = generateBook();
        Book book2 = new Book("A Different Book", "F. Scott Fitzgerald", 1925);
        assertNull(book1.is(book2));
    }


    private Book generateBook(){
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        return book;
    }


}
