package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;

/**
 * Responsible for handling of movies listing
 */
public class MovieManagerListMenuItem extends MenuItemBase {
    private MovieManager movieManager;

    public MovieManagerListMenuItem(String menuItemName, MovieManager movieManager,UserManager userManager) {
        super(menuItemName, userManager);
        this.movieManager = movieManager;
        this.setOnlyVisibleWhenLoggedIn(false);

    }


    /**
     * Prints a list of movies that are available
     */
    public void wasSelected() {
        movieManager.listItems();
    }
}
