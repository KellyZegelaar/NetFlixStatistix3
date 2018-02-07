package library.main;

import library.applicationLogic.AccountManager;
import library.dataAccess.DatabaseConnection;
import library.dataAccess.Factory;
import library.dataAccess.ProfileDao;
import library.presentation.StatistixUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        StatistixUI ui = new StatistixUI();

        //wat hieronder staat kan als het goed is later weg gewerkt worden\
        //de vraag is alleen hoe..
        //Als dit is gebeurd dan moet ook de import javax.swing.SwingUtilities weggehaald worden.
        SwingUtilities.invokeLater(ui);

        //this creates the databaseconnection
        DatabaseConnection connection = new DatabaseConnection();
        connection.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;");

        Factory factory = new Factory(connection);
        AccountManager accountManager = new AccountManager(factory);
        System.out.println(accountManager);


    }

}
