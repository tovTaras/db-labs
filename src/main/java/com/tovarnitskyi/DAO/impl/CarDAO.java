package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Car;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car>{
    private static final String GET_ALL = "SELECT * FROM mydb.car";
    private static final String GET_BY_ID = "SELECT * FROM mydb.car WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.car (seller_id, class_of_car, brand, model, is_sold) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.car "
            + "SET seller_id = ?, class_of_car = ?, brand = ?, model = ?, is_sold = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.car WHERE (`id` = ?);";

    @Override
    public List<Car> findAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getInt("id"),
                        resultSet.getInt("seller_id"),
                        resultSet.getString("class_of_car"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getBoolean("is_sold"));
                cars.add(car);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return cars;
    }
    @Override
    public Car findById(Integer id) throws SQLException {
        Car car = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car = new Car(
                        resultSet.getInt("id"),
                        resultSet.getInt("seller_id"),
                        resultSet.getString("class_of_car"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getBoolean("is_sold"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return car;
    }
    @Override
    public void create(Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, car.getSeller_id());
            statement.setString(2, car.getClass_of_car());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setBoolean(5, car.getIs_sold());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, car.getSeller_id());
            statement.setString(2, car.getClass_of_car());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setBoolean(5, car.getIs_sold());
            statement.setInt(6, car.getId());
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
