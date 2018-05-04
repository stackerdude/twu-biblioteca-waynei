package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;

public class BookManagerGiveBackMenuItem extends MenuItemBase {
        private BookManager bookManager;

    public BookManagerGiveBackMenuItem(String menuItemName, BookManager bookManager) {
        super(menuItemName);
        this.bookManager = bookManager;
    }

    public void wasSelected() {
            System.out.println(this.bookManager.getBookDetailsAndGiveBack());

    }
}
