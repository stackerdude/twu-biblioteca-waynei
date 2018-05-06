package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Movie;
/**
 * Responsible for handling Checking out of Movies
 */
public class MovieManagerCheckoutMenuItem extends MenuItemBase{

    private MovieManager movieManager;

    public MovieManagerCheckoutMenuItem(String menuItemName, MovieManager movieManager, UserManager userManager) {
        super(menuItemName, userManager);
        this.movieManager = movieManager;
        this.setOnlyVisibleWhenLoggedIn(true);

    }
    /**
     * Captures the book information and attempts to check it out from library
     * Prints success/error messages where appropriate
     */
    public void wasSelected() {
        Movie userMovie = this.movieManager.getMovieDetails();
        Movie libraryMovie = this.movieManager.getMovieFromLibrary(userMovie);
        if(libraryMovie != null){
            System.out.println(libraryMovie.checkout());
        }
        else{
            System.out.println("That movie is not available.");

        }
    }
}
