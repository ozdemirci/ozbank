
package com.bank.atm.service;

import com.bank.atm.dto.*;
import com.bank.atm.model.Account;
import com.bank.atm.model.City;
import com.bank.atm.model.Currency;
import com.bank.atm.model.Customer;
import com.bank.atm.repository.AccountRepository;
import com.bank.atm.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AccountService {

    private static final Logger logger= LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountDtoConverter accountDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;
    private final CustomerService customerService;

    public AccountService(CustomerRepository customerRepository, AccountRepository accountRepository, AccountDtoConverter accountDtoConverter, CustomerDtoConverter customerDtoConverter, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.accountDtoConverter = accountDtoConverter;
        this.customerDtoConverter = customerDtoConverter;
        this.customerService = customerService;
    }


    public AccountDto createAccount(CreateAccountRequest accountRequest){
        Customer customer= customerService.getCustomerByid(accountRequest.getCustomerId());

        if(customer.getId()==null || customer.getId().equals("")) {
            return new AccountDto();
        }
            Account account = Account.builder()
                    .id(accountRequest.getId())
                    .customerId(accountRequest.getCustomerId())
                    .balance(accountRequest.getBalance())
                    .city(accountRequest.getCity())
                    .currency(accountRequest.getCurrency())
                    .build();

            return accountDtoConverter.convert(accountRepository.save(account));
    }

    public AccountDto updateAccountById(String id, UpdateAccountRequest  accountRequest) {
        Customer customer= customerService.getCustomerByid(accountRequest.getCustomerId());

        if(customer.getId()==null || customer.getId().equals("")) {
            return new AccountDto();
        }

        Optional<Account> accountOptional= accountRepository.findById(id);

        accountOptional.ifPresent(account->{
            account.setCustomerId(accountRequest.getCustomerId());
            account.setBalance(accountRequest.getBalance());
            account.setCity(City.valueOf(accountRequest.getCity().name()));
            account.setCurrency(Currency.valueOf(accountRequest.getCurrency().name()));

           accountRepository.save(account);

        });
        return  accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

    public List<AccountDto> getAllAccount() {
        return  accountRepository.
                findAll().
                stream().map(accountDtoConverter::convert).
               collect(Collectors.toList());
    }

    @Transactional
    public AccountDto getAccountById(String id) {
        return accountRepository.
                findById(id).
                map(accountDtoConverter::convert).
                orElse(new AccountDto());
    }

    public void deleteAccountById(String id) {
    accountRepository.deleteById(id);
    }
    public AccountDto withdrawMoney(String id,Double amount){
        Optional<Account> accountOptional=accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
           if(account.getBalance()>=amount) {
               account.setBalance(account.getBalance()-amount);
               accountRepository.save(account);
           }else{
              logger.atTrace().log("Yeterli bakiyeniz yok");
           }
        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }

    public AccountDto addMoney(String id,Double amount){
        Optional<Account> accountOptional=accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
              account.setBalance(account.getBalance()+amount);
              accountRepository.save(account);
        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }


}
