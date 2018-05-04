package com.twu.biblioteca.menuItems;

abstract public class MenuItemBase implements MenuOption {

    private String menuItemName;

    public MenuItemBase(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemName() {
        return menuItemName;
    }
}
