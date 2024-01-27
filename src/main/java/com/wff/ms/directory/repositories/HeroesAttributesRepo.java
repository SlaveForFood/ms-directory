package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.HeroesAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия со связью сущностей героев и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface HeroesAttributesRepo extends JpaRepository<HeroesAttributes, Integer> {}
