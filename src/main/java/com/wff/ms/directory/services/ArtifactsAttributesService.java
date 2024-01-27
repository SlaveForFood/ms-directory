package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.ArtifactsAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactsAttributesDto;
import com.wff.ms.directory.models.dto.update.ArtifactsAttributesUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactsAttributes;
import java.util.List;

/**
 * Интерфейс по работе со связью артефактов и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactsAttributesService {

  /**
   * Создает связь артефакта и атрибута {@link ArtifactsAttributes} из запроса {@link
   * ArtifactsAttributesCreateDto}
   *
   * @param artifactsAttributesCreateDto запрос по созданию связи артефакта и атрибута {@link
   *     ArtifactsAttributesCreateDto}
   * @return dto созданной связи артефакта и атрибута {@link ArtifactsAttributesDto}
   */
  ArtifactsAttributesDto create(ArtifactsAttributesCreateDto artifactsAttributesCreateDto);

  /**
   * Возвращает список всех связей артефакта и атрибута {@link ArtifactsAttributesDto}
   *
   * @return связи артефактов и атрибутов {@link ArtifactsAttributesDto}
   */
  List<ArtifactsAttributesDto> getAll();

  /**
   * Возвращает связь артефакта и атрибута {@link ArtifactsAttributesDto} по индивидуальному
   * идентификатору связи артефакта и атрибута {@link Integer}
   *
   * @param id индивидуальный идентификатор связи артефакта и атрибута {@link Integer}
   * @return связь артефакта и атрибута {@link ArtifactsAttributesDto}
   */
  ArtifactsAttributesDto getById(Integer id);

  /**
   * Обновляет связь артефакта и атрибута {@link ArtifactsAttributes} из запроса {@link
   * ArtifactsAttributesUpdateDto}
   *
   * @param artifactsAttributesUpdateDto запрос по обновлению связи артефакта и атрибута {@link }
   * @return обновленная связь артефакта и атрибута {@link ArtifactsAttributesDto}
   */
  ArtifactsAttributesDto update(ArtifactsAttributesUpdateDto artifactsAttributesUpdateDto);

  /**
   * Удаляет связь артефакта и атрибута {@link } по индивидуальному идентификатору связи артефакта и
   * атрибута {@link Integer}
   *
   * @param id индивидуальный идентификатор связи артефакта и атрибута {@link Integer}
   */
  void deleteById(Integer id);
}
