package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Profile;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileDao implements ProfileDaoInf {
    private DatabaseConnection connection;

    public ProfileDao(DatabaseConnection connection) {
        this.connection = connection;

    }

    @Override
    public ArrayList<Profile> readProfiles(){
        ArrayList<Profile> profiles = new ArrayList<>();
        ResultSet rs = connection.executeSql("SELECT * FROM Profiel");

        try{
            while(rs.next()){
                profiles.add(new Profile(rs.getString("Profielnaam"), rs.getString("Geboortedatum"), rs.getString("AbonneeNummer")));
            }
        } catch (Exception e){
            System.out.println("Database doesn't contain profiles");
        }
        return profiles;
    }
}
