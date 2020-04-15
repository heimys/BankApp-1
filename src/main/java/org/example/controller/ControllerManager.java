package org.example.controller;

import org.example.controller.interfaces.IAccountOperator;
import org.example.controller.interfaces.IInfoProvider;
import org.example.controller.operators.DepositOperator;
import org.example.controller.operators.WithdrawOperator;
import org.example.controller.providers.AccountsByOwnerProvider;
import org.example.controller.providers.BalanceByAccountProvider;
import org.example.model.persistence.DataSaverInMemory;

public class ControllerManager {

    public BankAccountController getAccountController() {
        IAccountOperator withdrawOperator = new WithdrawOperator(new DataSaverInMemory());
        IAccountOperator depositOperator = new DepositOperator(new DataSaverInMemory());
        BalanceByAccountProvider balanceByAccountProvider = new BalanceByAccountProvider(new DataSaverInMemory());
        return new BankAccountController(withdrawOperator, depositOperator, balanceByAccountProvider);
    }

    public OwnerController getOwnerController() {
        return new OwnerController(new AccountsByOwnerProvider(new DataSaverInMemory()));
    }
}
