package com.example.solidbank;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList;
    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList.stream().filter(x->x.getClientID() == clientID).collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(Account account) {
this.accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Account accountToBeUpdated =accountList.stream()
                .filter(x-> Objects.equals(account.getId(),x.getId()))
                .findAny()
                .orElse(null);
        System.out.println("This feauture is not represented well in UML diagram");


    }

    @Override
    public List<Account> getCLientAccountsByType(String clientID, String accountType) {
        List<Account> accountsByType= this.accountList.stream()
                .filter(x->Objects.equals(x.getAccountType(),accountType))
                .filter(x->Objects.equals(x.getClientID(),clientID))
                .collect(Collectors.toList());

        return accountsByType;
    }


    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return (AccountWithdraw) accountList.stream()
                .filter(x->Objects.equals(x.getClientID(),clientID))
                .filter(x->Objects.equals(x.getId(),accountID))
                .filter(x->Objects.equals(x.getAccountType(),"CHECKING")||Objects.equals(x.getAccountType(),"SAVING"))
                .findAny()
                .orElse(null);
    }

    @Override
    public Account getCLientAccount(String clientID, String accountID) {
        return accountList.stream()
                .filter(x->Objects.equals(x.getClientID(),clientID))
                .filter(x->Objects.equals(x.getId(),accountID))
                .findAny()
                .orElse(null);
    }
}
