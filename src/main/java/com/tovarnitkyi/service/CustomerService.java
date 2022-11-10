package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.CustomerDTO;
import com.tovarnitkyi.mapper.CustomerMapper;
import com.tovarnitkyi.model.Customer;
import com.tovarnitkyi.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(CustomerMapper.mapDTOToCustomer(customerDTO));
    }

    public Customer updateCustomer(CustomerDTO customerDTO) {
        if (getCustomerById(customerDTO.getId()) != null) {
            return customerRepository.save(CustomerMapper.mapDTOToCustomer(customerDTO));
        }
        return null;
    }

    public Customer deleteCustomerById(Integer id) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customerRepository.deleteById(id);
            return customer;
        }
        return null;
    }
}

