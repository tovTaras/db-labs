package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.CharacteristicsDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Characteristics;

import java.sql.SQLException;
import java.util.List;

public class CharacteristicsService implements Service<Characteristics> {

    private final DAO<Characteristics> dao = new CharacteristicsDAO();

    @Override
    public List<Characteristics> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Characteristics findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Characteristics characteristics) throws SQLException {
        dao.create(characteristics);
    }

    @Override
    public void update(Integer id, Characteristics characteristics) throws SQLException {
        dao.update(id, characteristics);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}