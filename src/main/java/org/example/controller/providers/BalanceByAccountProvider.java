package org.example.controller.providers;

import org.example.controller.interfaces.IInfoProvider;
import org.example.model.interfaces.IDataSaver;

public class BalanceByAccountProvider implements IInfoProvider<Double, Integer> {


    private final IDataSaver dataSaver;

    public BalanceByAccountProvider(IDataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public Double get(Integer accountId) {
        return dataSaver.getBalanceByAccount(accountId);
    }

    public void set(Integer accountId, Double balance) {
        dataSaver.setBalanceByAccount(accountId, balance);
    }
}
