package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Customer;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerController implements Controller<Customer> {

    private final Service<Customer> service = new CustomerService();

    @Override
    public List<Customer> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Customer customer) throws SQLException {
        service.create(customer);
    }

    @Override
    public void update(Integer id, Customer customer) throws SQLException {
        service.update(id, customer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}