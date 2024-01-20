package com.example.solidbank;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance()+amount);
    }
}
