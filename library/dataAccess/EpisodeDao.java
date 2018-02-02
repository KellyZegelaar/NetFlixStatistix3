package library.dataAccess;

public class EpisodeDao {
    private DatabaseConnection connection;

    public EpisodeDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
