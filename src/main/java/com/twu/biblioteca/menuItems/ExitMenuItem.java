package com.twu.biblioteca.menuItems;

public class ExitMenuItem extends MenuItemBase {

    public ExitMenuItem(String menuItemName) {
        super(menuItemName);
    }

    public void wasSelected() {
        System.exit(0);
    }
}
