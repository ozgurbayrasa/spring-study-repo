package com.ozgurbayrasa.aopdemo.dao;

import com.ozgurbayrasa.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean isVip);

    boolean addSillyAccount();

    boolean doWork();

    public String getName();

    public void setName(String name) ;

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
