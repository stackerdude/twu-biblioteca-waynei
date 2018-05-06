package com.twu.biblioteca.modelMangers;
import com.twu.biblioteca.modelManagers.MovieManager;
import com.twu.biblioteca.models.Movie;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MovieManagerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();



    private Movie movie;
    private ArrayList<Movie> movies;
    private MovieManager movieManager;

    @Before
    public void onBefore(){
        movie = new Movie("The Magnificent Seven", "John Sturges", 1960, 7);
        movies = new ArrayList<Movie>();
        movies.add(movie);
        movieManager = new MovieManager(movies)
        ;


    }

    @Test
    public void TestMovieManagerReturnsOneMovie(){

        assertEquals(1, movieManager.movies.size());
        assertEquals(movie, movieManager.movies.get(0));

    }


    @Test
    public void TestMovieManagerReturnsMoviesInColumns(){
        ArrayList<String> moviesInColumns = movieManager.getItemsInColumnFormat();
        assertEquals("The Magnificent Seven     John Sturges     1960     7", moviesInColumns.get(0));
    }



    @Test
    public void TestGetsTheDetailsOfAMovie(){
        systemInMock.provideLines("The Magnificent Seven","John Sturges","1960", "7");
        Movie movie = movieManager.getMovieDetails();
        assertEquals("The Magnificent Seven", movie.getMovieName());
        assertEquals("John Sturges", movie.getMovieDirector());

    }

    @Test
    public void TestAbleToRetriveMovieFromLibrary(){
        Movie libraryMovie = movieManager.getMovieFromLibrary(movie);
        assertNotNull(libraryMovie);
    }

    @Test
    public void TestNotAbleToIncorrectMovieFromLibrary(){
        Movie badMovie = new Movie("Bad Movie", "John Sturges", 1960, 7);
        Movie libraryMovie = movieManager.getMovieFromLibrary(badMovie);
        assertNull(libraryMovie);
    }




}
