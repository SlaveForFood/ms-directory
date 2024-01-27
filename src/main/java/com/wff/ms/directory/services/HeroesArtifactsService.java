package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.HeroesArtifactsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesArtifactsDto;
import com.wff.ms.directory.models.dto.update.HeroesArtifactsUpdateDto;
import com.wff.ms.directory.models.entity.HeroesArtifacts;
import java.util.List;

/**
 * Интерфейс по работе со связью герои-артефакты
 *
 * @author Orlov
 * @since 01.2024
 */
public interface HeroesArtifactsService {

  /**
   * Создает связь героя и артефакта {@link HeroesArtifacts} из запроса {@link
   * HeroesArtifactsCreateDto}
   *
   * @param heroesArtifactsCreateDto запрос по созданию связи героя и артефакта {@link
   *     HeroesArtifactsCreateDto}
   * @return dto созданного связи героя и артефакта {@link HeroesArtifactsDto}
   */
  HeroesArtifactsDto create(HeroesArtifactsCreateDto heroesArtifactsCreateDto);

  /**
   * Возвращает список всех связей героя и артефакта {@link HeroesArtifactsDto}
   *
   * @return связи героев и атрибутов {@link HeroesArtifactsDto}
   */
  List<HeroesArtifactsDto> getAll();

  /**
   * Возвращает связь героя и артефакта {@link HeroesArtifactsDto} по индивидуальному идентификатору
   * связи героя и артефакта {@link Integer}
   *
   * @param id индивидуальный идентификатор связи героя и артефакта {@link Integer}
   * @return связь героя и артефакта {@link HeroesArtifactsDto}
   */
  HeroesArtifactsDto getById(Integer id);

  /**
   * Обновляет связь героя и артефакта {@link HeroesArtifacts} из запроса {@link
   * HeroesArtifactsUpdateDto}
   *
   * @param heroesArtifactsCreateDto запрос по обновлению связи героя и артефакта {@link }
   * @return обновленная связь героя и артефакта {@link HeroesArtifactsDto}
   */
  HeroesArtifactsDto update(HeroesArtifactsUpdateDto heroesArtifactsCreateDto);

  /**
   * Удаляет связь героя и артефакта {@link } по индивидуальному идентификатору связи героя и
   * артефакта {@link Integer}
   *
   * @param id индивидуальный идентификатор связи героя и артефакта {@link Integer}
   */
  void deleteById(Integer id);
}
