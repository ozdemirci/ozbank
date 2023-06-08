package com.bank.atm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer   {

    @Id
    private String id;

    private String name;
    private Integer dateOfBirth;
    private City city;
    private String adress;





}
