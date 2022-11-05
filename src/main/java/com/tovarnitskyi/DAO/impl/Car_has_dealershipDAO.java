package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Car_has_dealership;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Car_has_dealershipDAO implements DAO<Car_has_dealership>{
    private static final String GET_ALL = "SELECT * FROM mydb.car_has_dealership";
    private static final String GET_BY_ID = "SELECT * FROM mydb.car_has_dealership WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.car_has_dealership (car_id, dealership_id) VALUES (?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.car "
            + "SET car_id = ?, dealership_id = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.car_has_dealership WHERE (`id` = ?);";

    @Override
    public List<Car_has_dealership> findAll() throws SQLException {
        List<Car_has_dealership> cars_has_dealership = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car_has_dealership car_has_dealership = new Car_has_dealership(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_id"),
                        resultSet.getInt("dealership_id"));
                cars_has_dealership.add(car_has_dealership);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return cars_has_dealership;
    }
    @Override
    public Car_has_dealership findById(Integer id) throws SQLException {
        Car_has_dealership car_has_dealership = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car_has_dealership = new Car_has_dealership(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_id"),
                        resultSet.getInt("dealership_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return car_has_dealership;
    }
    @Override
    public void create(Car_has_dealership car_has_dealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, car_has_dealership.getCar_id());
            statement.setInt(2, car_has_dealership.getDealership_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Car_has_dealership car_has_dealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, car_has_dealership.getCar_id());
            statement.setInt(2, car_has_dealership.getDealership_id());
            statement.setInt(3, car_has_dealership.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }







}