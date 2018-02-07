package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;

public class SerieDao {
    private DatabaseConnection connection;

    public SerieDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
