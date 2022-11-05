package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Seller;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO implements DAO<Seller>{
    private static final String GET_ALL = "SELECT * FROM mydb.seller";
    private static final String GET_BY_ID = "SELECT * FROM mydb.seller WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.seller (first_name, last_name, cell_phone, email, adress) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.seller "
            + "SET first_name = ?, last_name = ?, cell_phone = ?, email = ?, adress = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.seller WHERE (`id` = ?);";

    @Override
    public List<Seller> findAll() throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seller seller = new Seller(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("cell_phone"),
                        resultSet.getString("email"),
                        resultSet.getString("adress"));
                sellers.add(seller);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return sellers;
    }
    @Override
    public Seller findById(Integer id) throws SQLException {
        Seller seller = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                seller = new Seller(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("cell_phone"),
                        resultSet.getString("email"),
                        resultSet.getString("adress"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return seller;
    }
    @Override
    public void create(Seller seller) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, seller.getFirst_name());
            statement.setString(2, seller.getLast_name());
            statement.setString(3, seller.getCell_phone());
            statement.setString(4, seller.getEmail());
            statement.setString(5, seller.getAdress());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Seller seller) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, seller.getFirst_name());
            statement.setString(2, seller.getLast_name());
            statement.setString(3, seller.getCell_phone());
            statement.setString(4, seller.getEmail());
            statement.setString(5, seller.getAdress());
            statement.setInt(6, seller.getId());
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
