package com.bank.atm.controller;


import com.bank.atm.dto.CreateCustomerRequest;
import com.bank.atm.dto.CustomerDto;
import com.bank.atm.dto.UpdateCustomerRequest;
import com.bank.atm.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CreateCustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }
    /*
     {
      "id":"12313",
       "name":"Hakan",
       "dateOfBirth":1231,
        "city":"ANKARA",
        "adress":"Ev "
 }
     */

    @GetMapping("/hello")
    public ResponseEntity<String> get() {

        return ResponseEntity.ok("Hello World");
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable String id,
                                                      @RequestBody UpdateCustomerRequest updateCustomerRequest) {

        return ResponseEntity.ok(customerService.updateCustomerById(id,updateCustomerRequest));

    }

}
