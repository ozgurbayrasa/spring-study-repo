package com.ozgurbayrasa.aopdemo.dao;

import com.ozgurbayrasa.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount, boolean isVip) {
        System.out.println(getClass() + ": DOING MY WORK: ADDING ACCOUNT");
    }

    @Override
    public boolean addSillyAccount() {
        System.out.println(getClass() + ": DOING MY WORK: ADDING SILLY ACCOUNT");

        return false;
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");

        return false;
    }
}
