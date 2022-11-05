package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Dealership;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDAO implements DAO<Dealership>{
    private static final String GET_ALL = "SELECT * FROM mydb.Dealership";
    private static final String GET_BY_ID = "SELECT * FROM mydb.Dealership WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.Dealership (adress) VALUES (?);";
    private static final String UPDATE = "" + "UPDATE mydb.Dealership "
            + "SET adress = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.Dealership WHERE (`id` = ?);";

    @Override
    public List<Dealership> findAll() throws SQLException {
        List<Dealership> dealerships = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dealership dealership = new Dealership(
                        resultSet.getInt("id"),
                        resultSet.getString("adress"));
                dealerships.add(dealership);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dealerships;
    }
    @Override
    public Dealership findById(Integer id) throws SQLException {
        Dealership dealership = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dealership = new Dealership(
                        resultSet.getInt("id"),
                        resultSet.getString("adress"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dealership;
    }
    @Override
    public void create(Dealership dealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, dealership.getAdress());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Dealership dealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, dealership.getAdress());
            statement.setInt(2, dealership.getId());
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
