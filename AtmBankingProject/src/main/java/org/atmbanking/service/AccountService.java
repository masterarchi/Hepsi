package org.atmbanking.service;

import org.atmbanking.repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(){
        this.accountRepository=new AccountRepository();
    }

    public void createAccount(){

    }

}
