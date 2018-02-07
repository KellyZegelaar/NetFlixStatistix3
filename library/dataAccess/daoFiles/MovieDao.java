package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Movie;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class MovieDao implements MovieDaoInf {
    private DatabaseConnection connection;

    public MovieDao(DatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Movie> readMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        ResultSet rs = connection.executeSql("SELECT * FROM Film");
        try{
            while(rs.next()){
                movies.add(new Movie(rs.getString("Id"),rs.getString("Titel"),rs.getString("Leeftijdsindicatie"), rs.getString("Taal"), rs.getString("Tijdsduur"), rs.getString("Genre")));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return movies;
    }

    public ArrayList<Movie> readWatchedMovies(){
        ArrayList<Movie> movies = readMovies();
        ArrayList<Movie> watchedMovies = new ArrayList<>();

        ResultSet rs = connection.executeSql("SELECT * FROM BekekenFilm JOIN Film ON BekekenFilm.Id=Film.Id");

        try{
            while(rs.next()){
                for(Movie m: movies){
                    if(rs.getString("Id").equals(m.getId())){
                        m.addWatched(rs.getString("PercentageGezien"), rs.getString("Profielnaam"));
                        watchedMovies.add(m);
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("The database doesn't contain watched movies");
        }
        return watchedMovies;
    }
}
