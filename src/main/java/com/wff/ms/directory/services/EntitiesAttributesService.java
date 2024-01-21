package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.EntitiesAttributes;

import java.util.List;

public interface EntitiesAttributesService {
    void create(EntitiesAttributes entitiesAttributes);

    List<EntitiesAttributes> getAll();

    EntitiesAttributes getById(Integer id);

    String update(EntitiesAttributes entitiesAttributes);
    boolean delete(Integer id);
}
