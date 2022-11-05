package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Seller;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.SellerService;

import java.sql.SQLException;
import java.util.List;

public class SellerController implements Controller<Seller> {

    private final Service<Seller> service = new SellerService();

    @Override
    public List<Seller> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Seller findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Seller seller) throws SQLException {
        service.create(seller);
    }

    @Override
    public void update(Integer id, Seller seller) throws SQLException {
        service.update(id, seller);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
