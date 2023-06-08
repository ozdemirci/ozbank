package com.bank.atm.dto;



import com.bank.atm.model.City;
import com.bank.atm.model.Currency;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AccountDto {

    private String id;

    private String customerId;
    private Double balance;
    private City city;
    private Currency currency;

}
