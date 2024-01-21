package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.HeroesArtifacts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия с сущностями связей героев и артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface HeroesArtifactsRepo extends JpaRepository<HeroesArtifacts, Integer> {}
