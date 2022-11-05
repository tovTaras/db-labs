package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Order;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderController implements Controller<Order> {

    private final Service<Order> service = new OrderService();

    @Override
    public List<Order> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Order findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Order order) throws SQLException {
        service.create(order);
    }

    @Override
    public void update(Integer id, Order order) throws SQLException {
        service.update(id, order);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
