package com.example.solidbank;

public class AccountDeposit extends Account{
    public AccountDeposit(String accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
