package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Episode;
import library.domain.Serie;


import java.sql.ResultSet;
import java.util.ArrayList;

public class SerieDao {
    private DatabaseConnection connection;

    public SerieDao(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ArrayList<Serie> readSerie(){
        ArrayList<Serie> series = new ArrayList<>();
//        ArrayList<Episode> episodes = readEpisodes();
        ResultSet rs = connection.executeSql("SELECT * FROM Serie");
        try{
            while(rs.next()){
                Serie serie = new Serie(rs.getString("Titel"), rs.getString("Leeftijdsindicatie"), rs.getString("Taal"), rs.getString("Genre"), rs.getString("Vergelijkbaar"));
//                for(Episode a: episodes){
//                    if(serie.getTitle().equals(a.getSerie())){
//                        serie.addEpisode(a);
//                    }
//                }
                series.add(serie);
            }
        } catch(Exception e) {
            System.out.println("Database doesn't contain tv shows");
        }
        return series;
    }
}
