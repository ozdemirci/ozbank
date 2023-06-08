package com.bank.atm.dto;


import com.bank.atm.model.City;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateCustomerRequest extends BaseCustomerRequest {

    private String id;

}
