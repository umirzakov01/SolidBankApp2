package com.example.solidbank;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID){
        String accountType= createAccountOperationUI.requestAccountType();
        if (accountType == null) {
            return;
        }
        bankCore.createNewAccount(accountType,clientID);
    }
    public void getAccounts(String clientID){
        List<Account> clientAccounts =accountListing.getClientAccounts(clientID);
        System.out.println("[");
        System.out.println(clientAccounts.stream().
                map(Objects::toString).
                collect(Collectors.joining(",")));
        System.out.println("]");
    }
}
