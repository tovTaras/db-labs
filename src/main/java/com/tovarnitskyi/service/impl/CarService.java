package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.CarDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService implements Service<Car> {

    private final DAO<Car> dao = new CarDAO();

    @Override
    public List<Car> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Car findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Car car) throws SQLException {
        dao.create(car);
    }

    @Override
    public void update(Integer id, Car car) throws SQLException {
        dao.update(id, car);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
