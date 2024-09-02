package com.ozgurbayrasa.aopdemo.dao;

import com.ozgurbayrasa.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean isVip);

    boolean addSillyAccount();

    boolean doWork();
}
