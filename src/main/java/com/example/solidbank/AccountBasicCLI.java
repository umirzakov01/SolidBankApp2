package com.example.solidbank;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@AllArgsConstructor
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;



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
        //
        System.out.println(clientAccounts.stream().
                map(Objects::toString).
                collect(Collectors.joining(", \n")));
        System.out.println("]");
    }
}
