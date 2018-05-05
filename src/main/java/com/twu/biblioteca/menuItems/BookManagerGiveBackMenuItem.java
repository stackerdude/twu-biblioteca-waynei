package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;

public class BookManagerGiveBackMenuItem extends MenuItemBase {
        private BookManager bookManager;

    public BookManagerGiveBackMenuItem(String menuItemName, BookManager bookManager, UserManager userManager) {
        super(menuItemName, userManager);
        this.bookManager = bookManager;
        this.setOnlyVisibleWhenLoggedIn(true);
    }

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
