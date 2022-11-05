package com.tovarnitskyi.controller.impl;

import com.tovarnitskyi.controller.Controller;
import com.tovarnitskyi.model.Characteristics;
import com.tovarnitskyi.service.Service;
import com.tovarnitskyi.service.impl.CharacteristicsService;

import java.sql.SQLException;
import java.util.List;

public class CharacteristicsController implements Controller<Characteristics> {

    private final Service<Characteristics> service = new CharacteristicsService();

    @Override
    public List<Characteristics> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Characteristics findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Characteristics characteristics) throws SQLException {
        service.create(characteristics);
    }

    @Override
    public void update(Integer id, Characteristics characteristics) throws SQLException {
        service.update(id, characteristics);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
