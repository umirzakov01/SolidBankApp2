package com.example.solidbank;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@AllArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService{
    @Autowired
    private AccountDAO accountDAO;



    @Override
    public void create(String accountType, long bankID, String clientID, long accountID) {
 String id = String.format("%03d%06d",bankID,accountID);
 Account account = switch(accountType){
     case "SAVING" -> new SavingAccount(accountType,id,clientID,0);
     case "CHECKING" -> new CheckingAccount(accountType,id,clientID,0);
     case "FIXED" -> new FixedAccount(accountType,id,clientID,0);
     default -> throw new IllegalStateException("Unexpected value: " + accountType);
      };
     accountDAO.createNewAccount(account);
    }
}
