package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;

/**
 * Responsible for handling Exiting
 */
public class ExitMenuItem extends MenuItemBase {

    public ExitMenuItem(String menuItemName,UserManager userManager) {
        super(menuItemName, userManager);
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    /**
     * Exits the program
     */
    public void wasSelected() {
        System.exit(0);
    }
}
