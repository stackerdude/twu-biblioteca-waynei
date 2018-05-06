package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
/**
 * Responsible for handling user information display
 */
public class UserMangerUserDetailMenuItem extends MenuItemBase {

    public UserMangerUserDetailMenuItem(String menuItemName, UserManager userManager) {
        super(menuItemName, userManager);
        this.setOnlyVisibleWhenLoggedIn(true);
    }
    public void wasSelected() {
        this.getUserManager().getLoggedInUser().printDetails();
    }
}
