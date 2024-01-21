package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.ArtifactCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactDto;
import com.wff.ms.directory.models.dto.update.ArtifactUpdateDto;
import com.wff.ms.directory.models.entity.Artifact;
import java.util.List;

/**
 * Интерфейс по работе с артефактами
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactService {

  /**
   * Создает артефакт {@link Artifact} из запроса {@link ArtifactCreateDto}
   *
   * @param artifactCreateDto запрос по созданию артефакта {@link ArtifactCreateDto}
   * @return dto созданного артефакта {@link ArtifactDto}
   */
  ArtifactDto create(ArtifactCreateDto artifactCreateDto);

  /**
   * Возвращает список всех артефактов {@link ArtifactDto}
   *
   * @return артефакты {@link ArtifactDto}
   */
  List<ArtifactDto> getAll();

  /**
   * Возвращает артефакт {@link ArtifactDto} по индивидуальному идентификатору артефакта {@link
   * Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   * @return артефакт {@link ArtifactDto}
   */
  ArtifactDto getById(Integer id);

  /**
   * Обновляет артефакт {@link Artifact} из запроса {@link ArtifactUpdateDto}
   *
   * @param artifactUpdateDto запрос по обновлению артефакта {@link ArtifactUpdateDto}
   * @return обновленный артефакт {@link ArtifactDto}
   */
  ArtifactDto update(ArtifactUpdateDto artifactUpdateDto);

  /**
   * Удаляет артефакт {@link Artifact} по индивидуальному идентификатору артефакта {@link Integer}
   *
   * @param id индивидуальный идентификатор артефакта {@link Integer}
   */
  void deleteById(Integer id);
}
