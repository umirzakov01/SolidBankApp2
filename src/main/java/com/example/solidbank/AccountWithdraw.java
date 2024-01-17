package com.example.solidbank;

public class AccountWithdraw extends Account{
    public AccountWithdraw(String accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
