package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Attributes;

import java.util.List;

public interface AttributesService {
    void create(Attributes attributes);

    List<Attributes> getAll();

    Attributes getById(Integer id);

    String update(Attributes attributes);
    boolean delete(Integer id);
}
