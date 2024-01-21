package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.ArtifactType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия с сущностями типов артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactTypeRepo extends JpaRepository<ArtifactType, Integer> {

  Optional<ArtifactType> findByNameLikeIgnoreCase(String name);
}
