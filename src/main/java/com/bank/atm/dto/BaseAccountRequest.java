package com.bank.atm.dto;



import com.bank.atm.model.City;
import com.bank.atm.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseAccountRequest {


    private String customerId;
    private Double balance;
    private City city;
    private Currency currency;
}
