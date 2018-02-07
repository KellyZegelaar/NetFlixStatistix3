package library.dataAccess.daoFiles;

import library.dataAccess.DatabaseConnection;
import library.domain.Account;
import library.domain.Address;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDao {
    private DatabaseConnection connection;

    public AccountDao(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ArrayList<Account> readAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        ResultSet rs = connection.executeSql("SELECT * FROM Account");

        try{
            while(rs.next()){
                accounts.add(new Account(rs.getString("Naam"), new Address(rs.getString("Straat"), rs.getString("Postcode"), rs.getString("Huisnummer"), rs.getString("Plaats")), rs.getString("Abonneenummer")));
            }
        } catch (Exception e){
            System.out.println("Database doesn't contain accounts");
        }
        return accounts;
    }
}
