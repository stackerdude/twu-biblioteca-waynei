package com.twu.biblioteca.modelManagers;

import com.twu.biblioteca.models.Movie;


import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    public ArrayList<Movie> movies;

    public MovieManager(ArrayList<Movie> movies) {
        this.movies = movies;

    }

    public ArrayList<String> getMoviesInColumnFormat() {

        ArrayList<String> movies = new ArrayList<String>();
        for(Movie movie : this.movies){
            if(!movie.isCheckedOut()){
                movies.add(movie.getMovieName() + "     " + movie.getMovieDirector()+ "     "+movie.getMovieRelease() + "     " + movie.getMovieRating());
            }
        }
        return movies;
    }

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

    public Movie getMovieFromLibrary(Movie inputMovie) {

        for(Movie movie : movies){
            if(movie.is(inputMovie) != null){
                return movie;
            }
        }
        return null;    }


    public void listMovies() {
        ArrayList<String> formattedMovies = getMoviesInColumnFormat();
        for (String movieString : formattedMovies){
            System.out.println(movieString);
        }
    }


}
