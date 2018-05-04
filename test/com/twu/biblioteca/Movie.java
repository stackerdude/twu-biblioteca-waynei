package com.twu.biblioteca;


public class Movie extends LibraryItemBase {

    private Integer movieRating;


    public Movie(String movieName, String movieDirector, Integer movieRelease, Integer movieRating) {
        super(movieName, movieDirector, movieRelease);
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return this.getLibraryItemName();
    }

    public String getMovieDirector() {
        return this.getLibraryItemCreator();
    }

    public Integer getMovieRelease() {
        return this.getLibraryItemRelease();
    }

    public Integer getMovieRating() {
        return movieRating;
    }

    protected String getSuccessCheckout() {
        return "Thank you! Enjoy the movie.";
    }

    protected String getErrorCheckout() {
        return "That movie is not available.";
    }

    protected String getGiveBackSuccess() {
        return "Thank you for returning the movie.";
    }

    protected String getGiveBackError() {
        return "That is not a valid movie to return.";
    }

    public Movie is(Movie movie2) {
        if((movie2.getMovieName().equals(this.getMovieName())) && (movie2.getMovieDirector().equals(this.getMovieDirector()))
                && (movie2.getMovieRelease().equals(this.getMovieRelease())) && (movie2.getMovieRating().equals(this.getMovieRating()))){
            return this;
        }
        return null;    }
}

