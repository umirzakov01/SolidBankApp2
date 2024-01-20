package com.example.solidbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountListingServiceImpl implements AccountListingService {
    @Autowired
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {}


    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, String accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }


}
