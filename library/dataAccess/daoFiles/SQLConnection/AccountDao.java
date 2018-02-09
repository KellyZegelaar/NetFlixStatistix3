package library.dataAccess.daoFiles.SQLConnection;

import library.dataAccess.daoFiles.AccountDaoInf;
import library.domain.Account;
import library.domain.Address;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDao implements AccountDaoInf {
    private DatabaseConnection connection;

    public AccountDao(DatabaseConnection connection) {
        this.connection = connection;
    }

    @Override
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
