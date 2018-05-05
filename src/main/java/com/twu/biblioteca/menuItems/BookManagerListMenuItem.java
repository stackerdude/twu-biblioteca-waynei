package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;

public class BookManagerListMenuItem extends MenuItemBase {

    private BookManager manager;

    public BookManagerListMenuItem(String menuItemName, BookManager manager, UserManager userManager) {
        super(menuItemName, userManager);
        this.manager = manager;
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    public void wasSelected() {
        manager.listBooks();
    }
}

