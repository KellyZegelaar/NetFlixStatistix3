package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Movie;

import java.sql.ResultSet;
import java.util.ArrayList;

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
}
