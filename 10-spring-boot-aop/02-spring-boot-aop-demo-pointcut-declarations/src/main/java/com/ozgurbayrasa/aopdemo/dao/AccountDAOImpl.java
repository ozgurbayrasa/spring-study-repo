package com.ozgurbayrasa.aopdemo.dao;

import com.ozgurbayrasa.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // Simulate an exception.
        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> accountList = new ArrayList<>();

        // Create sample accounts.
        accountList.add(new Account("Ozgur", "Silver"));
        accountList.add(new Account("Selim", "Gold"));
        accountList.add(new Account("Mustafa", "Platinum"));

        return accountList;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

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

    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
