package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Customer;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer> {
    private static final String GET_ALL = "SELECT * FROM mydb.Customer";
    private static final String GET_BY_ID = "SELECT * FROM mydb.Customer WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.Customer (first_name, last_name, cell_phone, email) VALUES (?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.car "
            + "SET car_id = ?, serial_number = ?, is_new = ?, engine = ?, milage = ?, tank_volume = ?, color = ?, maintenance = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.Customer WHERE (`id` = ?);";

    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("cell_phone"),
                        resultSet.getString("email"));
                customers.add(customer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        Customer customer = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("cell_phone"),
                        resultSet.getString("email"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(Customer customer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setString(3, customer.getCell_phone());
            statement.setString(4, customer.getEmail());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Customer customer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setString(3, customer.getCell_phone());
            statement.setString(4, customer.getEmail());
            statement.executeUpdate();
            statement.setInt(5, customer.getId());
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
