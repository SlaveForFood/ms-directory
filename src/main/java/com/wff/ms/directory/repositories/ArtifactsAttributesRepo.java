package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.ArtifactsAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия со связью сущностей артефактов и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactsAttributesRepo extends JpaRepository<ArtifactsAttributes, Integer> {}
