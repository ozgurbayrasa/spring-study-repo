package com.ozgurbayrasa.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addMember() {
        System.out.println(getClass() + ": DOING MY WORK: ADDING A MEMBER");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep...");
    }
}
