package com.example.solidbank;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public void withdrawMoney(String clientID){
        double amount = withdrawDepositOperationCLIUI.requestCLientAmount();
        String accountID= withdrawDepositOperationCLIUI.requestClientAccountNumber();
        AccountWithdraw account= accountListing.getClientWithdrawAccount(clientID,accountID);
        if(account == null){
            System.out.print("Account does not exist by this ID");
            return;
        }
        transactionWithdraw.execute(account,amount);
    }
}
