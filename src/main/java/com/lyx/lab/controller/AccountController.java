package com.lyx.lab.controller;

import com.lyx.lab.model.Account;
import com.lyx.lab.repository.AccountRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@Log4j2
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable(value = "id") Long accId) {
        log.info("id<{}>", accId);
        return accountRepository.findById(accId)
                .orElseThrow(() -> new RuntimeException("Account:" + "id=" + accId));
    }

    @PostMapping()
    public Account createUser(@Valid @RequestBody Account account) {
        log.info("account<{}>", account);
        return accountRepository.save(account);
    }

}
