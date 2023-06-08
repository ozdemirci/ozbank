package com.bank.atm.dto;

import com.bank.atm.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseCustomerRequest {
    private String name;
    private Integer dateOfBirth;
    private City city;
    private String adress;
}
