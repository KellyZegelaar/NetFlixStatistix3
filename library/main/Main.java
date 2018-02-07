package library.main;

import library.applicationLogic.AccountManager;
import library.applicationLogic.MovieManager;
import library.applicationLogic.SerieManager;
import library.dataAccess.DatabaseConnection;
import library.dataAccess.Factory;
import library.domain.Account;
import library.domain.Profile;
import library.presentation.StatistixUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){


        //this creates the databaseconnection
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;");

        Factory factory = new Factory(connection);
        AccountManager accountManager = new AccountManager(factory);
        SerieManager serieManager = new SerieManager(factory);
        MovieManager movieManager = new MovieManager(factory);

        StatistixUI ui = new StatistixUI(accountManager, movieManager, serieManager);

        for (Account a: accountManager.getAccounts()){
            for (Profile profile: a.getProfiles()){
                System.out.println(profile);
            }
        }


        SwingUtilities.invokeLater(ui);


    }

}
