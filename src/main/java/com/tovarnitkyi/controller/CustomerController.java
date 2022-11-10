package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.CustomerDTO;
import com.tovarnitkyi.mapper.CustomerMapper;
import com.tovarnitkyi.model.Customer;
import com.tovarnitkyi.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomer().stream().map(CustomerMapper::mapCustomerToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CustomerMapper.mapCustomerToDTO(customer), HttpStatus.OK);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return CustomerMapper.mapCustomerToDTO(customerService.createCustomer(customerDTO));
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.getCustomerById(customerDTO.getId());
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CustomerMapper.mapCustomerToDTO(customerService.updateCustomer(customerDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CustomerMapper.mapCustomerToDTO(customerService.deleteCustomerById(id)), HttpStatus.OK
        );
    }

}