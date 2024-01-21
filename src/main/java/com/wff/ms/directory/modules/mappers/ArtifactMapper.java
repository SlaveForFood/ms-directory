package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.ArtifactCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactClassDto;
import com.wff.ms.directory.models.dto.response.ArtifactDto;
import com.wff.ms.directory.models.dto.response.ArtifactTypeDto;
import com.wff.ms.directory.models.dto.update.ArtifactUpdateDto;
import com.wff.ms.directory.models.entity.Artifact;
import com.wff.ms.directory.models.entity.ArtifactClass;
import com.wff.ms.directory.models.entity.ArtifactType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Маппер преобразующий сущность {@link Artifact}
 *
 * @author Orlov
 * @since 01.2024
 */
@Mapper
public interface ArtifactMapper {

  /**
   * Возвращает сущность артефакта {@link Artifact}, заполненную согласно полям дто для создания
   * артефакта {@link ArtifactCreateDto}
   *
   * @param artifactCreateDto dto создания артефакта {@link ArtifactCreateDto}
   * @return сущность обращения {@link Artifact}
   */
  Artifact artifactCreateDtoToArtifact(ArtifactCreateDto artifactCreateDto);

  /**
   * Обновляет поля в сущности артефакта {@link Artifact} согласно указанным ненулевым полям из дто
   * обновления обращения {@link ArtifactUpdateDto}
   *
   * @param artifactUpdateDto дто обновления обращения {@link ArtifactUpdateDto}
   * @param artifact сущность артефакт {@link Artifact}
   */
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateArtifact(ArtifactUpdateDto artifactUpdateDto, @MappingTarget Artifact artifact);

  /**
   * Возвращает дто для передачи информации об артефакте {@link ArtifactDto}, сформированную из
   * сущности артефакта {@link Artifact}
   *
   * @param artifact сущность артефакта {@link Artifact}
   * @return дто для передачи информации об артефакте {@link ArtifactDto}
   */
  ArtifactDto artifactToArtifactDto(Artifact artifact);

  /**
   * Возвращает дто для передачи информации о типе артефакте {@link ArtifactTypeDto}, сформированную
   * из сущности типа артефакта {@link ArtifactType}
   *
   * @param type сущность типа артефакта {@link ArtifactType}
   * @return дто для передачи информации о типе артефакте {@link ArtifactTypeDto}
   */
  ArtifactTypeDto artifactTypeToArtifactTypeDto(ArtifactType type);

  /**
   * Возвращает дто для передачи информации о классе артефакта {@link ArtifactClassDto},
   * сформированную из сущности класса артефакта {@link ArtifactClass}
   *
   * @param clazz сущность класса артефакта {@link ArtifactClass}
   * @return дто для передачи информации о классе артефакте {@link ArtifactClassDto}
   */
  ArtifactClassDto artifactClassToArtifactClassDto(ArtifactClass clazz);
}
