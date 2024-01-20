package com.example.solidbank;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
public class TransactionDepositCLI {
 TransactionDeposit transactionDeposit;
 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
 AccountListingService accountListingService;

    public void depositMoney(String clientID){
        double amount = withdrawDepositOperationCLIUI.requestCLientAmount();
        String accountID= withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account= accountListingService.getClientAccount(clientID, accountID);
        if(account == null){
            System.out.print("Account does not exist by this ID");
            return;
        }
        transactionDeposit.execute(account,amount);
    }
}
