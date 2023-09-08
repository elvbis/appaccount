package com.polyglot.appaccount.service;

import com.polyglot.appaccount.model.AccountModel;

import java.util.List;

public interface IAccountService {

    public List<AccountModel> findAll();
    public AccountModel findById (Integer id);
    public AccountModel update(AccountModel accountModel);
}