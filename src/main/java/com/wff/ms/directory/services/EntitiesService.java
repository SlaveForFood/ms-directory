package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Entiti;
import java.util.List;

public interface EntitiesService {

  void create(Entiti entity);

  List<Entiti> getAll();

  Entiti getById(Integer id);

  String update(Entiti entity);

  void delete(Integer id);
}
