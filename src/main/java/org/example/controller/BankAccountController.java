package org.example.controller;

import org.example.controller.interfaces.IAccountOperator;
import org.example.controller.interfaces.IInfoProvider;
import org.example.controller.providers.BalanceByAccountProvider;

public class BankAccountController {
    private BalanceByAccountProvider balanceByAccountProvider;
    private IAccountOperator withdrawOperator;
    private IAccountOperator depositOperator;

    public BankAccountController(IAccountOperator withdrawOperator, IAccountOperator depositOperator, BalanceByAccountProvider balanceByAccountProvider) {
        this.withdrawOperator = withdrawOperator;
        this.depositOperator = depositOperator;
        this.balanceByAccountProvider = balanceByAccountProvider;
    }

    public void withdraw(int accountId, double amount) {
        double balance = (double)this.balanceByAccountProvider.get(accountId);
        if (balance >= amount){
            this.withdrawOperator.execute(accountId, amount);
            this.balanceByAccountProvider.set(accountId, balance - amount);
        }
    }

    public void deposit(int accountId, double amount) {
        double balance = (double)this.balanceByAccountProvider.get(accountId);
        this.depositOperator.execute(accountId, amount);
        this.balanceByAccountProvider.set(accountId, balance + amount);
    }

    public double getBalance(int accountId) {
        return (double)this.balanceByAccountProvider.get(accountId);
    }
}
