package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.DealershipDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Dealership;

import java.sql.SQLException;
import java.util.List;

public class DealershipService implements Service<Dealership> {

    private final DAO<Dealership> dao = new DealershipDAO();

    @Override
    public List<Dealership> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Dealership findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Dealership dealership) throws SQLException {
        dao.create(dealership);
    }

    @Override
    public void update(Integer id, Dealership dealership) throws SQLException {
        dao.update(id, dealership);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
