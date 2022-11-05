package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.OrderDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements Service<Order> {

    private final DAO<Order> dao = new OrderDAO();

    @Override
    public List<Order> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Order order) throws SQLException {
        dao.create(order);
    }

    @Override
    public void update(Integer id, Order order) throws SQLException {
        dao.update(id, order);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}