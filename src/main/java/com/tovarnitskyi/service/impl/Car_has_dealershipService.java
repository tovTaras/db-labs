package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.Car_has_dealershipDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Car_has_dealership;

import java.sql.SQLException;
import java.util.List;

public class Car_has_dealershipService implements Service<Car_has_dealership> {

    private final DAO<Car_has_dealership> dao = new Car_has_dealershipDAO();

    @Override
    public List<Car_has_dealership> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Car_has_dealership findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Car_has_dealership car_has_dealership) throws SQLException {
        dao.create(car_has_dealership);
    }

    @Override
    public void update(Integer id, Car_has_dealership car_has_dealership) throws SQLException {
        dao.update(id, car_has_dealership);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}