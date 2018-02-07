package library.applicationLogic;

import library.dataAccess.Factory;
import library.domain.Movie;

import java.util.ArrayList;

public class MovieManager {
    private Factory factory;
    private ArrayList<Movie> movies;

    public MovieManager(Factory factory) {
        this.factory = factory;
        readMovies();
    }

    public void readMovies(){
        movies = factory.createMovieDao().readMovies();
    }

    @Override
    public String toString() {
        return "MovieManager{" +
                "movies=" + movies +
                '}';
    }
}
