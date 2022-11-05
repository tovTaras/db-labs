package com.tovarnitskyi.service.impl;

import com.tovarnitskyi.DAO.DAO;
import com.tovarnitskyi.DAO.impl.SellerDAO;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.model.Seller;

import java.sql.SQLException;
import java.util.List;

public class SellerService implements Service<Seller> {

    private final DAO<Seller> dao = new SellerDAO();

    @Override
    public List<Seller> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Seller findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Seller seller) throws SQLException {
        dao.create(seller);
    }

    @Override
    public void update(Integer id, Seller seller) throws SQLException {
        dao.update(id, seller);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}