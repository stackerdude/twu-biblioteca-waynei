package com.twu.biblioteca.modelManagers;

import com.twu.biblioteca.models.Movie;


import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager implements LibraryItemManagerInterface{
    public ArrayList<Movie> movies;

    public MovieManager(ArrayList<Movie> movies) {
        this.movies = movies;

    }

    public ArrayList<String> getItemsInColumnFormat() {

        ArrayList<String> movies = new ArrayList<String>();
        for(Movie movie : this.movies){
            if(!movie.isCheckedOut()){
                movies.add(movie.getMovieName() + "     " + movie.getMovieDirector()+ "     "+movie.getMovieRelease() + "     " + movie.getMovieRating());
            }
        }
        return movies;
    }

    /**
     * Capture the information needed to query a movie
     * @return Captured Infomation parsed into a movie
     */
    public Movie getMovieDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Movie Name: ");
        String movieName = scanner.nextLine();
        System.out.print("Directors's Name: ");
        String directorName = scanner.nextLine();
        System.out.print("Release Year: ");
        Integer releaseYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Movie Rating: ");
        Integer movieRating = Integer.parseInt(scanner.nextLine());
        return new Movie(movieName,directorName , releaseYear, movieRating);
    }

    /**
     * Returns a Movie from the library if it exists
     * @param inputMovie The movie that was requested
     * @return LibraryMovie Movie that matches the request
     */
    public Movie getMovieFromLibrary(Movie inputMovie) {

        for(Movie movie : movies){
            if(movie.is(inputMovie) != null){
                return movie;
            }
        }
        return null;    }


    public void listItems() {
        ArrayList<String> formattedMovies = getItemsInColumnFormat();
        for (String movieString : formattedMovies){
            System.out.println(movieString);
        }
    }


}
