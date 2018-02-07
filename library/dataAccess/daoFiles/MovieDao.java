package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;

public class MovieDao {
    private DatabaseConnection connection;

    public MovieDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
