package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {

    private Movie movie;

    @Before
    public void onBefore(){
        this.movie = generateMovie();
    }

    @Test
    public void TestMovieCreation(){
        String movieName = "The Magnificent Seven";
        String movieDirector = "John Sturges";
        Integer movieRelease = 1960;
        Integer movieRating = 7;
        assertEquals(movieName, movie.getMovieName());
        assertEquals(movieDirector, movie.getMovieDirector());
        assertEquals(movieRelease, movie.getMovieRelease());
        assertEquals(movieRating, movie.getMovieRating());
    }

    @Test
    public void TestMovieShouldMarkAsCheckout(){
        String marked = movie.checkout();
        assertEquals("Thank you! Enjoy the movie.", marked);
        assertEquals(true, movie.isCheckedOut());
    }

    @Test
    public void TestMovieShouldDefaultAsNotCheckout(){
        assertEquals(false, movie.isCheckedOut());
    }



    @Test
    public void TestCheckedOutMovieCannotBeCheckoutAgain(){

        String initialCheckout = movie.checkout();
        String repeatCheckout = movie.checkout();

        assertEquals("Thank you! Enjoy the movie.", initialCheckout);
        assertEquals("That movie is not available.", repeatCheckout);
    }


    @Test
    public void TestMovieCanBeReturned(){
        movie.checkout();
        String wasReturned = movie.giveBack();
        assertEquals("Thank you for returning the movie.", wasReturned);
        assertFalse(movie.isCheckedOut());

    }


    @Test
    public void TestReturnedMovieCannotBeGivenBack(){
        String giveBack = movie.giveBack();
        assertEquals("That is not a valid movie to return.", giveBack);
    }

    @Test
    public void TestMovieIsMovie(){
        Movie movie1 = generateMovie();
        Movie movie2 = generateMovie();
        assertEquals(movie1, movie1.is(movie2));
    }

    @Test
    public void TestMovieIsNotMovie(){
        Movie movie1 = generateMovie();
        Movie movie2 = new Movie("Another Movie", "John Sturges", 1960, 7);
        assertNull(movie1.is(movie2));
    }





    private Movie generateMovie(){
        Movie movie = new Movie("The Magnificent Seven", "John Sturges", 1960, 7);
        return movie;
    }




}
