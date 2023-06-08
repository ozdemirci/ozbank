package com.bank.atm.dto;

import com.bank.atm.model.City;
import com.bank.atm.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setAdress(customer.getAdress());
        customerDto.setCity(City.valueOf(customer.getCity().name()));

        return customerDto;
    }
}
