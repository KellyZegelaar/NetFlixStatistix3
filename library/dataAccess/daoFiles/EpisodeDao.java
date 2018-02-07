package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;

public class EpisodeDao {
    private DatabaseConnection connection;

    public EpisodeDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
