package com.twu.biblioteca.menuItems;

import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.modelManagers.UserManager;
import com.twu.biblioteca.models.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MovieManagerCheckoutMenuItemTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private MovieManagerCheckoutMenuItem movieManagerCheckoutMenuItem;
    private MovieManager movieManager;
    UserManager userManager;



    @Before
    public void onBefore(){
        this.movieManager = mock(MovieManager.class);
        this.movieManagerCheckoutMenuItem  = new MovieManagerCheckoutMenuItem("Checkout Movie", movieManager, userManager);

    }


    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Checkout Movie", this.movieManagerCheckoutMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetMovieDetails(){
        this.movieManagerCheckoutMenuItem.wasSelected();
        verify(movieManager, times(1)).getMovieDetails();
    }








}
