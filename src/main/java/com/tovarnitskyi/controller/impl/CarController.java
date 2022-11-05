package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Car;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarController implements Controller<Car> {

    private final Service<Car> service = new CarService();

    @Override
    public List<Car> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Car findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Car car) throws SQLException {
        service.create(car);
    }

    @Override
    public void update(Integer id, Car car) throws SQLException {
        service.update(id, car);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
