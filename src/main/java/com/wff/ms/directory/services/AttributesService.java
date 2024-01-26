package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Attribute;
import java.util.List;

public interface AttributesService {
  void create(Attribute attribute);

  List<Attribute> getAll();

  Attribute getById(Integer id);

  String update(Attribute attribute);

  boolean delete(Integer id);
}
