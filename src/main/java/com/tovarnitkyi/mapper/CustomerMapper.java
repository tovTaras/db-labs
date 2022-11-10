package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.CustomerDTO;
import com.tovarnitkyi.model.Customer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerMapper {

    public static CustomerDTO mapCustomerToDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getCell_phone(),
                customer.getEmail()
        );
    }

    public static Customer mapDTOToCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getId(),
                customerDTO.getFirst_name(),
                customerDTO.getLast_name(),
                customerDTO.getCell_phone(),
                customerDTO.getEmail()
        );
    }
}
