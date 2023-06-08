
package com.bank.atm.service;

import com.bank.atm.dto.CreateCustomerRequest;
import com.bank.atm.dto.CustomerDto;
import com.bank.atm.dto.CustomerDtoConverter;
import com.bank.atm.dto.UpdateCustomerRequest;
import com.bank.atm.model.City;
import com.bank.atm.model.Customer;
import com.bank.atm.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
       this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }


    public CustomerDto createCustomer(CreateCustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customer.setAdress(customerRequest.getAdress());
        customer.setCity(City.valueOf(customerRequest.getCity().name()));

        customerRepository.save(customer);

        return customerDtoConverter.convert(customer);
    }


    public List<CustomerDto> getAllCustomers() {
        return  customerRepository.
                findAll().
                stream().map(customerDtoConverter::convert).
                collect(Collectors.toList());
    }

    @Transactional
    public CustomerDto getCustomerById(String id) {
        return customerRepository.
                findById(id).
                map(customerDtoConverter::convert).
                orElse(new CustomerDto());
    }

    public void deleteCustomerById(String id) {
    customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomerById(String id, UpdateCustomerRequest  customerRequest) {

        Optional<Customer> customerOptional= customerRepository.findById(id);

        customerOptional.ifPresent(customer->{
            customer.setName(customerRequest.getName());
            customer.setCity(City.valueOf(customerRequest.getCity().name()));
            customer.setDateOfBirth(customerRequest.getDateOfBirth());
            customer.setAdress(customerRequest.getAdress());
            customerRepository.save(customer);
        });

        return  customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());
    }

    protected Customer getCustomerByid(String id){
        return  customerRepository.findById(id).orElse(new Customer());
    }
}
