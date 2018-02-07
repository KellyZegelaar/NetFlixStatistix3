package library.dataAccess;

import library.dataAccess.daoFiles.AccountDao;
import library.dataAccess.daoFiles.ProfileDao;
import library.dataAccess.daoFiles.ProfileDaoInf;

public class Factory {
    private DatabaseConnection connection;

    public Factory(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ProfileDaoInf createProfileDao(){
        ProfileDaoInf profileDaoInf = new ProfileDao(connection);
        return profileDaoInf;
    }

    public AccountDao createAccountDao(){
        AccountDao accountDao = new AccountDao(connection);
        return accountDao;
    }
}
