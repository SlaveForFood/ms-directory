package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.EntitiesTier;

import java.util.List;

public interface EntitiesTierService {

    void create(EntitiesTier entitiesTier);

    List<EntitiesTier> getAll();

    EntitiesTier getById(Integer id);

    String update(EntitiesTier entitiesTier);
    boolean delete(Integer id);
}
