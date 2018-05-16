package com.twu.biblioteca.menuItems;
import com.twu.biblioteca.modelManagers.LibraryItemManagerInterface;
import com.twu.biblioteca.modelManagers.UserManager;

public class ManagerListMenuItem extends MenuItemBase {

    private LibraryItemManagerInterface libraryManager;

    public ManagerListMenuItem(String menuItemName, LibraryItemManagerInterface libraryManager, UserManager userManager) {
        super(menuItemName, userManager);
        this.libraryManager = libraryManager;
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    /**
     * Prints a list of books that are available
     */
    public void wasSelected() {
        libraryManager.listItems();
    }

}
