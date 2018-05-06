package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Book;
/**
 * Responsible for handling Returning/Giving back of books
 */
public class BookManagerGiveBackMenuItem extends MenuItemBase {
        private BookManager bookManager;

    public BookManagerGiveBackMenuItem(String menuItemName, BookManager bookManager, UserManager userManager) {
        super(menuItemName, userManager);
        this.bookManager = bookManager;
        this.setOnlyVisibleWhenLoggedIn(true);
    }
    /**
     * Captures the book information and attempts to give  it back
     * Prints success/error messages where appropriate
     */
    public void wasSelected() {

        Book userBook = this.bookManager.getBookDetails();
        Book libraryBook = this.bookManager.getBookFromLibrary(userBook);
        if(libraryBook != null){
            System.out.println(libraryBook.giveBack());
        }
        else{
            System.out.println("That is not a valid book to return.");

        }

    }
}
