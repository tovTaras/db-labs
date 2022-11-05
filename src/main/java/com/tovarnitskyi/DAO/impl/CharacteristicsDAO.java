package com.tovarnitskyi.DAO.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.model.Characteristics;
import com.tovarnitskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacteristicsDAO implements DAO<Characteristics> {
    private static final String GET_ALL = "SELECT * FROM mydb.Characteristics";
    private static final String GET_BY_ID = "SELECT * FROM mydb.Characteristics WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.Characteristics (car_id, serial_number, is_new, engine, milage, tank_volume, color, maintenance) VALUES (?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.car "
            + "SET car_id = ?, serial_number = ?, is_new = ?, engine = ?, milage = ?, tank_volume = ?, color = ?, maintenance = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.Characteristics WHERE (`id` = ?);";

    @Override
    public List<Characteristics> findAll() throws SQLException {
        List<Characteristics> characteristicss = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Characteristics characteristics = new Characteristics(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_id"),
                        resultSet.getString("serial_number"),
                        resultSet.getBoolean("is_new"),
                        resultSet.getString("engine"),
                        resultSet.getInt("milage"),
                        resultSet.getInt("tank_volume"),
                        resultSet.getString("color"),
                        resultSet.getString("maintenance"));

                characteristicss.add(characteristics);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return characteristicss;
    }

    @Override
    public Characteristics findById(Integer id) throws SQLException {
        Characteristics characteristics = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                characteristics = new Characteristics(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_id"),
                        resultSet.getString("serial_number"),
                        resultSet.getBoolean("is_new"),
                        resultSet.getString("engine"),
                        resultSet.getInt("milage"),
                        resultSet.getInt("tank_volume"),
                        resultSet.getString("color"),
                        resultSet.getString("maintenance"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return characteristics;
    }

    @Override
    public void create(Characteristics characteristics) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, characteristics.getCar_id());
            statement.setString(2, characteristics.getSerial_number());
            statement.setBoolean(3, characteristics.getIs_new());
            statement.setString(4, characteristics.getEngine());
            statement.setInt(5, characteristics.getMilage());
            statement.setInt(6, characteristics.getTank_volume());
            statement.setString(7, characteristics.getColor());
            statement.setString(8, characteristics.getMaintenance());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Characteristics characteristics) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, characteristics.getCar_id());
            statement.setString(2, characteristics.getSerial_number());
            statement.setBoolean(3, characteristics.getIs_new());
            statement.setString(4, characteristics.getEngine());
            statement.setInt(5, characteristics.getMilage());
            statement.setInt(6, characteristics.getTank_volume());
            statement.setString(7, characteristics.getColor());
            statement.setString(8, characteristics.getMaintenance());
            statement.setInt(9, characteristics.getId());
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
