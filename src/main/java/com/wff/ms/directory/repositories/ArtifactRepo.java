package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия с сущностями артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactRepo extends JpaRepository<Artifact, Integer> {}
