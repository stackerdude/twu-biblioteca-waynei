package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;

public class BookManagerListMenuItem extends MenuItemBase {

    private BookManager manager;

    public BookManagerListMenuItem(String menuItemName, BookManager manager) {
        super(menuItemName);
        this.manager = manager;
    }

    public void wasSelected() {
        manager.listBooks();
    }
}

