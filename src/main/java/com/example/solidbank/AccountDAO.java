package com.example.solidbank;

import java.util.List;

public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateAccount(Account account);
    List<Account> getCLientAccountsByType(String clientID,String accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID,String accountID);
    Account getCLientAccount(String clientID,String accountID);

}
