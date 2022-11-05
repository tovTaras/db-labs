package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Car_has_dealership;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.Car_has_dealershipService;

import java.sql.SQLException;
import java.util.List;

public class Car_has_dealershipController implements Controller<Car_has_dealership> {

    private final Service<Car_has_dealership> service = new Car_has_dealershipService();

    @Override
    public List<Car_has_dealership> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Car_has_dealership findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Car_has_dealership car_has_dealership) throws SQLException {
        service.create(car_has_dealership);
    }

    @Override
    public void update(Integer id, Car_has_dealership car_has_dealership) throws SQLException {
        service.update(id, car_has_dealership);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
