package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Dealership;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.DealershipService;

import java.sql.SQLException;
import java.util.List;

public class DealershipController implements Controller<Dealership> {

    private final Service<Dealership> service = new DealershipService();

    @Override
    public List<Dealership> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Dealership findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Dealership dealership) throws SQLException {
        service.create(dealership);
    }

    @Override
    public void update(Integer id, Dealership dealership) throws SQLException {
        service.update(id, dealership);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
