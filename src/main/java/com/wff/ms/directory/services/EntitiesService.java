package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Entities;

import java.util.List;

public interface EntitiesService {

    void create(Entities entities);

    List<Entities> getAll();

    Entities getById(Integer id);

    String update(Entities entities);
    boolean delete(Integer id);
}
