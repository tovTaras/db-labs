package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.CustomerDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements Service<Customer> {

    private final DAO<Customer> dao = new CustomerDAO();

    @Override
    public List<Customer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Customer customer) throws SQLException {
        dao.create(customer);
    }

    @Override
    public void update(Integer id, Customer customer) throws SQLException {
        dao.update(id, customer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}