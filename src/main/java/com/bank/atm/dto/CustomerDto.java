package com.bank.atm.dto;


import com.bank.atm.model.City;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private String id;
    private String name;
    private Integer dateOfBirth;
    private City city;
    private String adress;

}
