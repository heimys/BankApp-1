package org.example.model.persistence;

import org.example.model.Account;
import org.example.model.Owner;
import org.example.model.Transaction;
import org.example.model.interfaces.IDataSaver;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public class DataSaverInMemory implements IDataSaver {
    @Override
    public Owner getOwnerById(String id) {
        return DataInMemory.getInstance().getOwnerById(id).get();
    }

    @Override
    public void addOwner(Owner owner) {
        DataInMemory.getInstance().addOwner(owner);
    }

    @Override
    public Account getAccountById(int id) {
        return DataInMemory.getInstance().getAccountById(id).get();
    }

    @Override
    public List<Account> getAccountsByOwner(String owner) {
        return getOwnerById(owner).getAccounts();
    }

    @Override
    public void addAccount(Account account) {
        DataInMemory.getInstance().addAccount(account);
    }

    @Override
    public Transaction getTransactionByAccountId(int accountId) {
        return DataInMemory.getInstance().getTransactionByAccountId(accountId).get();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        DataInMemory.getInstance().addTransaction(transaction);
    }

    @Override
    public Double getBalanceByAccount(Integer accountId) {
        return DataInMemory.getInstance().getBalance(accountId);
    }

    @Override
    public void setBalanceByAccount(Integer accountId, Double balance) {
        DataInMemory.getInstance().setBalance(accountId, balance);
    }
}
