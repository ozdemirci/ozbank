package com.bank.atm.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAccountRequest extends BaseAccountRequest {

    private String id;

}
