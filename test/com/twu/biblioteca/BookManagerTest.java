package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;



public class BookManagerTest {
    private Book book;
    private ArrayList<Book> books;
    private BookManager bookManager;

    @Before
    public void onBefore(){
         book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
         books = new ArrayList<Book>();
         books.add(book);
         bookManager = new BookManager(books);


    }
    @Test
    public void TestBookManagerReturnsOneBook(){

        assertEquals(1, bookManager.books.size());
        assertEquals(book, bookManager.books.get(0));

    }


    @Test
    public void TestBookManagerReturnsBooksInColumns(){
        ArrayList<String> booksInColumns = bookManager.getBooksInColumnFormat();
        assertEquals("The Great Gatsby     F. Scott Fitzgerald     1925", booksInColumns.get(0));
    }

    @Test
    public void TestBookManagerShouldNotReturnCheckoutBooks(){
        book.checkout();
        assertEquals(0, bookManager.getBooksInColumnFormat().size());
    }


}
