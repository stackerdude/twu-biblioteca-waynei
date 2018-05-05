package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;

public class MovieManagerListMenuItem extends MenuItemBase {
    private MovieManager movieManager;

    public MovieManagerListMenuItem(String menuItemName, MovieManager movieManager,UserManager userManager) {
        super(menuItemName, userManager);
        this.movieManager = movieManager;
        this.setOnlyVisibleWhenLoggedIn(false);

    }

    public void wasSelected() {
        movieManager.listMovies();
    }
}
