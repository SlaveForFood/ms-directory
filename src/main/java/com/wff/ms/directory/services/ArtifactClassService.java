package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.response.ArtifactClassDto;
import com.wff.ms.directory.models.dto.update.ArtifactClassUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactClass;
import java.util.List;

/**
 * Интерфейс по работе с классами артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactClassService {

  /**
   * Создает класс артефакта {@link ArtifactClass} по имени для нового класса {@link String}
   *
   * @param name имя нового артефакта {@link String}
   * @return dto созданного артефакта {@link ArtifactClassDto}
   */
  ArtifactClassDto create(String name);

  /**
   * Возвращает список всех артефактов {@link ArtifactClassDto}
   *
   * @return артефакты {@link ArtifactClassDto}
   */
  List<ArtifactClassDto> getAll();

  /**
   * Возвращает артефакт {@link ArtifactClassDto} по индивидуальному идентификатору класса артефакта
   * {@link Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   * @return артефакт {@link ArtifactClassDto}
   */
  ArtifactClassDto getById(Integer id);

  /**
   * Возвращает артефакт {@link ArtifactClassDto} по наименованию класса артефакта {@link String}
   *
   * @param name наименование класса артефакта {@link String}
   * @return артефакт {@link ArtifactClassDto}
   */
  ArtifactClassDto getByName(String name);

  /**
   * Обновляет артефакт {@link ArtifactClass} из запроса {@link ArtifactClassUpdateDto}
   *
   * @param artifactClassUpdateDto запрос по обновлению артефакта {@link ArtifactClassUpdateDto}
   * @return обновленный артефакт {@link ArtifactClassDto}
   */
  ArtifactClassDto update(ArtifactClassUpdateDto artifactClassUpdateDto);

  /**
   * Удаляет класс артефакта {@link ArtifactClass} по индивидуальному идентификатору класса
   * артефакта {@link Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   */
  void deleteById(Integer id);
}
