package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;

public class ExitMenuItem extends MenuItemBase {

    public ExitMenuItem(String menuItemName,UserManager userManager) {
        super(menuItemName, userManager);
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    public void wasSelected() {
        System.exit(0);
    }
}
