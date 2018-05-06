package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
/**
 * Responsible for handling user logout
 */

public class UserManagerLogoutMenuItem extends MenuItemBase {


    public UserManagerLogoutMenuItem(String menuItemName, UserManager userManager) {
        super(menuItemName, userManager);
        this.setOnlyVisibleWhenLoggedIn(true);
    }

    public void wasSelected() {
        this.getUserManager().setLoggedIn(false);
    }
}
