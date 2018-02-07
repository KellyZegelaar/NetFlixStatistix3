package library.dataAccess.daoFiles;

import library.domain.Movie;

import java.util.ArrayList;

public interface MovieDaoInf {
    ArrayList<Movie> readMovies();
    ArrayList<Movie> readWatchedMovies();
}
