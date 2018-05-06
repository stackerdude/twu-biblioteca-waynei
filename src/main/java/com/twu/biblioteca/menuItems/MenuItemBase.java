package com.twu.biblioteca.menuItems;
import com.twu.biblioteca.modelManagers.UserManager;

/**
 * Abstract Base Class for all menu items
 */

abstract public class MenuItemBase {

    private String menuItemName; // Name that appears when displying options
    private Boolean onlyVisibleWhenLoggedIn; //Whether the item shows when not logged in
    private UserManager userManager;

    public MenuItemBase(String menuItemName, UserManager userManager) {
        this.menuItemName = menuItemName;
        this.userManager = userManager;
    }


    public String getMenuItemName() {
        return menuItemName;
    }

    public Boolean getOnlyVisibleWhenLoggedIn() {
        return onlyVisibleWhenLoggedIn;
    }

    public void setOnlyVisibleWhenLoggedIn(Boolean onlyVisibleWhenLoggedIn) {
        this.onlyVisibleWhenLoggedIn = onlyVisibleWhenLoggedIn;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Decides if to display the options
     * If logged in, all options are available, if not, uses getOnlyVisibleWhenLoggedIn to decide
     * @return Boolean
     */
    public Boolean shouldDisplay() {
        return ((this.getUserManager().getLoggedIn()) || !this.getOnlyVisibleWhenLoggedIn());
    }

    /**
     * Fucntion that gets called when the menu option is selected
     */
    abstract void wasSelected();
}
