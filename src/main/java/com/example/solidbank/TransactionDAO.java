package com.example.solidbank;

import java.util.List;

public interface TransactionDAO {
     List<Transaction> getTransactions();
     void addTransaction(Transaction transaction);
}
