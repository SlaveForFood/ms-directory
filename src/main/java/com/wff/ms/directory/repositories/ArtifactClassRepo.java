package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.ArtifactClass;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для взаимодействия с сущностями классов артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
public interface ArtifactClassRepo extends JpaRepository<ArtifactClass, Integer> {

  Optional<ArtifactClass> findByNameLikeIgnoreCase(String name);
}
