package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.Movie;
/**
 * Responsible for handling Returning/Giving back of Movies
 */
public class MovieManagerGiveBackMenuItem extends MenuItemBase{

    private MovieManager movieManager;

    public MovieManagerGiveBackMenuItem(String menuItemName, MovieManager movieManager, UserManager userManager) {
        super(menuItemName, userManager);
        this.movieManager = movieManager;
        this.setOnlyVisibleWhenLoggedIn(true);

    }
    /**
     * Captures the movies information and attempts to give  it back
     * Prints success/error messages where appropriate
     */
    public void wasSelected() {
        Movie userMovie = this.movieManager.getMovieDetails();
        Movie libraryMovie = this.movieManager.getMovieFromLibrary(userMovie);
        if(libraryMovie != null){
            System.out.println(libraryMovie.giveBack());
        }
        else{
            System.out.println("That is not a valid movie to return.");

        }

    }
}
