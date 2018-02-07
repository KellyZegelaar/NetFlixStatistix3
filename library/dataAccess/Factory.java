package library.dataAccess;

import library.dataAccess.daoFiles.*;

public class Factory {
    private DatabaseConnection connection;

    public Factory(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ProfileDaoInf createProfileDao(){
        ProfileDaoInf profileDaoInf = new ProfileDao(connection);
        return profileDaoInf;
    }

    public AccountDaoInf createAccountDao(){
        AccountDaoInf accountDaoInf = new AccountDao(connection);
        return accountDaoInf;
    }

    public SerieDaoInf createSerieDao(){
        SerieDaoInf serieDaoInf = new SerieDao(connection);
        return serieDaoInf;
    }

    public EpisodeDaoInf createEpisodeDao(){
        EpisodeDaoInf episodeDaoInf = new EpisodeDao(connection);
        return episodeDaoInf;
    }
}
