package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Order;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DAO<Order>{
    private static final String GET_ALL = "SELECT * FROM mydb.order";
    private static final String GET_BY_ID = "SELECT * FROM mydb.order WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.order (feedback, seller_id, customer_id) VALUES (?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.order "
            + "SET feedback = ?, seller_id = ?, customer_id = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.order WHERE (`id` = ?);";

    @Override
    public List<Order> findAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("feedback"),
                        resultSet.getInt("seller_id"),
                        resultSet.getInt("customerr_id"));
                orders.add(order);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return orders;
    }
    @Override
    public Order findById(Integer id) throws SQLException {
        Order order = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("feedback"),
                        resultSet.getInt("seller_id"),
                        resultSet.getInt("customerr_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return order;
    }
    @Override
    public void create(Order order) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, order.getFeedback());
            statement.setInt(2, order.getSeller_id());
            statement.setInt(3, order.getCustomer_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Order order) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, order.getFeedback());
            statement.setInt(2, order.getSeller_id());
            statement.setInt(3, order.getCustomer_id());
            statement.setInt(4, order.getId());
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
