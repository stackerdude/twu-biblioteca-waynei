package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookManager;

public class BookManagerCheckoutMenuItem extends MenuItemBase{

    private BookManager bookManager;

    public BookManagerCheckoutMenuItem(String menuItemName, BookManager manager) {
        super(menuItemName);
        this.bookManager = manager;
    }

    public void wasSelected() {
        System.out.println(this.bookManager.getBookDetailsAndCheckout());
    }
}
