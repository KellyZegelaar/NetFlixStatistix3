package library.main;

import library.applicationLogic.AccountManager;
import library.dataAccess.DatabaseConnection;
import library.dataAccess.Factory;
import library.dataAccess.ProfileDao;
import library.presentation.StatistixUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){


        //this creates the databaseconnection
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;");

        Factory factory = new Factory(connection);
        AccountManager accountManager = new AccountManager(factory);

        StatistixUI ui = new StatistixUI(accountManager);
        SwingUtilities.invokeLater(ui);


    }

}
