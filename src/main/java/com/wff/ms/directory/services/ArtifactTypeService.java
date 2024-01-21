package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.response.ArtifactTypeDto;
import com.wff.ms.directory.models.dto.update.ArtifactTypeUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactType;
import java.util.List;

/**
 * Интерфейс по работе с типами артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactTypeService {

  /**
   * Создает тип артефакта {@link ArtifactType} по имени для нового типа {@link String}
   *
   * @param name имя нового артефакта {@link String}
   * @return dto созданного артефакта {@link ArtifactTypeDto}
   */
  ArtifactTypeDto create(String name);

  /**
   * Возвращает список всех артефактов {@link ArtifactTypeDto}
   *
   * @return артефакты {@link ArtifactTypeDto}
   */
  List<ArtifactTypeDto> getAll();

  /**
   * Возвращает артефакт {@link ArtifactTypeDto} по индивидуальному идентификатору типа артефакта
   * {@link Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   * @return артефакт {@link ArtifactTypeDto}
   */
  ArtifactTypeDto getById(Integer id);

  /**
   * Возвращает артефакт {@link ArtifactTypeDto} по наименованию типа артефакта {@link String}
   *
   * @param name наименование типа артефакта {@link String}
   * @return артефакт {@link ArtifactTypeDto}
   */
  ArtifactTypeDto getByName(String name);

  /**
   * Обновляет артефакт {@link ArtifactType} из запроса {@link ArtifactTypeUpdateDto}
   *
   * @param artifactTypeUpdateDto запрос по обновлению артефакта {@link ArtifactTypeUpdateDto}
   * @return обновленный артефакт {@link ArtifactTypeDto}
   */
  ArtifactTypeDto update(ArtifactTypeUpdateDto artifactTypeUpdateDto);

  /**
   * Удаляет тип артефакта {@link ArtifactType} по индивидуальному идентификатору типа артефакта
   * {@link Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   */
  void deleteById(Integer id);
}
