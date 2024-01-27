package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.HeroesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesAttributesDto;
import com.wff.ms.directory.models.dto.update.HeroesAttributesUpdateDto;
import com.wff.ms.directory.models.entity.HeroesAttributes;
import java.util.List;

/**
 * Интерфейс по работе со связью героев и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface HeroesAttributesService {
  /**
   * Создает связь героя и атрибута {@link HeroesAttributes} из запроса {@link
   * HeroesAttributesCreateDto}
   *
   * @param heroesAttributesCreateDto запрос по созданию связи героя и атрибута {@link
   *     HeroesAttributesCreateDto}
   * @return dto созданного связи героя и атрибута {@link HeroesAttributesDto}
   */
  HeroesAttributesDto create(HeroesAttributesCreateDto heroesAttributesCreateDto);

  /**
   * Возвращает список всех связей героя и атрибута {@link HeroesAttributesDto}
   *
   * @return связи героев и атрибутов {@link HeroesAttributesDto}
   */
  List<HeroesAttributesDto> getAll();

  /**
   * Возвращает связь героя и атрибута {@link HeroesAttributesDto} по индивидуальному идентификатору
   * связи героя и атрибута {@link Integer}
   *
   * @param id индивидуальный идентификатор связи героя и атрибута {@link Integer}
   * @return связь героя и атрибута {@link HeroesAttributesDto}
   */
  HeroesAttributesDto getById(Integer id);

  /**
   * Обновляет связь героя и атрибута {@link HeroesAttributes} из запроса {@link
   * HeroesAttributesUpdateDto}
   *
   * @param heroesAttributesCreateDto запрос по обновлению связи героя и атрибута {@link }
   * @return обновленная связь героя и атрибута {@link HeroesAttributesDto}
   */
  HeroesAttributesDto update(HeroesAttributesUpdateDto heroesAttributesCreateDto);

  /**
   * Удаляет связь героя и атрибута {@link } по индивидуальному идентификатору связи героя и
   * атрибута {@link Integer}
   *
   * @param id индивидуальный идентификатор связи героя и атрибута {@link Integer}
   */
  void deleteById(Integer id);
}
