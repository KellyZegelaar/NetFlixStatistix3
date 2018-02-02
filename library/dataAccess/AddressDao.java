package library.dataAccess;

public class AddressDao {
    private DatabaseConnection connection;

    public AddressDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
