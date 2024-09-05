package com.ozgurbayrasa.aopdemo.dao;

import com.ozgurbayrasa.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts(boolean tripWire);
    List<Account> findAccounts();
    void addAccount(Account theAccount, boolean isVip);

    boolean addSillyAccount();

    boolean doWork();

    String getName();

    void setName(String name) ;

    String getServiceCode();

    void setServiceCode(String serviceCode);


}
