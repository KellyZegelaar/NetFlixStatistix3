package library.dataAccess;

public class MovieDao {
    private DatabaseConnection connection;

    public MovieDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
