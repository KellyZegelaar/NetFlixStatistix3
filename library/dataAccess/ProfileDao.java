package library.dataAccess;

public class ProfileDao {
    private DatabaseConnection connection;

    public ProfileDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
