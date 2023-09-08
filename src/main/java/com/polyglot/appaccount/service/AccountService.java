package com.polyglot.appaccount.service;

import com.polyglot.appaccount.model.AccountModel;
import com.polyglot.appaccount.respository.IAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountRepository accountRepository;

    @Override
    public List<AccountModel> findAll() {
        return  (List<AccountModel>)accountRepository.findAll();
    }

    @Override
    @Transactional
    public AccountModel update(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    @Override
    public AccountModel findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

}