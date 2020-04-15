package org.example.model.interfaces;

import org.example.model.Account;
import org.example.model.Owner;
import org.example.model.Transaction;

import java.util.List;

public interface IDataSaver {
    Owner getOwnerById(String id);

    void addOwner(Owner owner);

    Account getAccountById(int id);

    List<Account> getAccountsByOwner(String owner);

    void addAccount(Account account);

    Transaction getTransactionByAccountId(int accountId);

    void addTransaction(Transaction transaction);

    Double getBalanceByAccount(Integer accountId);

    void setBalanceByAccount(Integer accountId, Double balance);
}
