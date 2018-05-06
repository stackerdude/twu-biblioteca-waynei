package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.UserManager;
/**
 * Responsible for handling of book listing
 */
public class BookManagerListMenuItem extends MenuItemBase {

    private BookManager manager;

    public BookManagerListMenuItem(String menuItemName, BookManager manager, UserManager userManager) {
        super(menuItemName, userManager);
        this.manager = manager;
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    /**
     * Prints a list of books that are available
     */
    public void wasSelected() {
        manager.listItems();
    }
}

