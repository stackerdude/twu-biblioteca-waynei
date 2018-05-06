package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;
/**
 * Responsible for handling user login
 */
public class UserManagerLoginMenuItem extends MenuItemBase{


    public UserManagerLoginMenuItem(String menuItemName, UserManager userManager) {
        super(menuItemName, userManager);
        this.setOnlyVisibleWhenLoggedIn(false);
    }

    /**
     * Capture the infomation needed to log the user in
     */
    public void wasSelected() {
        User user = this.getUserManager().getUserDetailsAndLogin();
        if(user != null){
            this.getUserManager().setLoggedIn(true);
            this.getUserManager().setLoggedInUser(user);
        }
    }
}
