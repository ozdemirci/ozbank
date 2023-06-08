package com.bank.atm.controller;


import com.bank.atm.dto.*;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountrController {
    private final AccountService accountService;

    public AccountrController(AccountService accountService) {
        this.accountService = accountService;
    }





    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {

        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccountById(@PathVariable String id,
                                                      @RequestBody UpdateAccountRequest updateAccountRequest) {

        return ResponseEntity.ok(accountService.updateAccountById(id,updateAccountRequest));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest accountRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<AccountDto> withdrawMoneyById(@PathVariable String id,
                                                             @PathVariable Double amount) {

        return ResponseEntity.ok(accountService.withdrawMoney(id,amount));
    }

    @PutMapping("/add/{id}/{amount}")
    public ResponseEntity<AccountDto> updateAccountAddMoneyById(@PathVariable String id,
                                                             @PathVariable Double amount) {

        return ResponseEntity.ok(accountService.addMoney(id,amount));
    }

}
