package org.example.model.persistence;

import org.example.model.Account;
import org.example.model.Owner;
import org.example.model.Transaction;
import org.example.model.TransactionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class DataInMemory {
    private static DataInMemory INSTANCE;
    private HashMap<Integer, Double> balances;
    private List<Owner> owners;
    private List<Account> accounts;
    private List<Transaction> transactions;

    private DataInMemory() {
        owners = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
        balances = new HashMap<>();

        populateData();
    }

    private void populateData() {
        // Populate Owners
        Owner owner1 = new Owner("jperez");
        owners.add(owner1);

        // Populate Accounts
        Account account1 = new Account(12345, owner1.getId());
        owner1.addAccount(account1);
        accounts.add(account1);

        // Populate Transactions
        Transaction transaction1 = new Transaction(TransactionType.DEPOSIT, 10000.0, account1.getId());
        transactions.add(transaction1);
        account1.addTransaction(transaction1);

        Transaction transaction2 = new Transaction(TransactionType.WITHDRAW, 50.0, account1.getId());
        transactions.add(transaction2);
        account1.addTransaction(transaction2);

        balances.put(account1.getId(), 9950.0);
    }

    public static DataInMemory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataInMemory();
        }

        return INSTANCE;
    }

    public Optional<Owner> getOwnerById(String id) {
        return owners.stream().filter(owner -> owner.getId().equals(id)).findFirst();
    }

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public Optional<Account> getAccountById(int id) {
        return accounts.stream().filter(account -> account.getId() == id).findFirst();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        Optional<Owner> owner = getOwnerById(account.getOwnerId());
        if (owner.isPresent()) {
            owner.get().addAccount(account);
        }
    }

    public Optional<Transaction> getTransactionByAccountId(int accountId) {
        return transactions.stream().filter(transaction -> transaction.getAccountId() == accountId).findFirst();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        Optional<Account> account = getAccountById(transaction.getAccountId());
        if (account.isPresent()) {
            account.get().addTransaction(transaction);
        }
    }

    public Double getBalance(Integer accountId) {
        return balances.get(accountId);
    }

    public void setBalance(Integer accountId, Double balance) {
        balances.put(accountId, balance);
    }
}
