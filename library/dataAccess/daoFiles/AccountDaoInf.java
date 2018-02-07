package library.dataAccess.daoFiles;

import library.domain.Account;

import java.util.ArrayList;

public interface AccountDaoInf {
    ArrayList<Account> readAccounts();
}
