package library.dataAccess.daoFiles.SQLConnection;

import library.dataAccess.daoFiles.EpisodeDaoInf;
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

    public ArrayList<Episode> readWatchedEpisodes(){
        ArrayList<Episode> episodes = readEpisodes();
        ArrayList<Episode> watchedEpisodes = new ArrayList<>();
        ResultSet rs = connection.executeSql("SELECT * FROM BekekenAflevering");
        try{
            while(rs.next()){
                for (Episode e: episodes){
                    if(rs.getString("Id").equals(e.getId())){
                        e.addWatched(rs.getString("PercentageGezien"), rs.getString("Profielnaam"));
                        if (!watchedEpisodes.contains(e)){
                            watchedEpisodes.add(e);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Database doesn't contain watched episodes");
        }

        return watchedEpisodes;
    }
}
