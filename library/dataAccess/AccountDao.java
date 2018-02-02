package library.dataAccess;

public class AccountDao {
    private DatabaseConnection connection;

    public AccountDao(DatabaseConnection connection) {
        this.connection = connection;
    }
}
