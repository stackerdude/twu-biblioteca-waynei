package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.BookManager;
import com.twu.biblioteca.modelManagers.LibraryItemManagerInterface;
import com.twu.biblioteca.modelManagers.UserManager;

public class ManagerGiveBackMenuItem  extends MenuItemBase {
    private LibraryItemManagerInterface libraryManager;

    public ManagerGiveBackMenuItem(String menuItemName, LibraryItemManagerInterface manager, UserManager userManager) {
        super(menuItemName, userManager);
        this.libraryManager = manager;
        this.setOnlyVisibleWhenLoggedIn(true);
    }
    /**
     * Captures the information and attempts to give  it back
     * Prints success/error messages where appropriate
     */
    public void wasSelected() {
        this.libraryManager.returnItemPressed();

    }
}
