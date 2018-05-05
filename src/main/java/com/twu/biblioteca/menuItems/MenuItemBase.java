package com.twu.biblioteca.menuItems;

        import com.twu.biblioteca.modelManagers.UserManager;
        import com.twu.biblioteca.models.User;

abstract public class MenuItemBase implements MenuOption {

    private String menuItemName;
    private Boolean onlyVisibleWhenLoggedIn;
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

    public Boolean shouldDisplay() {
        if ((this.getUserManager().getLoggedIn()) || !this.getOnlyVisibleWhenLoggedIn()) {
            return true;
        }
        return false;
    }
}
