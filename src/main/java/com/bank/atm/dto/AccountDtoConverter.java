package com.bank.atm.dto;

import com.bank.atm.model.Account;
import com.bank.atm.model.City;
import com.bank.atm.model.Currency;

import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public AccountDto convert(Account account){

        return AccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .customerId(account.getCustomerId())
                .city(City.valueOf(account.getCity().name()))
                .build();
    }
}
