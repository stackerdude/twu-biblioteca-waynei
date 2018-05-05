package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;

public class BookManagerCheckoutMenuItem extends MenuItemBase{

    private BookManager bookManager;

    public BookManagerCheckoutMenuItem(String menuItemName, BookManager manager, UserManager userManager) {
        super(menuItemName, userManager);
        this.bookManager = manager;
        this.setOnlyVisibleWhenLoggedIn(true);

    }

    public void wasSelected() {
        Book userBook = this.bookManager.getBookDetails();
        Book libraryBook = this.bookManager.getBookFromLibrary(userBook);
        if(libraryBook != null){
            System.out.println(libraryBook.checkout());
        }
        else{
            System.out.println("That book is not available.");

        }
    }
}
