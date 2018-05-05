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

public class MovieMangerGiveBackMenuItemTest {



    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private MovieManagerGiveBackMenuItem movieManagerGiveBackMenuItem;
    private MovieManager movieManager;
    UserManager userManager;





    @Before
    public void onBefore(){
        this.movieManager = mock(MovieManager.class);
        this.movieManagerGiveBackMenuItem  = new MovieManagerGiveBackMenuItem("Give Back Movie", movieManager, userManager);

    }

    @Test
    public void TestItemNameIsCorrect(){
        assertEquals("Give Back Movie", this.movieManagerGiveBackMenuItem.getMenuItemName());
    }

    @Test
    public void TestShouldCallGetMovieDetailsForGiveback(){
        this.movieManagerGiveBackMenuItem.wasSelected();
        verify(movieManager, times(1)).getMovieDetails();
    }



}
