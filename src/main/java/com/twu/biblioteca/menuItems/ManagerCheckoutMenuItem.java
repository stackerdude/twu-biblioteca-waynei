package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.LibraryItemManagerInterface;
import com.twu.biblioteca.modelManagers.UserManager;

import java.lang.annotation.ElementType;

public class ManagerCheckoutMenuItem extends MenuItemBase{

    private LibraryItemManagerInterface libraryManager;

    public ManagerCheckoutMenuItem(String menuItemName, LibraryItemManagerInterface manager, UserManager userManager) {
        super(menuItemName, userManager);
        this.libraryManager = manager;
        this.setOnlyVisibleWhenLoggedIn(true);

    }

    /**
     * Captures the  information and attempts to check it out from library
     * Prints success/error messages where appropriate
     */
    public void wasSelected() {
        this.libraryManager.checkoutItemPressed();
    }
}
