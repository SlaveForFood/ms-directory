package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Tier;

import java.util.List;

public interface TierService {
    void create(Tier tier);

    List<Tier> getAll();

    Tier getById(Integer id);

    String update(Tier tier);
    boolean delete(Integer id);
}
