package com.polyglot.appaccount.controller;


import com.polyglot.appaccount.model.AccountModel;
import com.polyglot.appaccount.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;


    @GetMapping()
    public List<AccountModel> get() {

        return accountService.findAll();
    }
}