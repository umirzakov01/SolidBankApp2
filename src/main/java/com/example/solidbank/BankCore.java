package com.example.solidbank;

public class BankCore {
    private static long id =1;
    private long lastAccountNumber=1;
    private AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }
    public void createNewAccount(String accountType,String clientID){
        accountCreation.create(accountType,id,clientID,lastAccountNumber);
        incrementLastAccount();
        System.out.println("Account have been created");


    }
    private void incrementLastAccount(){
        lastAccountNumber++;
    }
}
