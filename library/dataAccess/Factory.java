package library.dataAccess;

public class Factory {
    private DatabaseConnection connection;

    public Factory(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ProfileDao createProfileDao(){
        ProfileDao profileDao = new ProfileDao(connection);
        return profileDao;
    }

    public AccountDao createAccountDao(){
        AccountDao accountDao = new AccountDao(connection);
        return accountDao;
    }
}
