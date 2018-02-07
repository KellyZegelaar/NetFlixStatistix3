package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Episode;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EpisodeDao implements EpisodeDaoInf {
    private DatabaseConnection connection;

    public EpisodeDao(DatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Episode> readEpisodes(){
        ArrayList<Episode> episodes = new ArrayList<>();
        ResultSet rs = connection.executeSql("SELECT * FROM Aflevering");
        try{
            while(rs.next()){
                episodes.add(new Episode(rs.getString("Id"), rs.getString("Serie"), rs.getString("Seizoen"), rs.getString("Titel"),rs.getString("Tijdsduur")));
            }
        } catch(Exception e) {
            System.out.println("Database doesn't contain episodes");
        }
        return episodes;
    }
}
