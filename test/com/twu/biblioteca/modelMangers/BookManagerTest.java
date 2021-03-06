package com.twu.biblioteca.modelMangers;
import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;



import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;


public class BookManagerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();



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
        ArrayList<String> booksInColumns = bookManager.getItemsInColumnFormat();
        assertEquals("The Great Gatsby     F. Scott Fitzgerald     1925", booksInColumns.get(0));
    }

    @Test
    public void TestBookManagerShouldNotReturnCheckoutBooks(){
        book.checkout();
        assertEquals(0, bookManager.getItemsInColumnFormat().size());
    }



    @Test
    public void TestGetsTheDetailsOfABook(){
        systemInMock.provideLines("The Great Gatsby","F. Scott Fitzgerald","1925");
        Book book = bookManager.getBookDetails();
        assertEquals("The Great Gatsby", book.getBookName());
        assertEquals("F. Scott Fitzgerald", book.getBookAuthor());

    }

    @Test
    public void TestAbleToRetriveBookFromLibrary(){
        Book libraryBook = bookManager.getBookFromLibrary(book);
        assertNotNull(libraryBook);
    }

    @Test
    public void TestNotAbleToIncorrectBookFromLibrary(){
        Book badBook = new Book("Bad Book", "F. Scott Fitzger", 1925);
        Book libraryBook = bookManager.getBookFromLibrary(badBook);
        assertNull(libraryBook);
    }






}
