package library.applicationLogic;

import library.dataAccess.Factory;
import library.domain.Account;
import library.domain.Profile;

import java.util.ArrayList;

public class AccountManager {
    private Factory factory;
    private ArrayList<Account> accounts;

    public AccountManager(Factory factory) {
        this.factory = factory;
        readAccounts();
        addProfiles();
    }

    public void readAccounts(){
        accounts = factory.createAccountDao().readAccounts();
    }

    public void addProfiles() {
        ArrayList<Profile> profiles = factory.createProfileDao().readProfiles();

        for (Account a: accounts) {
            for (Profile p : profiles) {
                if(p.getSubscriberNumber().equals(a.getSubscriberNumber())){
                    a.addProfile(p);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AccountManager {" + accounts + "}";
    }
}
